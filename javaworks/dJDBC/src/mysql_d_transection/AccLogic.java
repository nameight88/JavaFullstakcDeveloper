package mysql_d_transection;

/*	
 *  트랜잭션 : All or None 단위
 * 
 */

//#################################################################
//	테이블명 : account
//	account_num		char(10)	-- 계좌번호		
//	customer		varchar(20) -- 고객명		
//	amount			int			-- 계좌금액

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class AccLogic 
{
	// 연결 객체 생성시 필요한 변수 선언
	String driver = "com.mysql.cj.jdbc.Driver"; 
	String url = "jdbc:mysql://localhost:3306/basic";
	String user = "scott";
	String pass = "tiger";

	//===============================================
	// 드라이버를 드라이버매니저에 등록
	public AccLogic() throws Exception{
		/////////////////////////////////////////////////////////
		// 1. 드라이버를 드라이버 매니저에 등록
		Class.forName("com.mysql.cj.jdbc.Driver");	
	}


	//====================================================
	// 보내는 계좌번호와 받는 계좌번호와 계좌금액을 넘겨받아 
	//	보내는계좌에서 계좌금액을 빼고 받는계좌에서 계좌금액을 더한다
	public int moveAccount(String sendAcc, String recvAcc, int amount)
	{
		Connection con = null;

		///////////////////////////////////////////////////////////
		//	 1. Connection 객체 생성
		//@@ 2. Auto-commit을 해제
		//@@ 5. commit을 전송한다
		//	 6. 객체 닫기
		//	 - 만일 정상적인 경우는 0을 리턴하고 도중에 잘못되었으면 트랜잭션을 롤백시키고 -1을 리턴
		try {
			con = DriverManager.getConnection(url, user, pass);
			con.setAutoCommit(false); //auto commit 을 꺼야한다.
			
			//3. 출금계좌에서 이체금액을 뺀다
			String sql_send = "UPDATE account SET amount=amount-?"
							+ "WHERE account_num=?";
			PreparedStatement ps_send = con.prepareStatement(sql_send);
			ps_send.setInt(1,amount);
			ps_send.setString(2, sendAcc);
			
			ps_send.executeUpdate();
			
			int rs_send = ps_send.executeUpdate(); // 리턴값을 받아야한다.
			if(rs_send == 0) {
				con.rollback();
				return -1;
			}
			
			// 4. 입금계좌에 이체금액을 더한다
			String sql_resv = "UPDATE account SET amount=amount+?"
							+ "WHERE account_num=?";
			PreparedStatement ps_resv =  con.prepareStatement(sql_resv);
			ps_resv.setInt(1,amount);
			ps_resv.setString(2, recvAcc);

			
			ps_resv.executeUpdate();
			int rs_resv = ps_resv.executeUpdate();
			if(rs_resv == 0 ) {
				con.rollback();
				return -1;
			}
			
			con.commit();
			
		}catch(Exception ex) {
			System.out.println("실패"+ex.getMessage());
		}finally {
			try {con.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
		return 0;
	}



}


