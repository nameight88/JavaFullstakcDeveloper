package d_contstucotor;
/*
 * 변수선언 int a ;
 * 값 지정 a =10;
 * 
 * 변수 초기화
 * int a = 10;
 * 클래스 객체를 초기화 할려면 어떻게 해야할까
 */

public class Main {

	public static void main(String[] args) {
		// (1) 변수선언 + 객체생성 = new이용
//		Student h = new Student("홍길동", 100,88,77); 

		Student h = new Student(); 

		
		/*
		 * 클래스(=객체) 초기화
		 * 변수선언 + 값지정
		 */
		
		System.out.println(h.name + "님의 총점: " + h.calTotal()); // Student에서 만든 함수 메소드를 호출해서 출력
		
		System.out.println(h.name + "님의 평균: " + h.calAvg());

	}
 
}
