package a_datatype;

public class Ex06_StringSpcial {

	public static void main(String[] args) {
		
		//******************
		// String 클래스는 참조형이다.
		// 전무후무 유일하게 딱 하나
		// String 클랫만 new 를 안써도 되게끔 만들어준다.
		
		String hong = ("홍길동");
		String dong = ("홍길동");
		System.out.println(hong);
		System.out.println(dong);
		if ( hong == dong)
			System.out.println("True");
		else
			System.out.println("False");
		
		if (hong.equals(dong))
			
			System.out.println("True");
		else
			System.out.println("False");
				//new 를 안써서 만들게 되면 자바가 "홍길동"이라는 객체를 하나의 공간에서 만들기 떄문에
				//if == 를 쓰거나 equal 함수를 둘다 썻을때 True 가 나오게 된다.
				//new 를 써써 만들게 되면 새로운 객체 공간을 만든다.
		
		
		
}

}
