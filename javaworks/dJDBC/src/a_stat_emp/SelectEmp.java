package a_stat_emp;
import java.sql.*; //자바와 외부는 무조건 예외처리는 무조건
public class SelectEmp {

	public static void main(String[] args) {
		
		String driver = "com.mysql.cj.jdbc.Driver"; 
		String url = "jdbc:mysql://localhost:3306/basic";
		String user = "scott";
		String pass  = "tiger";
		
		try {
			//1.드라이버 로딩
			Class.forName(driver);
			System.out.println("드라이버 연결");
			
			//2. 연결객체 얻어오기
			Connection con = DriverManager.getConnection(url,user,pass);
			System.out.println("DB 연결 성공");
			
			
			
			//3. SQL 문장 생성
			String sql = "SELECT ename, job, sal FROM emp";
			
			//4. SQL 전송객체 얻어오기
			Statement stmt = con.createStatement();
			
			//5. 전송
			ResultSet rset = stmt.executeQuery(sql);
			while(rset.next()) {//주로 얼마나 받을 수 있을지 모르기때문에 while문을 주로 사용을 한다.
				System.out.print(rset.getString("ENAME")+ "/");
				System.out.print(rset.getString("JOB") + "/");
				System.out.println(rset.getString("SAL"));
			}   
			
			
			
			//6.닫기
			rset.close();  //닫을때 부모 클래스 부터 닫아야한다.
			stmt.close();
			con.close();
			
		}catch(Exception ex) {
			System.out.println("실패: "+ex.getMessage());
		}
		
	}

}
