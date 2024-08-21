package a_stat_emp;

import java.sql.*;

// statement 는 sql 말고도 정말 많이 있기 때문에 패키지 소속을 확인을 해야한다.

public class insertEmp {

	public static void main(String[] args) {
		//0. 필요한 변수를 선언 미리 선언
		String driver = "com.mysql.cj.jdbc.Driver"; // Driver는 class 이므로 대문자를 해줘야한다.
		String url = "jdbc:mysql://114.207.167.66:3306/basic"; //localhost 말고도 ip주소를 입력을 해도 연결은 똑같이 된다.
		// employees를 사용하고 싶으면 advance로 변경
		// 다른 사람에 ip주소를 입력을 해도 전송이 가능하다.
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
		int sabun = 5699;
		String sname = "로켓";
		String sjob = "개발";
		
		//3.SQL 문장 만들기      3번 문장이 중요하다
		String sql = "INSERT     "  // 앞뒤 여백을 넉넉하게 줘야한다.
				+ "INTO emp(empno, ename, job) "
				+ "VALUES("+ sabun+", '" +sname+"', '"+ sjob+"')";  //values에서 값을 넣을때 '를 사용을 해줘야한다.
		System.out.println(sql);
		
		//4.SQL 전송 객체 얻어오기
		/*
		 *  -Statement			:완성된 SQL을 전송할 때
		 *  -PreparedStatement	:미완성된 SQL을 전송할 때 
		 *  -CallableStatement	:pl-sql(function/procedure)호출 할때 -> 지금 교육과정에서는 잘 쓰이진 않는다.
		 */
		
		Statement stmt = con.createStatement();
		//5.전송
		/*
		 *  -int executeUpdate() 		 :INSERT, UPDATE, DELETE, DDL
		 *  -Resultset ExecuteQuery()	 :SELECT 
		 *  SELECT 는 결과가 바뀌기 때문
		 */
		
		stmt.executeUpdate(sql);
		// SELECT 인경우 stmt.ExecuteQuery();
		System.out.println("SQL 전송");
		//6. 닫기
		
		stmt.close();
		con.close();
		
		
		}catch(Exception ex) {
			System.out.println("실패" + ex.getMessage()); // 드라이버를 메모리 로딩을 할때는 무조건 캐치 트라이로 해줘야한다.
		}
	}

}
