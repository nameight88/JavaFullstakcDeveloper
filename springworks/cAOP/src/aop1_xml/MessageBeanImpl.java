package aop1_xml;

public class MessageBeanImpl implements MessageBean{

	@Override
	public void sayHello() {
		// LoggingAdvice 안에 before() 호출원함
		System.out.println("sayHello() 호출");
		
	}

	@Override
	public void enSayHello() {
		// LoggingAdvice 안에 before() 호출원함
		System.out.println("enSayHello() 호출");
		
	}

	@Override
	public void test() {
		System.out.println("test() 호출");
		
	}

}
