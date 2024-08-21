package a_datatype;
/*
 * 자료형(datatype)
 * 1.기본형(primitive)
 * 		- 논리형:boolean
 * 		- 문자형:char
 * 		- 정수형:int / long
 * 		- 실수형:double
 * 2.참조형(reference): 클래스 / 배열
 * 		=>new 키워드를 옹해서 메모리(객체생성) 확보해야함
 * 
 * [ex] 이름이 홍길동
 * 		char a ='홍길동'; -> 에러발생
 * 		char b ='홍길동'; -> 에러발생
 * 		
 * [cf] 문자 1개 -> char
 * 		문자열 0개 이상 -> String(class)
 */
public class Ex05_String {

	public static void main(String[] args) {
		//char 함수로는 다 담을 수 없다.
		//참조형 변수 선언
		String name;
		//메모리 확보 (값지정) -> 객체생성
		name = new String("홍길동");
		String irum = new String("홍길동");
		
		if(name == irum)
			System.out.println("True");
		else
			System.out.println("False");
		//문자열 비교는 equals 함수를 이용을 해서 구별을 해주어야한다.
		if(name.equals(irum))
			System.out.println("True2");
		else
			System.out.println("False2");
	// 왠만하면 자바를 이용을 할때는 equals 함수를 이용을 하는게 좋다.
		// String 함수는 하나의 Class이다.
		
	}

}
