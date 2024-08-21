package l_collection;
import java.util.*;

public class Ex01_ArrayList {

	public static void main(String[] args) {
		ArrayList<String> list = new  ArrayList<String>(4); //<String>를 추가해주면 gnerics라 하는데 데이터 타입을 정해줘서 노란줄을 없애준다.
		list.add("rabbit");									// gnerics는 해도 되고 안해도 되는 것
		list.add("tiger");
		list.add("ant");
		list.add("fox");
		list.add("lion");
		
		
		//처음에 배열을 4개를 선언을 했지만
		//ArrayList가 4개를 초과 했을 경우 자동으로 공간을 받을 메모리를 추가해준다.
		
		System.out.println(list);
		
		list.set(3,"dog");
		System.out.println(list); // 인덱스로 찾아가기 때문에 교체가 가능하다.
		
		list.remove(4);	
		System.out.println(list); //제거도 가능
		
		Collections.sort(list); //기본적인 알파벳도 정렬이 가능하다.
		System.out.println(list);
	}

}
