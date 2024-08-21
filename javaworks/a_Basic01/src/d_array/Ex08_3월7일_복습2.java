package d_array;
import java.util.*;
public class Ex08_3월7일_복습2 {


	public static void main(String[] args) {
		String result = func(); //리턴 값을 받을 변수를 설정을 해준다
		//		System.out.println("당신은"+result+"입니다.");	
		method(result);
	}
	static void method(String result) {
		System.out.println("당신은"+result+"입니다.");
	}
	//역할 : 콘솔창에서 점수를 입력을 받을것
	// 해당 점수가 80점 이상이면 합격 아니면 불합격	
	static String func() { //리턴 값에 맞춰서 void 대신에 String으로 설정을 해준다.
		Scanner in = new Scanner(System.in);
		System.out.println("점수를 입력하세요: ");
		int score = in.nextInt();
		if(score >= 80){
			return "합격"; //프린트 값 말고 리턴 값으로 설정을 한다.
		}else{
			return "불합격";
		}

	}

}
