package a_datatype;

public class Ex03_변수선언 {

	public static void main(String[] args) {
		//[1] 변수 선언 + 값 대입
		int kor; //정수형 kor 설정
		kor = 30; // kor 변수 대입
		
		//[2] 초기화: 변수선선시 값을 대입
		int eng = 30;
		//[3] 여러개의 변수인 경우
		int math =30, java = 50;
		
		
		if(kor == eng)
			System.out.println("True");
		else
			System.out.println("False");
		
		// 참고사항 swap : 두 변수의 값을 바꾸기
		int a = 10, b = 20;
		System.out.println("A=" +a + ",B+" + b);
		int temp = a;
		a = b;
		b = temp;
		System.out.println("A=" +a + ",=B" + b //변수를 지정을 할떄 공백도 지켜서 입력하기
				
				);
	}
}
