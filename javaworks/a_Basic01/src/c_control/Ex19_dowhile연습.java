package c_control;

import java.util.Scanner;

public class Ex19_dowhile연습 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		String answer = "";
		do {			
			System.out.println("구구단의 단수->");			
			int dan = in.nextInt();
			for(int i=1; i<=9; i++) {
				System.out.println(dan +"*" + i + "=" + dan*i );
			}	
			System.out.println("계속하시겠습니까?(Y|N)");
			answer = in.next();
		} while( answer.equals("Y") | answer.equals("y") );

		//[2] while 문이용:반복 횟수를 모를때 
		//		Scanner in = new Scanner(System.in);
		//		System.out.println("구구단의 단수를 입력하세요: ");
		//		int num = in.nextInt();
		//		while(true) {
		//			for(int x= 1; x<=9; x+=1) {
		//				System.out.println(num +"*" + x + "=" + num*x );
		//			}
		//			System.out.println("종료를 원하십니다?(Y|N)");
		//			String answer = in.next();
		//			if(answer.equals("Y")|answer.equals("y")) break;
		//		}



		// 구구단의 단수를 입력받아서 해당 구구단을 출력
		//				Scanner input = new Scanner(System.in);
		//				
		//				// [1] for 문이용 : 반복횟수가 정해진 경우
		//				System.out.println("구구단 몇 번 반복할까요?");
		//				int  num = input.nextInt();
		//				
		//				for( int j=0; j<num; j++) {			
		//					System.out.println("구구단의 단수->");
		//					 
		//					int dan = input.nextInt();
		//					for(int i=1; i<=9; i++) {
		//						System.out.println(dan +"*" + i + "=" + dan*i );
		//					}	
		//				}



		}
}			
