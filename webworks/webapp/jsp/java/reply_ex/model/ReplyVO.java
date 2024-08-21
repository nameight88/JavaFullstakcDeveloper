package reply_ex.model;

public class ReplyVO {
	
	private int reply_id; // 댓글 번호
	private int seq; // 글 번호
	private String user; //댓글 작성자명
	private String reply; //댓글 내용
	
	
	
	//getter and setter
	public int getReply_id() {
		return reply_id;
	}
	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	
	//toString
	@Override
	public String toString() {
		return "ReplyVO [reply_id=" + reply_id + ", seq=" + seq + ", user=" + user + ", reply=" + reply + "]";
	}
	
}
