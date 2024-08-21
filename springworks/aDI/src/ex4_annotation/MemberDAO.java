package ex4_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberDAO {
	//@Component 앞에 별칭을 부여 할 수 있다.
	//@Component("mDAO")
	
	//DI******************
	@Autowired
	private MemberBean member;
	
	//************************************
	//생성자나 setter 이용하여 맴버변수 지정해야함!!!
	
	public void insert(){
		member.output();
	}
}
