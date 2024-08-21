package e_info;

import java.sql.*;
import java.util.ArrayList;


public class InfoModelImpl implements InfoModel {

	// 0. 필요한 변수
	String driver 	= "com.mysql.cj.jdbc.Driver";
	String url		= "jdbc:mysql://localhost:3306/basic";
	String user		= "scott";
	String pass		= "tiger";

	Connection con = null;

	public InfoModelImpl() throws Exception{
		// 1. 드라이버를 메모리 로딩
		Class.forName(driver);
	}


	/*
	 *   함수명 : insertData
	 *   인자값 :
	 *   리턴값 :
	 *   역  할 : 회원가입하는 입력값을 받아서 데이타베이스에 저장
	 */
	public void InsertData(InfoVo vo) throws Exception {
		try {
			// 2. 연결객체 얻어오기
			con = DriverManager.getConnection(url, user, pass);

			String sql = "INSERT INTO"
					+ " info_tab(name, tel, jumin, gender, age, home) "
					+ " VALUES( ?,?,?,?,?,?)";


			PreparedStatement ps =  con.prepareStatement(sql);
			ps.setString	(1, vo.getName	());
			ps.setString	(2, vo.getTel	());
			ps.setString	(3, vo.getId	());
			ps.setString	(4, vo.getGender());
			ps.setInt		(5, vo.getAge	());
			ps.setString	(6, vo.getHome	());


			ps.executeUpdate();

		}finally {
			con.close();
		}// end of insert data
	}
	public void insertData(InfoVo vo) throws Exception {
	}



	public InfoVo searchByTel(String tel)throws Exception {
		InfoVo vo = new InfoVo();
		Connection con = null;
		try {

			con = DriverManager.getConnection(url, user, pass);
			String sql = " SELECT *"
					+ " FROM info_tab"
					+ " WHERE tel = ?";


			PreparedStatement ps =  con.prepareStatement(sql);
			ps.setString	(1,tel);

			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				vo.setName(rs.getString("NAME"));
				vo.setTel(rs.getString("TEL"));
				vo.setHome(rs.getString("JUMIN"));
				vo.setGender(rs.getString("GENDER"));
				vo.setAge(rs.getInt("AGE"));
			}
		}finally {
			con.close();

		}
		return vo;

	}// end of tel




	public ArrayList<InfoVo> searchALL() throws Exception{
		ArrayList<InfoVo> list = new ArrayList<InfoVo>();

		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = " SELECT *"
					+ " FROM info_tab";

			PreparedStatement ps =  con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				InfoVo vo = new InfoVo();
				vo.setName(rs.getString("NAME"));
				vo.setAge(rs.getInt("AGE"));
				vo.setTel(rs.getString("TEL"));
				vo.setHome(rs.getString("HOME"));
				vo.setGender(rs.getString("GENDER"));
				vo.setId(rs.getString("JUMIN"));
				list.add(vo);
			}
		}finally {
			con.close();
		}

		return list;
	}
	

	public void deleteData(String tel) throws Exception{
		InfoVo vo = new InfoVo();
		Connection con = null;

		try {
			con = DriverManager.getConnection(url, user, pass);

			String sql = "DELETE FROM info_tab WHERE tel = ?";

			PreparedStatement ps =  con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			if(rs.next()) {

				//vo.setTel();
			}
		}finally{
			con.close();
		}
	}
		public void modifyData(InfoVo vo) throws Exception{
			try {
				con = DriverManager.getConnection(url, user, pass);
				String sql = "UPDATE info_tab "
						+ " SET name=?, jumin=?, gender=?, age=?, home=? "
						+ " WHERE tel = ?";
				
				PreparedStatement ps =  con.prepareStatement(sql);
				
				ps.setString	(1, vo.getName	());
				ps.setString	(2, vo.getTel	());
				ps.setString	(3, vo.getId	());
				ps.setString	(4, vo.getGender());
				ps.setInt		(5, vo.getAge	());
				ps.setString	(6, vo.getHome	());
				
				ps.executeUpdate();

			}finally {
				con.close();
			}


		}
	
}
