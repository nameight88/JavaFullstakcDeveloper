package c_control;
import java.util.*;

/*
 * 문자를 입력을 받아 N이 소문자면 a부터 N까지 인쇄하고
 * N이 대문자면 N부터 z까지 출력하라
 * 그 밖의 문자가 입력되면 Error를 출력
 * 
 */
public class Ex14_for_연습2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("문자를 입력하세요: ");
		
		String str = in.nextLine();
		char ch = str.charAt(0);
		
		if( ch <= 'z' & ch >= 'a') 
		{for(char data1 = 'a' ;ch <= 'z' ; ch+= 1 ) 
		{System.out.print(ch);}
		
		
		
		}else if (ch <= 'Z'& ch >='A') {
			for(char data2 = 'Z';ch <= 'Z' ; ch+= 1) 
			{System.out.print(ch);}
			
		}else
			System.out.println("Error");
	}
		
		
//		
//		String str = in.nextLine(); //str="f"
//		char ch =str.charAt(0);
//		
//		for(char b = 'a' ; b <= ch; b +=1)
//		{System.out.print(b);}
//	System.out.println();}
//		String str = in.nextLine();
//		char ch = str.charAt(0);
//		
//		for(char b= 'a'; b <= 'z';b += 1)
//		{System.out.println(b);}
//		{System.out.println();}
	

	// 입력한 문자부터 z까지 출력
	
	
}
