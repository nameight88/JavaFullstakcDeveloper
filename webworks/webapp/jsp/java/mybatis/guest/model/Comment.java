package mybatis.guest.model;

import java.io.Serializable;

//예전 MyBatis에서 사용을 할려면 직렬화가 되어야한다. 지금은 안해도 된다.
//[직렬화] implements Serializable 직렬화 작업을 해준다.

public class Comment implements Serializable {
	//[1] VO설정처럼 변수들을 선언 -> listComment.jsp
	/*
	 *  DB: _(snake case)언더바 표기법으로 이름 지정
	 *  JAVA: (camel case)낙타 표기법으로 이름 지정
	 *  이건 프로젝트 처음 시작을 할때 정해서 가면 된다.
	 *  
	 */
	
	private int commentNo; // 글 번호
	private String userId; //작성자 아이디
	private String commentContent; //글 내용
	private String regDate; // 작성 일자2
	
	// setter and getter

	
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getUserId() {
		return userId;
	}
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	
}
