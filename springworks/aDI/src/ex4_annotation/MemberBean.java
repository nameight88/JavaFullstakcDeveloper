package ex4_annotation;

import org.springframework.stereotype.Component;

@Component
public class MemberBean {

	private String name = "홍길숙";
	private int age =33;
	private String message = "맛점";
	
	public void output() {
		System.out.println(name+"["+age+"]"+message);
	}
}
