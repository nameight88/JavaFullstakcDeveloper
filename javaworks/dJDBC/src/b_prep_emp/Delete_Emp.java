package b_prep_emp;
import java.sql.*;
/*
 * 20번 부서이면서 월급이 2000 이상인 사원의 정보를 삭제
 */
public class Delete_Emp {

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

			//3.

			//사용자 입력값이라고 가정
			int del_dno = 20;
			int del_salary = 2000;


			String sql = "Delete  FROM emp "
					+ "WHERE deptno=? and sal>= ?";

			//4.SQL 전송 객체 얻어오기

			PreparedStatement ps = con.prepareStatement(sql); // sql을 여기서 먼저 가져가야한다.
			ps.setInt(1,del_dno);
			ps.setInt(2,del_salary);
		

			//5.
			ps.executeUpdate();
			ps.close();


		}catch(Exception ex) {
			System.out.println("실패" + ex.getMessage()); 

			}
		}
	}
