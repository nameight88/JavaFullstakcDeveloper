package ex5_autowired;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MessageBeanImpl implements MessageBean{

	private String name;
	private String message;

	public void setName(String name) {
		this.name= name;

	}
	public void setMessage(String message) {
		this.message =message;
	}
	@Autowired
	@Qualifier("outputer2")
	private Outputer outputer;
	//*******************
	//생성자없이 setter 없이 객체 주입
	
	public void sayHello() {
		System.out.println(name+"님의 메시지:"+message);
		try {
			outputer.writeMessage(name+"님의 메시지:"+message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
