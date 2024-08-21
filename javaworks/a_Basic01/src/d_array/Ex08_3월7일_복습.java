package d_array;
//boolean 보통 false를 기본으로 설정해둔다.
public class Ex08_3월7일_복습 {

	public static void main(String[] args) {
		char [][]star = new char [4][] ;

		// 각각의 char 공간에 '*'저장하기

		//출력
		for(int i= 0 ;i < star.length ;i+=1 ) {   
			star[i] = new char [i+1]; // 동적 메모리 설정 | +1인 이유는 i가 0부터 시작을 하기 때문
			for(int j = 0;j < i+1; j+=1) {
				star[i][j] = '*';
				System.out.print(star[i][j]+" ");
			}System.out.println();
		}
	}
}
