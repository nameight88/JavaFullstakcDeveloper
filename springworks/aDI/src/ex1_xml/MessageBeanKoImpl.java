package ex1_xml;

public class MessageBeanKoImpl implements Message {
	
	public MessageBeanKoImpl() {
		System.err.println("MessageBeanKoImpl 기본 생성자");
	}
	
	public void sayHello(String name) {
		System.out.println(name+"님 반갑습니다.");
	}
}
