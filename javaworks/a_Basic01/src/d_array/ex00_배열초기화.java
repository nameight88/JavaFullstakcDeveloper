package d_array;

public class ex00_배열초기화 {

	public static void main(String[] args) {
		int [] kor; 
		//배열 변수 선언
		kor = new int[5]; 
		//배열 객체 생성 -> kor이라는 공간에 int형 자료를 5개를 담을 공간을 생성한다.
		// 힙은 자동 초기화가 되서 맨처음 설정되어있는 값에다 0이 들어가있다.
		//값 지정
		kor[0] = 99;
		kor[1] = 88;
		kor[2] = 77;
		kor[3] = 66;
		kor[4] = 55;
		//배열 초기화
		//int [] kor = {}; 저장할 공간을 미리 설정을 안하고 뒤에 변수 값을 다 넣어주면 그거에 맞춰서 객체 생성이 가능하다.
		
		
		int total = 0;
		for(int i = 0;i <5;i +=1) {
			total += kor[i];
			// 일반적으로 성적의 합을 구하는 코드
			// 여기서 값을 하나만 지정을 해줘도 나머지 공간은 0으로 설정이 되어 있어서 상관이 없다.
			//지정한 공간을 이상으로 값을 더 넣으면 오류가 발생을 한다.
			//kor[5]라는 6번째 공간을 넣을려고 선언을 하고 실행을 햇을때
			/*Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
			  at a_Basic01/d_array.ex00_배열초기화.main(ex00_배열초기화.java:16)
			  이런식으로 오류가 발생을 한다.
			 */

		}
		System.out.println("총합: "+total);
		
		/* 변수선언
		 * int a = 0;
		 * 
		 * 
		 */
	}

}
