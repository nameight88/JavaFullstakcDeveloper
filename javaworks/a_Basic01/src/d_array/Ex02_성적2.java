package d_array;
import java.util.*;

public class Ex02_성적2 {
	/*
	 * 5명의 국어점수를 입력하세요(입력예시: 10/10/10/10/10) ->55/66/75/69/72
	 * 총점은 xxxx이고, 평균은 oooo입니다.
	 */

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		System.out.println("5명의 국어 점수를 입력하세요: (입력예시 : 10/10/10/10/10)");
		String score_str = in.nextLine();// 점수를 받음
		StringTokenizer st = new StringTokenizer(score_str,"/");//받은 점수를 "/"를 기준으로 나눠서 저장을 한다.
		int num = st.countTokens(); //나눈 것들을 카운트해서 num이라는 새로운 변수에 초기화
		int [] score = new int[num]; //socre라는 변수에 num변수를 배열 초기화
		for(int i = 0;i<num;i +=1) {
			score [i] = Integer.parseInt(st.nextToken());
		} int sum = 0;
		for (int i = 0; i<num;i +=1) {
			sum += score[i];
			
		}int avg = sum/num;
		System.out.println("총점은 "+sum+"이고,"+"평균은 "+avg+"입니다.");
		 
	}
	}

//{
//
//public static void main(String[] args) {
//	Scanner input = new Scanner(System.in);
//	System.out.println("5명의 국어점수를 입력하세요 ( 입력예시 : 10/10/10/10/10 ) -> ");
//	String score_str = input.nextLine();
//	 
//	 StringTokenizer st = new StringTokenizer(score_str,"/");
//	 int cnt = st.countTokens();
//	 System.out.println("갯수:" + cnt);
//	 int [] score = new int[cnt];
//	
//		for(int i=0;  i<cnt ; i++) {
//			score[i] = Integer.parseInt( st.nextToken() );
//		}
//		
//		int total = 0;
//		for(int i=0;  i< cnt ; i++) {
//			total += score[i];
//		}
//	System.out.println("총점: " + total);
//	 
//}
//
//}
