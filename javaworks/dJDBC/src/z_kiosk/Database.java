package z_kiosk;

import java.sql.*;
import java.util.*;

public class Database {

	String URL = "jdbc:mysql://118.217.203.41:3306/cafe";
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
			String sql = "select dessert_cnt, dessert_name"
					+ " from order_list"
					+ " WHERE dessert_cnt is not null and dessert_name is not null";
 
			
			
			//***************************************************************
			
			PreparedStatement stmt = con.prepareStatement( sql );	

			ResultSet rset = stmt.executeQuery();

			
			while( rset.next() ){
				ArrayList temp = new ArrayList();
				temp.add(rset.getInt("dessert_cnt"));
                temp.add(rset.getString("dessert_name"));
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
