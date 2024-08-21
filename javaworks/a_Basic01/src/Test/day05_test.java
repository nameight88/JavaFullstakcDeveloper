package Test;
import java.util.*;

public class day05_test {public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	System.out.println("높이를 설정해주세요: ");	
//	System.out.println("종류를 설정해주세요: ");
	int y = in.nextInt();
//	int t = in.nextInt();



	for(int a = 0; a <= y; a +=1) {
		for(int b = 0; a<y - b; b += 1) {
			System.out.print("*");
		}System.out.println();
	}


//	for(int a= 0;a<=y ;a+=1 ){
//		for(int b = y; b-a >= 0;b -=1) {
//			System.out.print("*");
//		}System.out.println();
//	}
//	for(int a = 0; a <= y ; a+=1) {
//		for(int b = 0;b <= y ;b+=2) {
//			System.out.print("*");
//		}
//
//	}System.out.println();

	
	

	
}
}




