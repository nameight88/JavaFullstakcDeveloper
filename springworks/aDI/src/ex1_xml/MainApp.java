package ex1_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {

//		//0. POJO(plan of java object)
//		Message bean = new MessageBeanKoImpl();
//		bean.sayHello("홍길동");
//		
//		Message bean2 = new MessageBeanEnImpl();
//		bean2.sayHello("John");
		
		//1. Spring 설정 파일 연결
		//스프링 프레임 워크 부터는 개발자가 객체 생성을 안한다.
		//[1]applicationContext.xml파일 생성 및 설정
		ApplicationContext context =
				new ClassPathXmlApplicationContext("ex1_xml/applicationContext.xml");
//		//2. DI: 스프링 컨테이너에서 빈(bean) 가져오기
//		Message bean = (Message)context.getBean("ko");
//		//getBean으로 가져올때부터 object여서 형변환
//		
//		//처음부터 가져올때 Message 클래스로 가져오는 방법
//		//Message bean = context.getBean("ko",Message.class);
//		bean.sayHello("홍길숙");
//		
//		
//		Message bean2 = context.getBean("en",Message.class);
//		bean2.sayHello("Jaen");
		//스프링이 자동적으로 객체를 생성해준다.
		
		
		//[2] 기본 scope가 sington이다
		Message bean = (Message)context.getBean("ko");
		//getBean으로 가져올때부터 object여서 형변환
				//처음부터 가져올때 Message 클래스로 가져오는 방법
		//Message bean = context.getBean("ko",Message.class);
		bean.sayHello("홍길숙");
		
	
		Message bean2 = context.getBean("ko",Message.class);
		bean2.sayHello("맹길숙");
		
	}

}
