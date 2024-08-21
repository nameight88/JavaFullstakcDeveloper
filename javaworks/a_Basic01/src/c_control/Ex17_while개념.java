package c_control;
import java.util.*;
public class Ex17_while개념 {
	public static void main(String[] args) {
		//		int sum = 0;
		//		
		//		for(int count = 1 ; count <=10 ; count +=1) { //증감연산자 순서 주의
		//			
		//			sum +=count;
		//			System.out.println(sum);}
		//------------------------------------------------------
		//		int sum = 0;
		//		int count = 1;
		//		for( ; count <=10 ; count +=1) { //증감연산자 순서 주의
		//			sum +=count;
		//			System.out.println(sum);} 

		//--------------------------------------------------------------	

		/*	for문은 반복 횟수가 정해져있을때
		 * 	while문은 반복횟수가 정해져있지 않은 경우
		 */
		//		int sum = 0;
		//		int count = 1;
		////		for( ;  ; ) 
		//		
		//			while (count <= 10) {
		//			sum += count;
		//			count +=1;
		//			System.out.println(sum);} 
		Scanner in = new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요");
		
		int num = in.nextInt();
//		for (int count = 1; count <=9; count +=1) {
//			int a = count*num;
//			System.out.println(a);
//		}
		int count = 1;
		while (count <= 9){
			int a = num*count;
			count +=1;
//			System.out.println(a);
			System.out.println(num+"단" + num+"*"+count+" = "+ a );}
			
			
		}
	}


