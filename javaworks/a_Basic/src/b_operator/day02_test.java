package b_operator;
import java.util.Scanner; // ctrl + shift + O -> 패키지 임포트 자동 단축키
import java.util.*;

/*
 * 정수 하나 받아서 3의 배수인지 여부를 출력
 * 
 * 
 */
public class day02_test {

	public static void main(String[] args) {
		System.out.println("정수를 입력하세여: ");
		
		Scanner input = new Scanner(System.in);
		
		int first = input.nextInt();
		if((first%3) == 0)
			System.out.println("3의 배수입니다.");
		else
			System.out.println("3의 배수가 아닙니다.");	
	

	}

}
