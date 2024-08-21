package b_operator;

public class Ex01_증가감소 {

	public static void main(String[] args) {
		int a = 5;
		int b = 7;
		
		//[0]
		System.out.println("A="+a +",B+"+b);
		System.out.println("A="+a+1 +",B+"+b+1); //숫자와의 연산으로 한것이 아니라 문자열끼리의 조합이기때문에
												//6과 8이 나온것이 아니라 51과 71이 나왔다.
		System.out.println("A="+(a+1) +",B+"+(b+1)); //괄호를 사용하여서 우선순위를 정해서 출력
		a = a + 1;
		b = b - 1;
		System.out.println("A="+a +",B+"+b); //앞에 미리 연산을 하고나서 출력을 해도된다.
		
		/*
		 * C와 자바는
		 * 증가연산자와
		 * 감소연산자가 존재한다.
		 * 증가연산자 ++
		 * 감소연산자 --
		 *
		 */
		++a;
		--b;
		System.out.println("A="+a +",B+"+b);
		
		a++;
		b--;
		System.out.println("A="+a +",B+"+b);
		
		// 위의 두가지 케이스는 다른 케이스다.
		
		int c = 10;
		int result = ++c;
		System.out.println("결과:" + result);
		int d = 10;
		int result2 = d++;
		System.out.println("결과2:" + result2); //++을 앞에 붙히면 연산 순서가 달라진다.
											//++을 뒤에 붙히게 되면 출력을 하고나서 연산이 붙어서 위의 결과가 다르게 나온다.
		
		System.out.println("d=" + d);
		// 증가 감소 연산자는 자바 C언어 까지는 사용이 가능하고 파이썬이후 언어부터는 불가능하다.
		double x = 5;
		double y = 9;
		System.out.println("X="+ ++x + "Y="+ --y); //x=6 y=8
		System.out.println("X=" + x++ + "Y=" + y--); //x= 6 y=8
		System.out.println("X="+ x + "Y=" + y);  // x= 7 y=7
		
	}

}
