package d_array;
import java.util.*;
public class Ex01_성적 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("학생수를 입력하세요: ");
		int num = in.nextInt();
		int score[] = new int[num];
		for(int a = 0;a<num;a+=1) {
			System.out.println(a+"번 학생의 국어점수를 입력하세요: ");
			score[a]=in.nextInt();
		}
		int total = 0;
		for( int a= 0;a <num ;a+=1 ) {
			total += score[a];
		}
		int avg = total/num;
//		배열을 쓰는 목적 = 같은 작업을 안하기 위해서.
		//총점 구하기
//		for(int a = 0;a<num;a+=1) {
//			int sum =+ score[a];
//			System.out.println(sum);			
//		}
//
//			int avg = sum/a;
//			System.out.println(avg);
//		}
	}

}
