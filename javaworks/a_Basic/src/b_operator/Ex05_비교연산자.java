package b_operator;

public class Ex05_비교연산자 {

	public static void main(String[] args) {
	/*
	 * 비교연산자
	 *  == , != , >=, <=
	 * 
	 * 
	 */
		
		int kor = 60; 
		int eng = 70;
		int math = 80;
		int sum = (kor + eng + math);
		int avg = sum/3;
		System.out.println(sum);
		System.out.println(avg); // 정수형끼리 계산을 했을때 정수형 값으로 나오기만한다.
								//소수점 까지 표현을 하고싶으면 앞에 변수 설정을 double로하고
								//캐스팅도 double을 해주자.
		 
		if(avg>= 90)
			System.out.println("A학점");
		else if( avg >= 90)
			System.out.println("B학점");
		else if (avg >=70)
			System.out.println("C학점");
		else
			System.out.println("F학점");
	}

} 
