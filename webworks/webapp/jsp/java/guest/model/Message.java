package guest.model;

public class Message {
	//DB 컬럼과 비슷하게 변수 선언 하는게 좋다.
	private int messageId; //private int message_id //글번호
	private String guestName; //작성자
	private String password; //해당글의 비밀번호
	private String message; //글 내용
	
	
	//getter and setter
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	//toString 출력하기 쉽게 만들어 주면 좋다.(개발자들이 확인용으로 쓰이고 개발이 끝나면 지워주자)
	public String toString() {
		return "Message [messageId=" + messageId + ", guestName=" + guestName + ", password=" + password + ", message="
				+ message + "]";
	}
	
}
