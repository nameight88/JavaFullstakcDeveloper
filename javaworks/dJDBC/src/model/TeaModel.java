package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.TeaDao;

public class TeaModel implements TeaDao {
	
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://118.217.203.41/cafe";
	String user = "scott";
	String pass = "tiger";
	
	Connection con = null;
	PreparedStatement ps = null;
	public ArrayList list;
	
	public TeaModel() throws Exception{
		Class.forName(driver);
	}
	// ------------------------------------------------------
	// 메뉴 db에 추가하기
	public void insertMenu1() throws Exception{
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			
			String sql =  " INSERT INTO TEA              "
						+ "              ( TEA_NAME    "
						+ "              , TEA_PRICE ) "
						+ " VALUES                       "
						+ "              ( 'TWG 카모마일'   "
						+ "              , 5100)         ";
			ps = con.prepareStatement(sql);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("메뉴1 입력실패");
			e.printStackTrace();
		}
	}
	
	public void insertMenu2() throws Exception {
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			
			String sql =  " INSERT INTO TEA              "
						+ "              ( TEA_NAME    "
						+ "              , TEA_PRICE ) "
						+ " VALUES                       "
						+ "              ( 'TWG 크림카라멜'  "
						+ "              , 5100)         ";
			ps = con.prepareStatement(sql);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("메뉴2 입력실패");
			e.printStackTrace();
		}
	}
	
	public void insertMenu3() throws Exception{
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			
			String sql =  " INSERT INTO TEA                "
						+ "              ( TEA_NAME      "
						+ "              , TEA_PRICE )   "
						+ " VALUES                         "
						+ "              ( 'TWG 프렌치얼그레이'  "
						+ "              , 5100)           ";
			ps = con.prepareStatement(sql);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("메뉴3 입력실패");
			e.printStackTrace();
		}
	}
	
	public void insertMenu4() throws Exception{
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			
			String sql =  " INSERT INTO TEA              "
						+ "              ( TEA_NAME    "
						+ "              , TEA_PRICE ) "
						+ " VALUES                       "
						+ "              ( '애플 민트티'     "
						+ "              , 6100)         ";
			ps = con.prepareStatement(sql);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("메뉴4 입력실패");
			e.printStackTrace();
		}
	}
	
	public void insertMenu5() throws Exception{
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			
			String sql =  " INSERT INTO TEA                "
						+ "              ( TEA_NAME      "
						+ "              , TEA_PRICE )   "
						+ " VALUES                         "
						+ "              ( '제주 유기농 녹차'    "
						+ "              , 4800)           ";
			ps = con.prepareStatement(sql);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("메뉴5 입력실패");
			e.printStackTrace();
		}
	}
	
	public void insertMenu6() throws Exception{
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			
			String sql =  " INSERT INTO TEA                "
						+ "              ( TEA_NAME      "
						+ "              , TEA_PRICE )   "
						+ " VALUES                         "
						+ "              ( '허니 레몬티'       "
						+ "              , 6100)           ";
			ps = con.prepareStatement(sql);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("메뉴6 입력실패");
			e.printStackTrace();
		}
	}
	// -------------------------------------------------------
	// 버튼으로 선택한 메뉴 테이블모델의 리스트에 추가하기
	// 
}
