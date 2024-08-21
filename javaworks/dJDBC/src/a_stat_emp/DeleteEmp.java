package a_stat_emp;

import java.sql.*;

public class DeleteEmp {

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
		System.out.println("DB 연결 성공"); 
		
		//3.SQL 문장 만들기       // 7369 사번의 정보를 이름은 그루트,업무는 개발
		
		String sql = "Delete FROM emp "
					+ "where job is null";
				
		System.out.println(sql);
		
		//4.SQL 전송 객체 얻어오기
		
		
		Statement stmt = con.createStatement();
		
		//5.전송
		
		int result = stmt.executeUpdate(sql);
		// SELECT 인경우 stmt.ExecuteQuery();
		System.out.println(result + "행을 수행");
		
		System.out.println("SQL 전송");
		//6. 닫기
		
		stmt.close();
		con.close();
		
		
		}catch(Exception ex) {
			System.out.println("실패" + ex.getMessage()); // 드라이버를 메모리 로딩을 할때는 무조건 캐치 트라이로 해줘야한다.
		}
		
	}

}
