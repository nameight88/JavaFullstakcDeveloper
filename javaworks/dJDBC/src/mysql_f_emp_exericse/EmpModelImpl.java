package mysql_f_emp_exericse;

import java.sql.*;
import java.util.*;

import e_info.InfoVo;
// 외부 프로그램와 연동을 할때는 무조건 예외처리를 해주어야한다.
public class EmpModelImpl implements EmpModel{
	
	String driver = "com.mysql.cj.jdbc.Driver"; 
	String url = "jdbc:mysql://localhost:3306/basic"; 
	String user = "scott";
	String  pass = "tiger"; 
	//DB연동에 필요한 변수들을 설정 및 선언으로 초기화를 해준다.
	
	Connection con = null;// try catch 로 예외처리를 해줄것이기 때문에 지역 변수를 먼저 선언을 해준다
	// 그리고 class 안에서 맴버 변수를 선언및 호출을 해준다.
	/*---------------------------------------------
	 * 생성자 함수 
	 	1. DB 연동
	 		- 드라이버 등록
	*/
	
	public EmpModelImpl() throws Exception{
		Class.forName(driver);
	}



	
	/*-------------------------------------------------------
	* insert() :  입력한 값 받아서 데이타베이스에 추가
		0. 연결객체 얻어오기
		1. sql문 만들기 ( insert 구문 )
		2. PreparedStatement 객체 생성 
		3. PreparedStatement에 인자 지정
		4. sql문 전송 ( executeUpdate() 이용 )
		5. PreparedStatement 닫기
		6. 연결 닫기
	*/
	public void insert( EmpVO r ) throws SQLException{	
		con = DriverManager.getConnection(url, user, pass);
		
		String sql = "INSERT INTO"
				+ "	emp( EMPNO, ENAME, SAL, JOB) "
				+ " VALUES( ?,?,?,?)";
		PreparedStatement ps =  con.prepareStatement(sql);
		ps.setInt(1,r.getEmpno());
		ps.setString(2,r.getEname());
		ps.setInt(3,r.getSal());
		ps.setString(4,r.getJob());
		
		ps.executeUpdate();
		
		con.close();
	}


	/*-------------------------------------------------------
	* modify() : 화면 입력값 받아서 수정
		0. 연결객체 얻어오기
		1. sql문 만들기 ( update 구문 )
		2. PreparedStatement 객체 생성 ( 또는 Statement )
		3. PreparedStatement에 인자 지정
		4. sql문 전송 ( executeUpdate() 이용 )
		5. PreparedStatement 닫기
		6. 연결 닫기
	*/
	public void modify(EmpVO r) throws SQLException {
	    Connection con = null;
	    PreparedStatement ps = null;

	    try {
	        // 1. 연결 객체 얻어오기
	        con = DriverManager.getConnection(url, user, pass);
	        // 2. SQL 문 생성
	        String sql = "UPDATE emp "
	                   + "SET ENAME=?, SAL=?, JOB=? "
	                   + "WHERE EMPNO = ?";

	        ps = con.prepareStatement(sql);
	        ps.setString(1, 	r.getEname());
	        ps.setInt	(2, 	r.getSal());
	        ps.setString(3, 	r.getJob());
	        ps.setInt	(4, 	r.getEmpno());
	    
	        ps.executeUpdate();
	    } finally {
	    	con.close();
	        } 
	    
	        
	    }
	

	
	/*-------------------------------------------------------
	* selectByEmpno() :  입력받은 사번을 받아서 해당 레코드 검색
		0. 연결객체 얻어오기
		1. sql문 만들기 ( select 구문 )
		2. PreparedStatement 객체 얻기 ( Statement  가능 )
		4. sql문 전송 ( executeQuery() 이용 )
		5. 결과집합(ResultSet)에서 값을 읽어서 EmpVO에 저장
		6. ResultSet/ PreparedStatement 닫기
		7. 연결 닫기
		8. EmpVO 객체 리턴
	*/	
	public EmpVO selectByEmpno( int empno ) throws SQLException{
		EmpVO vo = new EmpVO();
		Connection con = null;
		try {

			con = DriverManager.getConnection(url, user, pass);
			String sql = " SELECT *"
					+ " FROM emp"
					+ " WHERE empno = ?";


			PreparedStatement ps =  con.prepareStatement(sql);
			ps.setInt	(1,empno);

			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				vo.setEname(rs.getString("ENAME"));
				vo.setEmpno(rs.getInt("EMPNO"));
				vo.setSal(rs.getInt("SAL"));
				vo.setJob(rs.getString("JOB"));
				
			}
		}finally {
			con.close();
		}
		return vo;	
	}
	
	/*--------------------------------------------------------
	* delete() : 사원번호 값을 받아 해당 레코드 삭제
		0. 연결객체 얻어오기
		1. sql문 만들기 ( delete 구문 )
		2. PreparedStatement 객체 얻기
		3. sql문 전송 ( executeUpdate() 이용 )
		4. PreparedStatement 닫기
		5. 연결 닫기
	*/
	public int delete( int empno ) throws SQLException{
		Connection con = null;
		int resultCnt = 0;	
		try {
			con = DriverManager.getConnection(url, user, pass);
			
			String sql = "DELETE FROM emp WHERE empno = ?";
			
			PreparedStatement ps =  con.prepareStatement(sql);
			ps.setInt(1, empno);
			resultCnt = ps.executeUpdate();
			
		}
		finally {
			con.close();
		}
		

		return resultCnt;
	}
	
	/*-------------------------------------------------------
	* selectAll() :  전체 레코드 검색
		0. 연결객체 얻어오기
		1. sql문 만들기 ( select 구문 )
		2. PreparedStatement 객체 얻기 ( Statement  가능 )
		4. sql문 전송 ( executeQuery() 이용 )
		5. 결과집합(ResultSet)에서 값을 읽어서 ArrayList에 저장
		6. ResultSet/ PreparedStatement 닫기
		7. 연결 닫기
		8. ArrayList 객체 리턴
	*/	
	public ArrayList<EmpVO> selectAll() throws SQLException {
	    ArrayList<EmpVO> list = new ArrayList<EmpVO>();
	    Connection con = null;
	

	    try {
	        con = DriverManager.getConnection(url, user, pass);
	        String sql = "SELECT * FROM emp";	       
	        PreparedStatement ps =  con.prepareStatement(sql);	     
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            EmpVO vo = new EmpVO();
	            vo.setEmpno(rs.getInt	("empno"));
	            vo.setEname(rs.getString("ename"));
	            vo.setSal(rs.getInt		("sal"));
	            vo.setJob(rs.getString	("job"));
	            list.add(vo);
	        }
	    } finally {
	    	   con.close();
	    }
	    return list;
	}


}