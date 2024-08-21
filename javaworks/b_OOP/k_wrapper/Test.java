package k_wrapper;
/*
 * 기본 자료형 -> 클래스로 만들어줌 나중에 = Wrapper class
 * int 			Integer
 * double		Double
 * char			Character
 * boolean 		Boolean
 * 
 */

// 요즘 트랜드는 Wrapper 클래스 사용하는걸 지향한다.
public class Test {

	public static void main(String[] args) {
		Object [] a = method();
		for(int i = 0 ; i<a.length;i+=1) {
//			a[i].output();
		}
		
	}
	static Object []  method() {
		String name = "홍길동";
		int    age = 30;
		double height = 180.88;
		Object [] a = new Object[3];
		a[0] = name;
		a[1] = age; //버전이 높아서 Integer로 변환이 되었다.
		a[2] = height;
		return a;
		
	}
	
}
