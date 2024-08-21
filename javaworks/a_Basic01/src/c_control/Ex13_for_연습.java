package c_control;
import java.util.*;
public class Ex13_for_연습 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요: ");
		int num = in.nextInt();
			for(int a= 1 ; a<= num; a += 1)
				if(a %5 == 0 )
					{System.out.println(a);}
				else
					{System.out.print(a+" ");}
		
	}

}
