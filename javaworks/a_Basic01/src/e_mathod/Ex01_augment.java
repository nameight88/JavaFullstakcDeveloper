package e_mathod;

/* [함수-메소드 구조]
 *  리턴형 메소드명 (파라메타 변수){
 *  
 *  }
 *  리턴형 : 반환하는 값의 자료형
 *  	void : 없다.
 *  파라메타 변수 : 인자(augment)를 받는 변수
 *  			없으면 안써도 된다.
 */
public class Ex01_augment {
	int a = 10, b= 20;
	static void add(int a, int b) {
		int sum = a + b;
		
		System.out.println("합=" + sum); //오류가 발생을 햿는데 변수들은 함수 내에 있는 함수끼리만 계산이 가능하다.
	}

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		add(a,b); //처음에 함수를 설정을 할때 자바만 static을 붙여야 인식이 가능하다.
		//메소드의 함수가 끝나고 나면 메소드에 담겨 있는 메모리는 사라진다.

	}

}
