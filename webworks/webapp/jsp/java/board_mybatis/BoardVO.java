package board_mybatis;

public class BoardVO
{
	// member field
	private	int		seq;		//글번호
	private	String	title;		//글제목
	private	String	writer;		//글작성자
	private	String	content;	//글 내용
	private String 	regdate;	//작성일자
	private	int		cnt;		//조회수
	private String 	pass;		//글 비밀번호
	
	//getter and setter
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
	
}

/*
[ 참고 ]

@ regdate 가 실제 DB에서는 Date 형이지만, 날짜 값을 출력만 하기에 
 Date 형이 아닌 String  형으로 받아도 된다.
 나중에 날짜값을 사용할 일이 있으면 Date 형으로 변경 

*/