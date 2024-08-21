package e_mathod;

public class Ex08_메인인자 {
	//함수명(메소드명) : main
	//리턴형		 : void
	//			 	반환하는 리턴값이 없음
	// 매개변수(파라미터) :String[]
	// JVM이 문자열 배열을 받을 준비를 하고 있다.
	public static void main(String[] args) {
	
		for(int i = 0;i<args.length ; i+=1) {
			System.out.println(args[i]);
		}
		
	/*
	 * 
	 * > javac Ex08_메인인자.java
	 * 
	 * > java Ex08_메인인자 문자열
	 * 
	 * 
	 */
	}

}
