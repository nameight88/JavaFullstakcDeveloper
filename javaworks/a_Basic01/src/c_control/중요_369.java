package c_control;
import java.util.*;

/*
 * 1부터 50까지 숫자 중에서 3,6,9 게임처럼
 * 3,6,9 숫자를 포함하면그 갯수만큼 "짝" 글자를 출력하고
 * 그렇지 않으면 그 숫자를 출력한다.
 */

public class 중요_369 {

	public static void main(String[] args) {

		for(int x= 1; x <=50; x +=1) { //50미만까지 변수는 1부터 시작해서 1씩증가한다 설정
			int num = x;	//변수 x를 설정
			boolean y369 =false; //참과 거짓을 판별 해주는 boolean 변수 설정

			while(num != 0) { //0이 아니였을때 반복문 설정

				int y = num % 10; //변수 x를 10으로 나누고 그 값을 담을 변수 설정
				if( y==3 || y == 6|| y == 9) {//변수 y 가
					System.out.print("짝");	  //3,6,9중에 하나가 나왔을때 "짝"을 출력하게끔 설정
					y369 = true;	//3,6,9 중에 하나를 달성을 했을때 y369 boolean true로변경
				}								//while 반복이 되어서 다시 진행을 한다.
			/*10으로 나눈 후에 369였을 경우 짝을 출력을 하고 아니였을 경우 다시 0이 될때까지 반복을 한다
			 * boolean 값을 설정을 해서 while이 빠져나왔을때 출력 할지 말지를 if문 조건에 걸어줘야한다.
			 * 0이 된후 boolean값을 기준으로 초기 설정값이랑 동일할 경우 변수 x의 현재 값을 출력을 하고
			 * 초기 설정값과 다를 경우에는 아무것도 출력을 안하게 설정을 했다.
			 */
				num /= 10; 
			}
			if(!y369) System.out.println(x); //369중에 하나를 달성을 하면 넘어가고 아니면 그 x변수의 현재 값을 출력
			else System.out.println();} //위의 경우가 아니였을경우 그냥 아무런 값 없이 출력

	}


}


//switch((char)y) {
//case '3':
//case '6':
//case '9':
//	System.out.println("짝");
//	break;
//	default: System.out.println(x);