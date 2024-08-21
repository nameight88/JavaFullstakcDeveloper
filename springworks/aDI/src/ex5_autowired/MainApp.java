package ex5_autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext(
						"ex5_autowired/applicationContext.xml");
		MessageBean bean = context.getBean("message", MessageBean.class);
		bean.sayHello();
	}

}
