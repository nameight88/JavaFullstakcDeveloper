package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import main.CafeTwosome;

public class DessertModel {
	
	DBDriver dbd;
	
	String driver = "com.mysql.cj.jdbc.Driver";
	String url	  = "jdbc:mysql://localhost:3306/cafe";
	String user   = "scott";
	String pass   = "tiger";
	
	public void DessertModel() throws Exception{
		// 1. 드라이버로딩
		dbd = DBDriver.getInstance();	
	}
	
	public void addOrderlist(String dessertName, int dessertCnt) throws Exception{

		CafeTwosome cafetwosome = new CafeTwosome();
		Connection con = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		
		
		try {

			con = DriverManager.getConnection(url, user, pass);

			String sql1 = " SELECT	DESSERT_NO, DESSERT_PRICE "
						+ " FROM		dessert "
						+ " WHERE	DESSERT_NAME = ? "
						;
			
			ps1 = con.prepareStatement(sql1);
			ps1.setString(1, dessertName);
			
			rs = ps1.executeQuery();
			
			int dessertNo = 0;
			int dessertPrice = 0;
			
			if(rs.next()) {
				dessertNo = rs.getInt("DESSERT_NO");
				dessertPrice = rs.getInt("DESSERT_PRICE");
			}
					
			String sql2 = " INSERT INTO	 ORDER		 		"
					   	+ "				 (DESSERT_NO  		"
					   	+ "				 ,DESSERT_CNT   	"
					   	+ "				 ,TOTAL_PRICE)   	"
					   	+ " VALUE		 					"
					   	+ "				 (?,?,?)			"
					   	+ "				 					"
					   	;

			ps2 = con.prepareStatement(sql2);
			
			ps2.setInt(1, dessertNo);
			ps2.setInt(2, dessertCnt);
			ps2.setInt(3, dessertCnt*dessertPrice);

			ps2.executeUpdate();
			
			
			}
		finally {
			ps1.close();
			ps2.close();
			con.close();
		}
		
	}
}
