package Test;
import java.util.*;
public class Mathod_01 {

	private static boolean x;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("영문자 하나를 입력하세요: ");
		String a = in.next();
		char b = a.charAt(0);
		//메소드 호출	
		 boolean x = checkLower(b);
		System.out.println(x);
	}
	
	//메소드 선언
	/*
	 * 영문자 입력을 하고 그 문자가 소문자이면 true을 반환 그렇지 않으면 false
	 */
	static boolean checkLower(char b) {
		boolean x = false;
		if(b <= 'z' | b <='a'){
			x = true;
			return x;
		}else{
			x = false;
			return x;}
		}
}
	
