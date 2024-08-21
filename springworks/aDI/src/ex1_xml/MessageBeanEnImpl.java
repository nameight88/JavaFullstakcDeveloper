package ex1_xml;

public class MessageBeanEnImpl implements Message{

	
	public MessageBeanEnImpl() {
		System.err.println("MessageBeanEnImpl 기본 생성자");
	}
	public void sayHello(String name) {
		System.out.println("Hellos,"+name);
	}
}
