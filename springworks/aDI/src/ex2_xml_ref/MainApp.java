package ex2_xml_ref;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("ex2_xml_ref/applicationContext.xml");

		//		MemberBean bean = context.getBean("member",MemberBean.class);
		//		bean.output();
		//		
		//		MemberBean bean2 = context.getBean("member2",MemberBean.class);
		//		bean2.output();

		MemberDAO dao1 = context.getBean("dao1", MemberDAO.class);
		dao1.insert();


		MemberDAO dao2 = context.getBean("dao2", MemberDAO.class);
		dao2.insert();
	}
}
