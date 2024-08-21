package aop2_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
/*
 * sayhello메소드가 호출 되기전 spring 에서 loggingadvice가 먼저 호출이 되고 그다음에
 * simpleadvice가 호출 된후 sayhello 호출이 되고
 * simpleadvice의 before가 호출 된 후
 * loggingadvice가 호출되면서 다음 으로 넘어간다.
 */
	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("aop2_annotation/applicationContext.xml");
		
		MessageBean bean = 	context.getBean("targetBean",MessageBean.class);
		bean.enSayHello();
		System.out.println("-------------------------------------");
		bean.sayHello();
		System.out.println("-------------------------------------");
		bean.test();
		//나중에 새로운 기능을 추가 할 때에 aop를 이용을 해서 기존기능을 하는 것을 핵심 기능으로 간주하고
		// 새로운 기능을 부가적인 기능으로 간주해서 추가적으로 붙혀서 나오게 끔 기능을 추가하면 된다.
	}

}
