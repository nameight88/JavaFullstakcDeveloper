package c_exercise;

import java.sql.*; //자바와 외부는 무조건 예외처리는 무조건


//[1] LIKE '%" + searchName + "%'";  => LIKE '%u%'
// ? 없이

//[2]
// search Name = "%" + searchName + "%"; // %u%

public class SelectEmpEployees {

	public static void main(String[] args) {

		String driver = "com.mysql.cj.jdbc.Driver"; 
		String url = "jdbc:mysql://localhost:3306/advanced";
		String user = "scott";
		String pass  = "tiger";

		Connection 		  	con 		 = null;
		PreparedStatement 	ps 			 = null;
		ResultSet 	   	  	rset 		 = null;

		try {
			Class.forName(driver);

			con = DriverManager.getConnection(url,user,pass);
			String sql = "";
			
			
			  ps = con.prepareStatement(sql);
			  rset = ps.executeQuery();
 
		}catch(Exception ex) {
			System.out.println("실패: "+ex.getMessage());
		}finally{
			try {
				//닫기
				rset.close(); 
				ps.close();
				con.close();
			}catch(Exception ex) {}
		}
	}
}
