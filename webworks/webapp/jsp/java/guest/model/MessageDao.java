package guest.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessageDao {

	// Single Pattern 
	private static MessageDao instance;
	
	// DB 연결시  관한 변수 
	// [ 오라클 ]
	//private static final String 		dbDriver	=	"oracle.jdbc.driver.OracleDriver";
	//private static final String		dbUrl		=	"jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	//private static final String		dbUser		=	"scott";
	//private static final String		dbPass		=	"tiger";
	
	// [ MySQL / MariaDB ]
	private static final String 	dbDriver	=	"com.mysql.cj.jdbc.Driver";
	private static final String		dbUrl		=	"jdbc:mysql://127.0.0.1:3306/review";
	private static final String		dbUser		=	"scott";
	private static final String		dbPass		=	"tiger";
	
	
	//--------------------------------------------
	//#####	 객체 생성하는 메소드 
	public static MessageDao	getInstance() throws MessageException
	{
		if( instance == null )
		{
			instance = new MessageDao();
		}
		return instance;
	}
	
	private MessageDao() throws MessageException
	{
	
		try{
			
			/********************************************
				1. 오라클 드라이버를 로딩
						
			*/
			Class.forName(dbDriver);
			
		}catch( Exception ex ){
			throw new MessageException("방명록 ) DB 연결시 오류  : " + ex.toString() );	
		}
		
	}
	
	
	/*
	 * 메세지를 입력하는 함수
	 */
	public void insert(Message rec) throws MessageException
	{
		Connection	 		con  = null;
		PreparedStatement 	ps	 = null;
		try{
			// 1. 연결객체(Connection) 얻어오기
			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
			// 2. sql 문장 만들기
			String sql = "INSERT guesttb(MESSAGE_ID,GUEST_NAME,PASSWORD,MESSAGE) "
					+ " VALUES(?,?,?,?)";
			// 3. 전송객체 얻어오기
			ps	= con.prepareStatement( sql );
			ps.setInt(1,rec.getMessageId());
			ps.setString(2,rec.getGuestName());
			ps.setString(3,rec.getPassword());
			ps.setString(4,rec.getMessage());
			// 4. 전송하기
			ps.executeUpdate();
		
				
		}catch( Exception ex ){
			throw new MessageException("방명록 ) DB에 입력시 오류  : " + ex.toString() );	
		} finally{
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}
	
	}
	
	/*
	 * 메세지 목록 전체를 얻어올 때
	 */
	public List<Message> selectList() throws MessageException
	{
		Connection	 			con 	= null;
		PreparedStatement 		ps 		= null;
		ResultSet 				rs 		= null;
		List<Message> 			mList 	= new ArrayList<Message>();
		boolean 				isEmpty = true;
		
		try{
			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
			
			String sql = "  SELECT * "
						+"	FROM guesttb ";

			ps	= con.prepareStatement( sql );
			rs  = ps.executeQuery();
			
			while(rs.next()) {
				isEmpty = false;
				Message m = new Message();
				m.setMessageId(rs.getInt("message_id"));
				m.setGuestName(rs.getString("GUEST_NAME"));
				m.setPassword(rs.getString ("password"));;
				m.setMessage(rs.getString("message"));
				mList.add(m);
			}
			
			if( isEmpty ) return Collections.emptyList();
			
			return mList;
		}catch( Exception ex ){
			throw new MessageException("방명록 ) DB에 목록 검색시 오류  : " + ex.toString() );	
		} finally{
			if( rs   != null ) { try{ rs.close();  } catch(SQLException ex){} }
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}		
	}
	

	/* -------------------------------------------------------
	 * 현재 페이지에 보여울 메세지 목록  얻어올 때
	 */
	public List<Message> selectList(int firstRow, int endRow) throws MessageException{
		Connection	 		con 	= null;
		PreparedStatement 	ps 		= null;
		ResultSet 			rs 		= null;
		List<Message> 		mList	= new ArrayList<Message>();
		boolean isEmpty 	= true;
		
		try{
			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
			
			String sql 		= " select e.* from (select * from guesttb order by MESSAGE_ID desc) e limit ?, ? ";

			ps	= con.prepareStatement( sql );
			ps.setInt(1, firstRow);
			ps.setInt(2, endRow);
			rs  = ps.executeQuery();
			
			while(rs.next()) {
				isEmpty = false;
				Message m = new Message();
				m.setMessageId(rs.getInt("message_id"));
				m.setGuestName(rs.getString("GUEST_NAME"));
				m.setPassword(rs.getString ("password"));;
				m.setMessage(rs.getString("message"));
				mList.add(m);
			}
			if( isEmpty ) return Collections.emptyList();
			return mList;
			}catch( Exception ex ){
			throw new MessageException("방명록 ) DB에 목록 검색시 오류  : " + ex.toString() );	
		} finally{
			if( rs   != null ) { try{ rs.close();  } catch(SQLException ex){} }
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}	
		
	}	
	
	
	/* -------------------------------------------------------
	 * 메세지 전체 레코드 수를 검색
	 */
	
	public int getTotalCount() throws MessageException{
		Connection	 		con 	= null;
		PreparedStatement 	ps 		= null;
		ResultSet 			rs 		= null;
		int 				count 	= 0;

		try{
			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
			
			String sql = "  SELECT  count(*) as cnt " 
						+"	FROM 	guesttb ";
			//자동증가 함수 기준으로 하면 삭제 된후에 페이지를 줄이지 못한다.
			ps	= con.prepareStatement( sql );
			rs  = ps.executeQuery();
			rs.next();
			count = rs.getInt("cnt");
	
			return  count;
			
		}catch( Exception ex ){
			throw new MessageException("방명록 ) DB에 목록 검색시 오류  : " + ex.toString() );	
		} finally{
			if( rs   != null ) { try{ rs.close();  } catch(SQLException ex){} }
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}			
	}
	
	/*
	 * 메세지 번호와 비밀번호에 의해 메세지 삭제
	 */
	public int delete( int messageId, String password ) throws MessageException
	{
		int 			  result = 0;
		Connection	 	  con 	 = null;
		PreparedStatement ps 	 = null;
		try{
			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
			
			String sql =  " DELETE FROM guestTb 	"
						+ " WHERE message_id=? 		"
						+ " 	  and password=?	";
			
			ps	= con.prepareStatement( sql );
				ps.setInt(1, messageId);
				ps.setString(2,password);
				result = ps.executeUpdate();
			
			return result;
			
		}catch( Exception ex ){
			throw new MessageException("방명록 ) DB에 삭제시 오류  : " + ex.toString() );	
		} finally{
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}		
	}
}
