package k_wrapper;
import java.util.*;
public class Test2 {

	public static void main(String[] args) {
		ArrayList list = method();
		for(int i =0; i<list.size(); i+=1) {
			System.out.println(list.get(i));
		}
	}
	static ArrayList method() {
		String name = "홍길동";
		int    age = 30;
		double height = 180.88;
		ArrayList list = new ArrayList(2); //Object [] 이면서 크기가 자동으로 추가된다.
		list.add(name);
		list.add(height);
		list.add(age);
		
		return list;
	}
}
