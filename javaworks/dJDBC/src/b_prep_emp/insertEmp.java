package b_prep_emp;

import java.sql.*;

// statement 는 sql 말고도 정말 많이 있기 때문에 패키지 소속을 확인을 해야한다.

public class insertEmp {

	public static void main(String[] args) {
		//0. 필요한 변수를 선언 미리 선언
		String driver = "com.mysql.cj.jdbc.Driver"; 
		String url = "jdbc:mysql://114.207.167.66:3306/basic"; 
		String user = "scott";
		String pass  = "tiger";
		try {
		// 1.드라이버를 메모리 로딩
		Class.forName(driver);
		System.out.println("드라이버 연결");
		
		// 2.연결 객체 얻어오기
		
		Connection con = DriverManager.getConnection(url,user,pass);
		System.out.println("DB 연결 성공"); // import java.sql 로 모듈을 불러와줘야한다.
		
		// 사용자 입력값을 받는다고 가정
		int sabun = 4321;
		String sname = "로켓2";
		String sjob = "개발";
		int ssal = 10000;
		int smgr = 7788;
		int sdeptno = 30;
		
		
		//3.SQL 문장 만들기      3번 문장이 중요하다
		String sql = "INSERT     " 
				+ "INTO emp(empno, ename, job, sal, mgr, deptno) "
				+ "VALUES(?,?,?,?,?,?)";  // 들어가는 문장을 미완성 처리를 해서 미완성된 SQL문장으로 생성한다.
		System.out.println(sql);
		
		//4.SQL 전송 객체 얻어오기
		/*
		 *  -Statement			:완성된 SQL을 전송할 때
		 *  -PreparedStatement	:미완성된 SQL을 전송할 때 
		 *  -CallableStatement	:pl-sql(function/procedure)호출 할때 -> 지금 교육과정에서는 잘 쓰이진 않는다.
		 */
		
		PreparedStatement ps = con.prepareStatement(sql); // sql을 여기서 먼저 가져가야한다.
		ps.setInt(1,sabun);
		ps.setString(2,sname);
		ps.setString(3,sjob);
		ps.setInt(4,ssal);
		ps.setInt(5,smgr);
		ps.setInt(6,sdeptno);
		//5.전송
		
		ps.executeUpdate();
		// SELECT 인경우 stmt.ExecuteQuery();
		System.out.println("SQL 전송");
		//6. 닫기
		
		ps.close();
		ps.close();
		
		
		}catch(Exception ex) {
			System.out.println("실패" + ex.getMessage()); 
		}
	}

}
