package l_collection;
import java.util.*;
public class Ex03_Set {

	public static void main(String[] args) {
		
		HashSet<String> set = new HashSet<String>();
		set.add("rabbit");
		set.add("dog");
		set.add("fox");
		set.add("ant");
		set.add("lion");
		set.add("dog");
		set.add("zebra");
		
		System.out.println(set);
		//출력을 할때 중복 값을 넣지 않는다.
		//순서를 저장하지 않기 때문에 자동으로 정렬이 된다.
	}

}
