package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.OrderDao;

public class OrderModel implements OrderDao{

	String driver 	= "com.mysql.cj.jdbc.Driver";
	String url		= "jdbc:mysql://localhost:3306/cafe";
	String user		= "scott";
	String pass		= "tiger";

	public OrderModel() throws Exception{
		// 1. 드라이버로딩
		Class.forName(driver);
	}
	public int selectPrice(String category, String menuname) throws Exception{

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int cate_price = 0;


		try {
			
			con = DriverManager.getConnection(url, user, pass);
			
			String sql = " SELECT	"+ category +"_PRICE   "
						+ " FROM	"+ category
						+ " WHERE	"+ category+"_NAME = ? "				
						;

			System.out.println(sql);
			ps = con.prepareStatement(sql);
			System.out.println(menuname);
			ps.setString(1,menuname);
			rs = ps.executeQuery();

			if(rs.next()) {
				cate_price = rs.getInt(1);
			}
			System.out.println(cate_price);

		}
		finally {
			rs.close();
			ps.close();
			con.close();
		}
		return cate_price;

	}

}
