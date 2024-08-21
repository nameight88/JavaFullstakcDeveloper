package c_control;
import java.util.*;

public class 방탈출 {

	public static void main(String[] args) {
		int count = 0; //숫자가 8이 되었을때 카운트해서 기록을 담을 변수를 설정
		for(int x =1;x<=10000;x+=1) { //조건에서 10000미만에서 8을 카운트 하는 것이기때문에 1씩올라가면서 증가하는 반복문 설정
			int num= x;	
			while(num != 0) {
				int y = num % 10;
				if( y == 8) {
					count +=1;			
				}
				num /= 10;

			}

		}
		System.out.println(count);

	}

}
