package e_mathod;

public class Ex00_흐름 {

	static void method() {
		System.out.println("메소드-함수 실행");
	}
	public static void main(String[] args) {
		System.out.println("main 시작");
		
		method(); //static void metod()에서 가서 실행을 하고나서 다시 11라인으로 돌아온다.
		System.out.println("메소드 중");
		method();
		
		System.out.println("main 끝");
	}

}
