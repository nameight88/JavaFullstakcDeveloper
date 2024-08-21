package a_basic;

public class Main {

	public static void main(String[] args) {
		// (1) 변수선언
		Student h = new Student(); //이전에 만든 Student 객체를 생성함으로써 호출이 가능하다.
		
		//(2) 클래스와 배열은 무조건 객체 생성을 해야한다. new 연산자 이용
		
		
		
		h.name = "홍길동"; //Student에서 name 변수를 호출
		h.kor = 100;
		h.eng = 88;
		h.math = 77;
		
		System.out.println(h.name + "님의 총점: " + h.calTotal()); // Student에서 만든 함수 메소드를 호출해서 출력
		
		System.out.println(h.name + "님의 평균: " + h.calAvg());

	}
 
}
