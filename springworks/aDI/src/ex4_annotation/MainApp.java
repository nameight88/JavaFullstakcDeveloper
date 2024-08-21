package ex4_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext(
						"ex4_annotation/applicationContext.xml");
		
		MemberDAO dao = (MemberDAO)context.getBean("memberDAO");
		//클래스명을 똑같이 가져오되 첫글자는 소문자 변수명 ID명 객체명
		dao.insert();

	}

}
