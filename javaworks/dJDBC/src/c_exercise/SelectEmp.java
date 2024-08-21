package c_exercise;

import java.sql.*; //자바와 외부는 무조건 예외처리는 무조건

public class SelectEmp {

	public static void main(String[] args) {

		String driver = "com.mysql.cj.jdbc.Driver"; 
		String url = "jdbc:mysql://localhost:3306/basic";
		String user = "scott";
		String pass  = "tiger";

		Connection 		  	con 		 = null;
		PreparedStatement 	ps 			 = null;
		ResultSet 	   	  	rset 		 = null;

		try {
			//1.드라이버 로딩
			Class.forName(driver);
			System.out.println("드라이버 연결");

			//2. 연결객체 얻어오기
			con = DriverManager.getConnection(url,user,pass);
			System.out.println("DB 연결 성공");
				// 사원명, 업무,월급,부서명
			//3. SQL 문장 생성
			String sql =  " SELECT e.ename as ENAME "
						+ " , e.job  as job"
						+ " , e.sal	as sal"
						+ " , d.dname as dname"
						+ " FROM emp e inner join dept d "
						+ " on e.deptno = d.deptno";

			//4. SQL 전송객체 얻어오기
			//Statement stmt = con.createStatement();
			ps = con.prepareStatement(sql);

			//5. 전송
			rset = ps.executeQuery();
			while(rset.next()) {
				System.out.print(rset.getString( "ENAME" )+ "/");
				System.out.print(rset.getString( "JOB" ) + "/");
				System.out.print(rset.getInt( "SAL" ) + "/");
				System.out.println(rset.getString("DNAME"));
			} //while 에서 ""안에 공백을 만들지 마라

//			}   
		}catch(Exception ex) {
			System.out.println("실패: "+ex.getMessage());
		}finally{
			try {
				//6.닫기
				rset.close(); 
				ps.close();
				con.close();
			}catch(Exception ex) {}
		}
	}
}
