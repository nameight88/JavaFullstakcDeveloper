package videoshop.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import videoshop.model.VideoDao;
import videoshop.model.vo.Video;

public class VideoModel implements VideoDao{
	String driver="com.mysql.cj.jdbc.Driver"; //DB연결에 필요한 변수들을 미리 선언
	String url="jdbc:mysql://175.114.130.4:3306/basic";
	String user="scott";
	String pass="tiger";
	Connection con = null;


	public VideoModel() throws Exception{
		// 1. 드라이버로딩
		Class.forName("com.mysql.cj.jdbc.Driver");	
	}
	
	public void bVideoModify(Video v)throws Exception{
		con	=	DriverManager.getConnection(url,user,pass); //드라이버 연결
		
		try { // DB에서 데이터 값을 받고 그 값을 교체
			String sql = "UPDATE video"
					+ " SET title=?, director = ?, actor = ?, genre =?, detail=?"
					+ " WHERE video_num = ? ";
			
			PreparedStatement ps=con.prepareStatement(sql); //연결객체 선언
			
			ps.setString(1,v.getVideoName() );
			ps.setString(2,v.getDirector() );
			ps.setString(3,v.getActor() );
			ps.setString(4,v.getGenre() );
			ps.setString(5,v.getExp() );
			ps.setInt(6,v.getVideoNo() );
			
			ps.executeUpdate();
			
		}catch(Exception ex){
			System.out.println("수정에 실패했습니다: "+ex.getMessage());
			ex.printStackTrace();
		}finally {
			con.close();
		}
		
		
	}
	public void deleteVideo(int videoNum)throws Exception{ //인터페이스에서 추상적 모델을 오버라이딩해서 구현을 해줘야한다.
		con	=	DriverManager.getConnection(url,user,pass);
		try {
			String sql ="DELETE "
					+ " FROM video	"
					+ " WHERE video_num = ? ";
			
			PreparedStatement ps =  con.prepareStatement(sql);
			ps.setInt(1, videoNum);
			ps.executeUpdate();
		}finally {
			con.close();
		}
	}
	// end of deleteVideo

	public  ArrayList selectVideos (int idx, String keyword) throws Exception {
		
		String [] column = {"title","director"}; //idx와 맞출려고 배열로 설정
		
		ArrayList data = new ArrayList(); // 배열을 담을 변수 선언
		
		Connection con = null; // 드라이버 로딩에 필요한 변수를 null값으로 선언
		try {
			con	=	DriverManager.getConnection(url,user,pass);
			//DB 연동에 필요한 정보를 호출

			String sql = "SELECT video_num, title, genre, director, actor"
						+ " FROM video"
						+ " WHERE " + column[idx] + "	LIKE	'%"+keyword+"%'";
			//SQL에서 필요한 정보를 얻어오는 쿼리를 자바에서 sql변수에 저장
			PreparedStatement ps=con.prepareStatement(sql);
			//전송에 필요한 객체를 선언

			ResultSet rs=ps.executeQuery();
			//몇개의 데이터가 올지 모르기 때문에 while 문 사용
			while(rs.next()){
				ArrayList temp = new ArrayList();
				temp.add( rs.getInt("video_num"));
				temp.add( rs.getString("title"));
				temp.add( rs.getString("genre"));
				temp.add( rs.getString("director"));
				temp.add( rs.getString("actor"));
				data.add(temp);
			}//while 문을 사용을 해서 데이터를 ArrayList temp를 선언을 해서 DB에서 얻어온
			//데이터 들을 저장
			
			
		}finally {
			con.close();
		}	
		return data;
	}

	public void insertVideo(Video vo, int count) throws Exception{
		// 2. Connection 연결객체 얻어오기
		// 3. sql 문장 만들기
		// 4. sql 전송객체 (PreparedStatement)		
		// 5. sql 전송
		// 6. 닫기
		try {
			con=DriverManager.getConnection(url,user,pass);
			String sql = "INSERT INTO video(title, genre, director, actor, detail)"
						+ "	VALUES(?,?,?,?,?)";


			PreparedStatement ps=con.prepareStatement(sql);
			for(int i= 0; i<count; i+=1) {
				ps.setString(i=1, vo.getVideoName());
				ps.setString(i=2, vo.getGenre());
				ps.setString(i=3, vo.getDirector());
				ps.setString(i=4, vo.getActor());
				ps.setString(i=5, vo.getExp());

				ps.executeUpdate();
			}

		}finally {
			con.close();
		}



	}

	public Video searchByPk(int videoNum)throws Exception {
		Video n = new Video();
		try {
			con = DriverManager.getConnection(url,user,pass);
		
			String sql = " SELECT * "
					+ " FROM video"
					+ " WHERE video_num = ? ";
			
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, videoNum);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				n.setVideoName(rs.getString("title"));
				n.setDirector(rs.getString("director"));
				n.setActor(rs.getString("actor"));
				n.setGenre(rs.getString("genre"));
				n.setExp(rs.getString("detail"));
				n.setVideoNo(rs.getInt("video_num"));
				
			}
		}catch(Exception ex) {
			System.out.println("False: "+ex.getMessage());
			ex.printStackTrace();
		}finally {
			con.close();
		}
		return n;
	}

	


}
