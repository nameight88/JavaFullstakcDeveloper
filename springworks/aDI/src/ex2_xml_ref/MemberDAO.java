package ex2_xml_ref;

public class MemberDAO {
	
	private MemberBean member;
	
	//기본 생성자 함수
	public MemberDAO() {}
	
	//생성자 함수
	public MemberDAO(MemberBean member) {
		this.member = member;
	}
	
	//setter
	public void setMember(MemberBean member) {
		this.member =member;
	}
	
	public void insert() {
		member.output();
		System.out.println("입력하였습니다.");
	}
}
