package videoshop.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import videoshop.model.CustomerDao;
import videoshop.model.vo.Customer;

public class CustomerModel implements CustomerDao{

	String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/basic";
		String user="scott";
		String pass="tiger";
		Connection con = null;
	
	public CustomerModel() throws Exception{
	 	// 1. 드라이버로딩
		Class.forName(driver);
		
	}
	
	public void insertCustomer(Customer vo) throws Exception{
		// 2. Connection 연결객체 얻어오기
		// 3. sql 문장 만들기
		// 4. sql 전송객체 (PreparedStatement)		
		// 5. sql 전송
		// 6. 닫기 

		try {
			con=DriverManager.getConnection(url,user,pass);
		
			String sql= " INSERT INTO customer (tel, name, telAid, address, email)   "
					+ "   VALUES(?,?,?,?,?)";
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, vo.getCustTel1());
			ps.setString(2, vo.getCustName());
			ps.setString(3, vo.getCustTel2());
			ps.setString(4, vo.getCustAddr());
			ps.setString(5, vo.getCustEmail());

			ps.executeUpdate();
		}finally {
			con.close();
		}
		
	}
	
	public Customer selectByTel(String tel) throws Exception{
		Customer vo = new Customer();
		
		try {
			con = DriverManager.getConnection(url,user,pass);
			String sql= " SELECT * FROM customer WHERE tel=?";
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, tel);
			
			ResultSet rs=ps.executeQuery();
			// result set 에서 5개 info 하나씩 rs에서 get 해서
			// Customer vo 에 set 해서 return 한다
			if(rs.next()) {
				vo.setCustTel1(rs.getString("tel"));
				vo.setCustName(rs.getString("name"));
				vo.setCustTel2(rs.getString("telAid"));
				vo.setCustAddr(rs.getString("address"));
				vo.setCustEmail(rs.getString("email"));
			}
		}catch (Exception e) {
			System.out.println("select" + e.getMessage());
		}
		finally {
			con.close();
		}
		
		return vo;
		
	}
	
	
	
	// 이름으로 검색
	public Customer selectByName(String name) throws Exception{
		Customer vo = new Customer();
		
		try {
			con = DriverManager.getConnection(url,user,pass);
			String sql= " SELECT * FROM customer WHERE name=?";
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				vo.setCustTel1(rs.getString("tel"));
				vo.setCustName(rs.getString("name"));
				vo.setCustTel2(rs.getString("telAid"));
				vo.setCustAddr(rs.getString("address"));
				vo.setCustEmail(rs.getString("email"));
			}
		}catch (Exception e) {
			System.out.println("select" + e.getMessage());
		}
		finally {
			con.close();
		}
		return vo;
		
	}
	
	
	
	
	
	public int updateCustomer(Customer vo) throws Exception{
		int result = 0;	
		try {
			con=DriverManager.getConnection(url,user,pass);
			String sql=" UPDATE customer  "
					+ "  SET tel=?, name=?, telAid=?, address=?, email=?  "
					+ "	 WHERE tel=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, vo.getCustTel1());
			ps.setString(2, vo.getCustName());
			ps.setString(3, vo.getCustTel2());
			ps.setString(4, vo.getCustAddr());
			ps.setString(5, vo.getCustEmail());
			ps.setString(6, vo.getCustTel1());
			
			result=	ps.executeUpdate();
			
		}finally {
			con.close();
		}
		return result;	
	} 
}
