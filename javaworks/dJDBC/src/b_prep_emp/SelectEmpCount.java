package b_prep_emp;

import java.sql.*; //자바와 외부는 무조건 예외처리는 무조건

public class SelectEmpCount {

	public static void main(String[] args) {

		String driver	 = "com.mysql.cj.jdbc.Driver"; 
		String url 		 = "jdbc:mysql://localhost:3306/basic";
		String user 	 = "scott";
		String pass  	 = "tiger";
		
		Connection 			con 	= null;
		PreparedStatement	ps 		= null;
		ResultSet 			rset 	= null;
		
		try {
			//1.드라이버 로딩
			Class.forName(driver);
			System.out.println("드라이버 연결");

			//2. 연결객체 얻어오기
			con = DriverManager.getConnection(url,user,pass);
			System.out.println("DB 연결 성공");

			//3. SQL 문장 생성
			String sql =  "SELECT 	count(*) cnt "
						+ "from 	emp	";

			//4. SQL 전송객체 얻어오기
			//Statement stmt = con.createStatement();
			ps = con.prepareStatement(sql);

			//5. 전송
			rset = ps.executeQuery();
			rset.next();

			System.out.println(rset.getInt("CNT"));

			//6.닫기
			
		}catch(Exception ex) {
			System.out.println("실패: "+ex.getMessage());
		}finally {
			try {
				rset.close();  //닫을때 부모 클래스 부터 닫아야한다.
				ps.close();
				con.close();
			}catch(Exception ex) {}
		}

	}

}
