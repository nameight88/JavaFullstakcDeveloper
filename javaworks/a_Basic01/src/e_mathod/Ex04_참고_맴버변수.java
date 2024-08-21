package e_mathod;
/*
 * 맴버변수 : 클래스 안에 변수
 * 맴버함수(맴버 메소드) : 함수(method)
 */
public class Ex04_참고_맴버변수 {
//함수 안에서 만들어진 변수 때문에 여러가지 메소드를 만들어서 리턴값을 보내고 인자를 받고 해서 여러가지 일을 처리 한다.
	//맴버 변수
			static int a = 10, b= 20;
			static int sum = 0; 	//현재 만들어진 맴버 변수는 main과 add 메소드 밖에서도 적용이 된다.
	public static void main(String[] args) { // 맴버 함수
		add();
		System.out.println("합: "+ sum);
	}
	static void add() {
		sum = a+b;
	}
}
