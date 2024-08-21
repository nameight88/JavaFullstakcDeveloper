package info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InfoDAO {

	private static InfoDAO  instance;

	// DB 연결시  관한 변수  
	private static final String 	dbDriver	=	"com.mysql.cj.jdbc.Driver";
	private static final String		dbUrl		=	"jdbc:mysql://localhost:3306/basic";
	private static final String		dbUser		=	"scott";
	private static final String		dbPass		=	"tiger";


	private InfoDAO() throws Exception {
		Class.forName( dbDriver );	
	}

	public static InfoDAO getInstance( ) throws Exception {
		if( instance == null )
		{
			instance = new InfoDAO();
		}
		return instance;
	}
	/*
	 * 함수명
	 * 인자
	 * 리턴값
	 * 역할
	 */
	
	public boolean loginCheck(InfoVO vo) throws Exception{
		Connection	con = null;	//성공유무와 별개로 무조건 닫아주어야한다.
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		boolean result = false;

		try {
			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );

			String sql = "SELECT * FROM emp "
					+ "WHERE ename = ? AND empno = ? ";

			ps	= con.prepareStatement( sql );
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				result = true;
			}
		}catch( Exception ex ){
			throw new Exception("사원정보 ) DB에 입력시 오류  : " + ex.toString() );	
		} finally{
			if( rs   != null ) { try{ rs.close();  } catch(SQLException ex){} }
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}
		return result;

	}
	
	
	
	public void insertEmp(InfoVO vo) throws Exception {
		Connection	con = null;	//성공유무와 별개로 무조건 닫아주어야한다.
		ResultSet rs = null;
		Statement stmt	= null;
		PreparedStatement ps = null;
		try{
			// 1. 연결객체 얻어오기
			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
			// 2. sql 문장 만들기
			String sql		= " INSERT INTO emp(empno,ename,deptno,sal,job)"
					+ " VALUES(?,?,?,?,?)";  
			// 3. 전송객체 얻어오기 + ? 지정
			ps	= con.prepareStatement( sql );
			


			// 4. 전송하기
			ps.executeUpdate();

		}catch( Exception ex ){
			throw new Exception("사원정보 ) DB에 입력시 오류  : " + ex.toString() );	
		} finally{
			if( rs   != null ) { try{ rs.close();  } catch(SQLException ex){} }
			if( stmt != null ) { try{ stmt.close(); } catch(SQLException ex){} }
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}
	}
	public List<InfoVO> selectEmp() throws Exception{
		Connection	con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<InfoVO> list = new ArrayList<InfoVO>();
		try {
			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
			String sql = " SELECT empno , ename , deptno , job "
					+ " FROM emp ";
			ps	= con.prepareStatement( sql );
			rs  = ps.executeQuery();
			while(rs.next()) {
				InfoVO emp = new InfoVO();
				
				list.add(emp);
			}
			
		}catch( Exception ex ){
			throw new Exception("사원정보 ) DB에 입력시 오류  : " + ex.toString() );	
		} finally{
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}
		return list;	
	}
 
}

