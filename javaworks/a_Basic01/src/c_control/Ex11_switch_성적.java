package c_control;
import java.util.*;
/*
 * 국어 영어 수학 성적
 */
public class Ex11_switch_성적 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("성적을 입력하세요:");
		
		int korScore = in.nextInt();
		int engScore = in.nextInt();
		int mathScore = in.nextInt();
		
		int total = (korScore + engScore + mathScore);
		
		int avg = (total/3);
		
		System.out.println("평균 점수:"+avg);
		
		char avgscore = '0'; 
		
		switch((avg / 10)) {
		case 10:
		case 9 : avgscore = 'A'; //10이 였을때의 경우의 수도 생각을 해줘야한다.
		 break;
		case 8 : avgscore = 'B';
		 break;
		case 7 : avgscore = 'c';
		 break;
		default : avgscore ='F';
		
		}System.out.println(avgscore); 
		
		
/*ㅇ
 * 자료형 구분을 잘 해야한다.
 */

	


	}

}
