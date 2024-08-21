package c_control;

public class Ex02_이진논리 {

	public static void main(String[] args) {

		int a = 15; // 00000000 00000000 00000000 00001111
		int b = 10; // 00000000 00000000 00000000 00001010
												//---------------
												// 0 0 0 0 1 0 1 0  and 연산자를 이용을 했을때는 둘다 같은 값이 나올떄만 1이 나온다.
		int or = a | b; 						// 0 0 0 0 1 1 1 1 	or 연산자를 이용을 했을때는 둘중에 하나라도 1이 이으면 조건을 충족하기 떄문에 1이 출력이 된다.
												// 0 0 0 0 0 1 0 1  xor 연산자를 이용 했을때는 둘의 값이 다른 경우에만 1이 나온다.
																// - xor 연산자는 이진논리에서만 적용이 가능하다.
		
		
		int and =  a & b ;
		
		System.out.println(and);
		System.out.println(or);
		
		int xor = a^b;
		
		
		System.out.println(xor);
		// xor; 둘 다 신호가 다른 경우에만 결과 발생
	}

}
