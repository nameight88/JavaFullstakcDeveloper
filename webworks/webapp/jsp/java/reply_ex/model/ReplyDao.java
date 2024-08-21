package reply_ex.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import reply_ex.model.ReplyDao;
import reply_ex.model.ReplyException;
import reply_ex.model.ReplyVO;

public class ReplyDao
{
   
   // Single Pattern 
   private static ReplyDao instance;
   
   // DB 연결시  관한 변수 
   // [ 오라클 ]
   //private static final String       dbDriver   =   "oracle.jdbc.driver.OracleDriver";
   //private static final String      dbUrl      =   "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
   //private static final String      dbUser      =   "scott";
   //private static final String      dbPass      =   "tiger";
   
   // [ MySQL / MariaDB ]
   private static final String    dbDriver   =   "com.mysql.cj.jdbc.Driver";
   private static final String      dbUrl      =   "jdbc:mysql://127.0.0.1:3306/review";
   private static final String      dbUser      =   "scott";
   private static final String      dbPass      =   "tiger";
   
   
   private Connection          con;   
   
   //--------------------------------------------
   //#####    객체 생성하는 메소드 
   public static ReplyDao   getInstance() throws ReplyException
   {
      if( instance == null )
      {
         instance = new ReplyDao();
      }
      return instance;
   }
   
   private ReplyDao() throws ReplyException
   {
   
      try{
         
         /********************************************
         1. 오라클 드라이버를 로딩
            ( DBCP 연결하면 삭제할 부분 )
      */
         Class.forName( dbDriver );   
      }catch( Exception ex ){
         throw new ReplyException("DB 연결시 오류  : " + ex.toString() );   
      }
      
   }
   
   /************************************************
    * 함수명 : insert
    * 역할 :   게시판에 글을 입력시 DB에 저장하는 메소드 
    * 인자 :   BoardVO
    * 리턴값 : 입력한 행수를 받아서 리턴
   */
   public int insert( ReplyVO rec ) throws ReplyException
   {

      ResultSet rs = null;
      Statement stmt   = null;
      PreparedStatement ps = null;
      try{

         con   = DriverManager.getConnection( dbUrl, dbUser, dbPass );
         
         //* sql 문장 만들기
         String putQuery      = "INSERT INTO board_ex"
         		+ " (title, writer,content,regdate,cnt,pass)  "
               + " VALUES (?,?,?,now(),0,?) ";  
         //mysql은 자동증가수가 있으면 그 변수를 쓰면 안된다.
         //now()말고도 sysdate()를 사용해도 된다.
         ps      = con.prepareStatement( putQuery );
         //* sql 문장의 ? 지정하기
      
         
   
         //int insertedCount = ps.executeUpdate();         
        // return insertedCount; 변수에 넣고 리턴 하는 방식
         
         return ps.executeUpdate();//변수를 선언하지 않고 바로 보내는 방식 (한번만 쓰이는 경우에 용이하다)
      
      }catch( Exception ex ){
         throw new ReplyException("게시판 ) DB에 입력시 오류  : " + ex.toString() );   
      } finally{
         if( rs   != null ) { try{ rs.close();  } catch(SQLException ex){} }
         if( stmt != null ) { try{ stmt.close(); } catch(SQLException ex){} }
         if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
         if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
      }
      
   }


   /************************************************
    * 함수명 : selectList
    * 역할 :   전체 레코드를 검색하는 함수
    * 인자 :   없음
    * 리턴값 : 테이블의 한 레코드를 BoardVO 지정하고 그것을 ArrayList에 추가한 값
   */

   public List<ReplyVO> selectList() throws ReplyException
   {
      PreparedStatement ps = null;
      ResultSet rs = null;
      List<ReplyVO> mList = new ArrayList<ReplyVO>();
      boolean isEmpty = true;
      
      try{
         con   = DriverManager.getConnection( dbUrl, dbUser, dbPass );
         
         // * sql 문장만들기
         String sql = "SELECT * FROM board_ex";
         // * 전송객체 얻어오기
         ps= con.prepareStatement(sql);
         // * 전송하기
         rs = ps.executeQuery();
         // * 결과 받아 List<BoardVO> 변수 mList에 지정하기
         while(rs.next()) {
            isEmpty =false;

            ReplyVO vo = new ReplyVO();
         
            
            mList.add(vo);
         }
         if( isEmpty ) return Collections.emptyList();
         
         return mList;
      }catch( Exception ex ){
         throw new ReplyException("게시판 ) DB에 목록 검색시 오류  : " + ex.toString() );   
      } finally{
         if( rs   != null ) { try{ rs.close();  } catch(SQLException ex){} }
         if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
         if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
      }      
   }
   
   //--------------------------------------------
   //#####    게시글번호에 의한 레코드 검색하는 함수
   public ReplyVO selectById(int seq) throws ReplyException
   {
      PreparedStatement ps = null;
      ResultSet rs = null;
      
      ReplyVO rec = new ReplyVO();
      try{

         con   = DriverManager.getConnection( dbUrl, dbUser, dbPass );
         // * sql 문장만들기
         String sql = " SELECT *"
         		+ "	FROM board_ex "
         		+ " WHERE seq= ? ";
         // * 전송객체 얻어오기
         ps= con.prepareStatement(sql);
         ps.setInt(1, seq);
         // * 전송하기
         rs = ps.executeQuery();
       while(rs.next()){
        	
       		}
         // * 결과 받아 BoardVO변수 rec에 지정하기
         return rec;
      }catch( Exception ex ){
         throw new ReplyException("게시판 ) DB에 글번호에 의한 레코드 검색시 오류  : " + ex.toString() );   
      } finally{
         if( rs   != null ) { try{ rs.close();  } catch(SQLException ex){} }
         if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
         if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
      }      
   }

   //--------------------------------------------
   //#####    게시글 보여줄 때 조회수 1 증가
   public void increaseReadCount( int seq ) throws ReplyException
   {

      PreparedStatement ps = null;
      try{
/*
         con   = DriverManager.getConnection( dbUrl, dbUser, dbPass );
         // * sql 문장만들기
         String sql = " UPDATE FROM board_ex"
         		+ " SET cnt =+1 "
         		+ " WHERE seq = ? ";
         
         // * 전송객체 얻어오기
         ps= con.prepareStatement(sql);
         ps.setInt(1, seq);
         // * 전송하기
         ps.executeQuery();
         */
      }catch( Exception ex ){
         throw new ReplyException("게시판 ) 게시글 볼 때 조회수 증가시 오류  : " + ex.toString() );   
      } finally{
         if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
         if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
      }
      
   }
   //--------------------------------------------
   //#####    게시글 수정할 때
   public int update( ReplyVO rec ) throws ReplyException
   {

      PreparedStatement ps = null;
      try{

         con   = DriverManager.getConnection( dbUrl, dbUser, dbPass );
         // * sql 문장만들기
         String sql = " UPDATE board_ex"
         		+ "	SET title=?, content=?"
         		+ " WHERE seq=? AND pass=?";
         // * 전송객체 얻어오기
         ps=con.prepareStatement(sql);
        
        
         return ps.executeUpdate();
      
      }catch( Exception ex ){
         throw new ReplyException("게시판 ) 게시글 수정시 오류  : " + ex.toString() );   
      } finally{
         if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
         if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
      }
      
   }
   
   
   //--------------------------------------------
   //#####    게시글 삭제할 때
   public int delete( int seq, String password ) throws ReplyException
   {
	   int result = 0;
      PreparedStatement ps = null;
      try{

         con   = DriverManager.getConnection( dbUrl, dbUser, dbPass );
      
         // * sql 문장만들기
         String sql = " DELETE FROM board_ex"
         		+ " WHERE 	seq = ? "
         		+ " AND 	pass = ? ";
         // * 전송객체 얻어오기
         ps = con.prepareStatement(sql);
         ps.setInt(1, seq);
         ps.setString(2, password);
         result = ps.executeUpdate();
         return result;
         
      }catch( Exception ex ){
         throw new ReplyException("게시판 ) 게시글 수정시 오류  : " + ex.toString() );   
      } finally{
         if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
         if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
      }
      
   }
   
   
   
   // 페이징 총 갯수
   public int getTotalCount() throws ReplyException{
      Connection          con = null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      int count = 0;
      
      try{
         con   = DriverManager.getConnection( dbUrl, dbUser, dbPass ); 
         String sql = "SELECT count(*) as cnt FROM board_ex ";
         ps = con.prepareStatement(sql);
         rs = ps.executeQuery();
         if(rs.next()) {
            count = rs.getInt("cnt");
         }

         return  count;

      }catch( Exception ex ){
         throw new ReplyException("getTotalCount ) 게시글페이지  : " + ex.toString() );   
      } finally{
         if( rs   != null ) { try{ rs.close();  } catch(SQLException ex){} }
         if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
         if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
      }
      
   }
   
   
   // 페이징 3개씩 나눈 부분
   public List<ReplyVO> selectList(int start, int end) throws ReplyException{
      Connection          con = null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      List<ReplyVO> mList = new ArrayList<ReplyVO>();
      boolean isEmpty = true;

      try{
         // 1. 연결객체(Connection) 얻어오기
         con   = DriverManager.getConnection( dbUrl, dbUser, dbPass ); 
         // 2. sql 문장 만들기
         String sql = " SELECT e.* "
               + " FROM (SELECT * FROM board_ex ORDER BY seq DESC) e "
               + " LIMIT ?, ? ";
         // 3. 전송객체 얻어오기
         ps = con.prepareStatement(sql);
         ps.setInt(1, start);
         ps.setInt(2, end);
         
         rs = ps.executeQuery();

         while(rs.next()) {
            isEmpty =false;

            ReplyVO vo = new ReplyVO();
          
            
            mList.add(vo);
         }
         if( isEmpty ) return Collections.emptyList();

         return mList;
      }catch( Exception ex ){
         throw new ReplyException(" 게시글 페이징 ) DB에 목록 검색시 오류  : " + ex.toString() );   
      } finally{
         if( rs   != null ) { try{ rs.close();  } catch(SQLException ex){} }
         if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
         if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
      }
      
   }
   
   
}