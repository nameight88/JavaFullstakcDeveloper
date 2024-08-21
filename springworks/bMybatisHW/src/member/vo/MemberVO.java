package member.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

//VO(Value Object)
@Data
public class MemberVO {

	private String userid;
	private String userpass;
	private String username;


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getUserpass() {
		return userpass;
	}


	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", username=" + username + "]";
	}
}