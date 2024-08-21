package c_control;

public class 복습3_for {
	// main 함수를 못만들었을 경우 main + ctrl + space
	public static void main(String[] args) {
		for(int count1 = 0; count1 <5 ; count1 +=1) {

			for (int count2 = 0;count2<4-count1;count2 +=1) 
				System.out.print(" ");{
				}

				for(int count = 0 ; count <count1+1; count +=1) {
					System.out.print("*");
				}System.out.println();}
	
		int i = 0, j = 0;
		for( i = 0 ; i < 5 ; i++ ) {
			for( j = 0 ; j < 4 ; j++ ) { 
				if( i == 2 && j == 1 ) break; //연산자 확인하기
				if( i == 3 && j == 2 ) continue;
				System.out.println("i = " + i + " , j =  "+  j );
			}
		}
	}

}
/*count <5 - count1
 * *****
 * 
 * ****
 * *** 
 * **
 * *
 * 
 * count <=count1
 * *
 * **
 * ***
 * ****
 * *****
 * 
 */

//for(int count1 = 0; count1 <5 ; count1 +=1) {
//	
//	for (int count2 = 0;count2<4-count1;count2 +=1) 
//		System.out.print(" ");{
//	}
//	
//	for(int count = 0 ; count <count1+1; count +=1) {
//		System.out.print("*");
//	}System.out.println();}
//}
//    *
//   **
//  ***
// **** 
//***** 이렇게 출력이 된다.

