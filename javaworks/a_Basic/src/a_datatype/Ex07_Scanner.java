package a_datatype;

import java.util.Scanner; // ctrl + shift + O -> 패키지 임포트 자동 단축키
import java.util.*;
/*
 *  콘설에 출력
 *  	System.out
 *  			print()
 *  			println()
 *  			printf()
 *  			
 *  콘솔에 입력
 *  	Systme.in
 *  			
 *  	-> Scanner 이용	
 *  
 *  		문자열 입력시 : next() / nextLine() --> 둘의 차이
 *  		정수형 입력시 : nentInt()
 *  		실수형 입력시 : nextDouble()
 *  		
 */
public class Ex07_Scanner {

	public static void main(String[] args) {
//	
//		System.out.println("이름을 입력하세여 ->");
//		
//		Scanner input = new Scanner(System.in);
//		String name = input.nextLine();
//		System.out.println("당신의 이름은 " + name + "입니다.");
			//System은 자바 안에 lang 이라는 것에 자체적으로 탑재가 되어 있다.
		 
		/*
		 * 두 정수를 입력받아 변수 first,second
		 * add
		 * print
		 *
		 */
		System.out.println("정수를 입력하세요 ->");
		
		Scanner input = new Scanner(System.in);
		int first = input.nextInt();
		int second = input.nextInt();
		int add = (first+second);
		System.out.println(add);
		
		
	}

}
