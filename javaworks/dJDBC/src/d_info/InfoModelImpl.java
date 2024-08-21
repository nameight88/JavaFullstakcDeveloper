package d_info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class InfoModelImpl implements InfoModel {

	// 0. 필요한 변수
	String driver 	= "com.mysql.cj.jdbc.Driver";
	String url		= "jdbc:mysql://localhost:3306/basic";
	String user		= "scott";
	String pass		= "tiger";
	
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
	public void insertData(InfoVO vo) throws Exception {
		Connection con = null;
		try {
		// 2. 연결객체 얻어오기
		con = DriverManager.getConnection(url, user, pass);
		
		// 3. SQL 문장
		String sql = "INSERT  INTO  "
				+ " info_tab(name, tel, jumin, gender, age, home) "
				+ " VALUES(?,?,?,?,?,?)";
		
		// 4. 전송객체 얻어오기
		PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getTel());
			ps.setString(3, vo.getId());
			ps.setString(4, vo.getGender());
			ps.setInt(5, vo.getAge());
			ps.setString(6, vo.getHome());
		
		// 5. 전송
		ps.executeUpdate();
		}finally {
			// 6. 닫기
			con.close();
		}
	}

	public InfoVO searchByTel(String tel) throws Exception{
		InfoVO vo = new InfoVO();
		Connection con = null;
		try {
			// 2. 연결객체 얻어오기
			con = DriverManager.getConnection(url, user, pass);
			
			// 3. sql 문장
			String sql = "SELECT * FROM info_tab WHERE tel=?";
			
			// 4. 전송객체
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, tel);
			
			// 5. 전송 ( 결과처리 )
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				vo.setName(  rs.getString("NAME"));
				// **** 나머지도
				
			}
			
		}finally {
			// 6. 닫기
			con.close();
		}
		return vo;
	}
	
	
	public ArrayList<InfoVO> searchAll() throws Exception{
		ArrayList<InfoVO> list = new ArrayList<InfoVO>();
		
		Connection con = null;
		try {
			// 2. 연결객체 얻어오기
			con = DriverManager.getConnection(url, user, pass);
			
			// 3. sql 문장
			String sql = "SELECT * FROM info_tab";
			
			// 4. 전송객체
			PreparedStatement ps = con.prepareStatement(sql);
						
			// 5. 전송 ( 결과처리 )
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				InfoVO vo = new InfoVO();
				vo.setName(  rs.getString("NAME"));
				// **** 나머지도
				
				list.add(vo);
			}
			
		}finally {
			// 6. 닫기
			con.close();
		}		
		
		return list;
	}
	
	
	
	public void deleteData(String tel) throws Exception{
		// 2. 연결객체 얻어오기
		
		// 3. sql문장
		String sql = "DELETE FROM info_tab WHERE tel=?";
		// 4. 전송객체
		
		
		// 5. 전송
		
		// 6. 닫기
		
	}
	
	

	public void modifyData(InfoVO vo) throws Exception{
		
		
		String sql = "UPDATE info_tab  "
				+ " SET name=?, jumin=?, gender=?, age=?, home=?  "
				+ " WHERE tel=?";
		
		
	}
	
	
	
	
	
	
	
	
}
