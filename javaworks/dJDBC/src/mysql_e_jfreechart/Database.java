package mysql_e_jfreechart;

import java.sql.*;
import java.util.*;

public class Database {

	String URL = "jdbc:mysql://localhost:3306/basic";
	String USER ="scott";
	String PASS = "tiger";

	public ArrayList<ArrayList> getData() {

		ArrayList<ArrayList> data = new ArrayList<ArrayList>();
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USER , PASS);	
			/*
			 * 월급별로 
			 */
			//***************************************************************
			String sql = "select month(hiredate) MONTH ,count(*) CNT"
					+ " from emp"
					+ " group by month(hiredate)"
					+ " order by month(hiredate)";
			
			
			//***************************************************************
			
			PreparedStatement stmt = con.prepareStatement( sql );	

			ResultSet rset = stmt.executeQuery();

			
			while( rset.next() ){
				ArrayList temp = new ArrayList();
				temp.add( rset.getInt("CNT"));				//****************
				temp.add( rset.getString("MONTH")+"월");		//****************		
				data.add(temp);
			}
			rset.close();
			stmt.close();
			con.close();
		} catch(Exception ex){
			System.out.println("에러 : " + ex.getMessage() );
		}
		return data;
	}
}
