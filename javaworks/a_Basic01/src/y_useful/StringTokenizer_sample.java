package y_useful;
import java.util.*;;


public class StringTokenizer_sample {
	// 기본적으로 문자열을 쉽게 구분하기 쉽게 해주는 클래스이다.
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("문장을 입력하세요: "); // 안녕 하이 홍길동
		String sent = input.nextLine(); 
		//		System.out.println(sent);

		StringTokenizer st = new StringTokenizer(sent);
		while( st.hasMoreTokens()) {
			System.out.println(st.nextToken());	//사용자가 문자를 얼마나 입력을 할지 모르기때문에 while문을 사용하는게 좋다.
		}
		//new StringTokenizer(sent,"/"); 구분을 하는 기준을 나누고 싶으면 이런식으로 코드를 짜주면 된다.
		 
	}

}