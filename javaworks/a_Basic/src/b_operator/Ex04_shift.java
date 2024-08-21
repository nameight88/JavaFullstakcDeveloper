package b_operator;

public class Ex04_shift {
/*
 * shift 연산자
 * 각각 비트이 값을 이동하는 연산자
 * 
 * 	 0010
 * 0 0100
 */
	public static void main(String[] args) {
		int a = 4;
		
		int b = a << 2;
		int c = a >> 1;
		
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		System.out.println("c=" + c);
		
		int d = a >>> 1;
		System.out.println("d="+ d);
	}

}
