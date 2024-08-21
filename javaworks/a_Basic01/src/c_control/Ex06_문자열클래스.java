package c_control;
/*
 * 문자열 처리 클래스
 * 	-String
 * 	-String Buffer
 * 	-String Builder 둘의 차이는 락이 걸리고 안걸리고 차이
 * 
 */
public class Ex06_문자열클래스 {
	public static void main(String[] args) {
	String s = new String("홍길동");
	System.out.println("String"+ s);
	StringBuilder sb = new StringBuilder("강호동");
	System.out.println("SB"+sb);
	StringBuilder sb2 = new StringBuilder("강호동2");
	System.out.println("SB"+sb);// StringBuilder,StringBuffer 둘다 생성을
								// 할때 new를 붙혀줘야한다.
	String s3 = new String("강호동3");
	s3 += "화이팅"; // + 산술연산 =>숫자에게만 사용 가능함
				//String class의 특징
				// -new를 붙히지 않고 생성이 가능하다
				// - + 연산이 가능하다(버퍼와 빌더는 사용이 불가능하다)
				// 스트링 클래스는 내용이 달라지면 새로운 매모리에 공간을 잡는다.
	
//스트링 버퍼 하나의 매모리에 추가(새로운 변화나 변수가 많아지면 버퍼나 빌더)
//일반 스트링은 새로운 매모리에 공간을 추가(변화가 변수가 적으면 스트링)
	
//가비지 콜렉터는 아무런 데이터가 없는 내용을 자동으로 가져간다.
//가비지 컬렉터를 호출 하는 함수는 우선순위가 낮다.
	
	StringBuilder sb4 = new StringBuilder("강호동4");
	sb4.append("화이팅");
	System.out.println("SB"+sb4); //이렇게 하는게 문법적인이야기

	
	
	
	
	}

}
