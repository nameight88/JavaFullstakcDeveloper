package d_contstucotor;
/*
 * 생성자함수(constuctor)
 * 	-클래스의 맴버값을 초기화 할 때 사용을 한다.
 * 	-클래스가 객체화(인스턴스화) -> 메모리 공간확보
 *  -객체화 될때 실행되는 함수 ->new사용
 *  
 *  -클래스명과 동일한 이름을 사용을 해야한다.
 *  -리턴형이 없어야한다.(void까지 포함)
 *  -오버로딩 가능하다.
 *  	->매개변수의 타입과 갯수가 다른 동일한 이름의 함수로 설정이 가능하다.
 *  [참고]
// */
//	class A {
//		int A =10
//				void A() {
		//자바는 자동으로 이렇게 메소드와 인트 자료형은 구분을 해준다.	
			//void를 붙일 경우 일반 함수가 된다.
//			//a(){} -> 생성자함수
//
//			
//		}
//	}

/*
 * [참고] 기본생성자함수:default constructor
 * 	-생성자함수가 한 개도 없는 경우 자동으로 추가된다.
 * 		Student(){}
 *  -기본생성자함수는 습관적으로 하나 만들어 두자.
 */
public class Student {
	
	
	String name;
		private int kor, eng , math;
		private int total;
		private double avg;
		
//		생성자함수
		Student(String name,int kor, int eng, int math){
			this.name= name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
		Student(){	
		this.name = "이름없음";
		this.kor = 95;
		this.eng = 90;
		this.math = 80;
		
		
		}
		
		
		int calTotal() {
			total  = kor + eng+ math;
			return total;
		}

		public double calAvg() {
			avg = (double)total/3;
			return avg;
		}
	
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name; //this 로 구별을 해준다.
		}
		//setter
		public void setKor(int kor) {
			this.kor = kor;
		}

		public void setEng(int eng) {
			this.eng = eng;
		}

		public void setMath(int math) {
			this.math = math;
		}
		
		
}




/*
 맴버변수(member fields) : 서로 다른 데이터타입의 변수들
 맴버함수(member mathod) : 맴버변수를 처리하는 역할
*/