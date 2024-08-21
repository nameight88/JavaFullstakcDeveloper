package b_operator;

import java.util.Scanner; 
import java.util.*;
/*
 * 년도를 입력을 받아서 해당 년도가 윤년인지 평년인지 출력
 */
public class day02_test03 {

	public static void main(String[] args) {
	System.out.println("년도를 입력하세요: ");
	
	Scanner input = new Scanner(System.in);
	int year = input.nextInt();
	if((year%4) == 0)
		System.out.println("윤년입니다.");
	else if ((400%0) ==0)
		System.out.println("윤년입니다.");
	
	else
		System.out.println("평년입니다.");

	}

}
