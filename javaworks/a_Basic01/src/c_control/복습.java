package c_control;
import java.util.*;

/*
 * 100점 만점의 학생 점수르 입력을 받아 80~90 사이라면
 * "평균" 이라고 출력
 * 학생 점수 변수 선언
 * 
 */

public class 복습 {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in); //스캐너 함수를 a라고 선언을 했다.
		System.out.println("점수를 입력하세요:"); //스캐너 함수를 a라고 선언을 해서 사용을 할려면 in이나 input이 아닌 a로 사용을 해야한다.
		int rate = a.nextInt();
		if (rate > 80 & rate < 90) {
			System.out.println("평균입니다.");
		}else {
			System.out.println("평균이 아닙니다.");
			//컴파일 + 실행 : 이클립스에서는 ctrl + F11 다른 IDE는 다른 단축키다.
			// java -> class
			//[참고] F11 - debug
			//브레이크 포인트 설정후 F6으로 하나씩 시작
		}

	}

}
