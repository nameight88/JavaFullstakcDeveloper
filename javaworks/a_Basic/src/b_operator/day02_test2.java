package b_operator;
import java.util.Scanner;
import java.util.*;

/*
 *  문자 하나를 받아서 그 문자가 대문자인지 소문자인지 출력
 *  
 *  문자 입력 -> 
 *  소문자입니다.
 *  비교 연산자와 일반논리연산자를 활용
 *  
 *  
 *  
 *  년도를 입력을 받아서 해당 년도가 윤년인지 평년인지 출력
 */
public class day02_test2 {

	public static void main(String[] args) {
		System.out.println("문자를 입력하세요: ");
		
		Scanner input = new Scanner(System.in);
		char a = (char) input.nextInt();
		if(Character.isUpperCase(a))
			System.out.println("대문자가 맞습니다.");
			else
				System.out.println("대문자가 아닙니다.");
			
		
		

	}

}
