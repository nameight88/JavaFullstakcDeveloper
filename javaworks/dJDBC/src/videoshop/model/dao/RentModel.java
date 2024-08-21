package videoshop.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import videoshop.model.RentDao;


public class RentModel implements RentDao{

	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://175.114.130.4:3306/basic";
	String user="scott";
	String pass="tiger";
	Connection con = null;


	public RentModel() throws Exception{
		// 1. 드라이버로딩
		Class.forName("com.mysql.cj.jdbc.Driver");
	}
	public void selectTel() throws Exception{
		try {
			con=DriverManager.getConnection(url,user,pass);
			String sql = "SELECT name"
					+ "FROM name"
					+ "WHERE tel =?";
			PreparedStatement ps=con.prepareStatement(sql);
		}finally {
			con.close();
		}
	}

	public void RentVideo (String tel, int vNum) throws Exception{
		try {
			con=DriverManager.getConnection(url,user,pass);
			String sql = "INSERT INTO rent ("
					+ " tel, video_num, rent_data)"
					+ " VALUES(?, ?, sysdate())";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, tel);
			ps.setInt(2, vNum);
			ps.executeUpdate();
		}finally {
			con.close();
		}
		//end of RentVideo
	}
	public void ReTurnVideo (int vNum) throws Exception {
		try {
			con=DriverManager.getConnection(url,user,pass);
			String sql = "UPDATE rent"
					+ " SET sysdate()"
					+ " WHERE video_num = ? and return is null";

			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,vNum);
		}finally {
			con.close();
		}
	}



public ArrayList selectNoReturn() throws Exception{
	
	ArrayList data = new ArrayList(); // 배열을 담을 변수 선언
	
	Connection con = null; // 드라이버 로딩에 필요한 변수를 null값으로 선언
	try {
		con	=	DriverManager.getConnection(url,user,pass);
		

		String sql = "SELECT v.video_num 비디오번호"
				+ "	,v.title 제목"
				+ "	,c.customer 고객"
				+ "	,c.tel 전화번호"
				+ "	,DATE_ADD(r.rent_date,INTERVAL 3 DAY) 반납예정일"
				+ "	,'미납'	미납여부"
				+ "	FROM rent r INNER JOIN video v "
				+ "	ON r.video_num =  v.video_num"
				+ "	INNER JOIN customer c"
				+ "	ON c.video_num = r.video_num"
				+ "	WHERE r.return_date IS NULL;";
		
		PreparedStatement ps=con.prepareStatement(sql);
		

		ResultSet rs=ps.executeQuery();
		
		while(rs.next()){
			ArrayList temp = new ArrayList();
			temp.add( rs.getInt("video_num"));
			temp.add( rs.getString("title"));
			temp.add( rs.getString("customer"));
			temp.add( rs.getString("tel"));
			temp.add( rs.getString("return_date"));
			temp.add( rs.getString("반납여부"));
			data.add(temp);
		}
			
	}finally {
		con.close();
	}	
	return data;
	
}
//end of selectNoReturn


}