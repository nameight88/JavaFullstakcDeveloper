package l_collection;
import java.util.*;
public class Ex02_ArrayList {
//get의 리턴형 자료형은 오브젝트
	public static void main(String[] args) {
		ArrayList<Student> list = method();
		//원래의 for문
//		for(int i = 0 ;i<list.size(); i+=1) {
//			Student s = (Student)list.get(i); //상위 클래스가 오브젝트이므로 상속관계를 이용을해서 클래스간의 형변환을 해줘야한다.
//			System.out.println(s.toString());
//		}
		//향상된 for 문 - 배열 리스트 셋 집합구조에서만 사용이 가능하고  gnerics가 되어야한다.
		for(Student s : list ) {
			System.out.println(s.toString());
		}
		
		//순서대로 검색만 하는 구조
		//Enumeration -> Iterator 
		
		
		//[참고]
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
	
	static ArrayList<Student>  method() {
//		Student a = new Student("홍길동",22);
//		Student b = new Student("홍길순",33);
//		Student c = new Student("홍길장",44); //먼저 변수들을 선언을 한 경우
//		
//		
//		ArrayList list = new ArrayList();
//		list.add(a);
//		list.add(b);
//		list.add(c);
		
		
		
		
		
		ArrayList<Student> list = new ArrayList<Student>(); //선언을 한번만하고나서 그 뒤로 안쓰일 경우
		list.add(new Student("홍길동",22));
		list.add(new Student("홍길순",33));
		list.add(new Student("홍길장",44));
		
		return list;
		
		
	}
}
