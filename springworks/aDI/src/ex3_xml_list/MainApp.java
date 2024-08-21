package ex3_xml_list;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("ex3_xml_list/applicationContext.xml");
		
		ListBean bean = context.getBean("bean",ListBean.class);
		for( Integer i : bean.getIntList()) {
			System.out.println(i);
		}
		for(MemberBean mb:bean.getMemberList()) {
			mb.output();
		}
	}

}
