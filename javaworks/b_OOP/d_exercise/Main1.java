package d_exercise;
import java.util.*;


public class Main1 {
	

	public static void main(String[] args) {
		//객체 생성 = 메모리 할당을 받음 -> 초기화
		Customer c = new Customer(); 
		c.setTel("1234");
		c.setName("홍길순");
		c.setMilage(10000);
		
		c.output();
		Scanner in = new Scanner(System.in);
		
	}

}
