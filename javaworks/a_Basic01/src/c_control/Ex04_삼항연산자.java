package c_control;
import java.util.*;
public class Ex04_삼항연산자 {
/*
 * 삼항 연산자
 * 조건 ? 참인경우실행문; 거짓인경우실행문
 */
	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		System.out.println("당신의 점수를 입력하세요: ");
//		
//	
//		int score = in.nextInt();
//		
//		String result = (score > 80)? "합격":"불합격";
//		System.out.println("결과: " + result);

		
		Scanner in = new Scanner(System.in);
		System.out.println("값을 입력을 하세요: ");
		 
		int a = in.nextInt();
		int b = in.nextInt();
		int max = (a > b) ? a:b;
		System.out.println(max);
	}

}
