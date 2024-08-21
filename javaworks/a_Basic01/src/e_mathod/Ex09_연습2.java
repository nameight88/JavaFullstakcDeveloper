package e_mathod;
//메인 함수를 마지막에 두는 경우도 있고 위에 두는 것도 있는데 취향차이
import java.util.*;
public class Ex09_연습2 {
	public static void main(String[] args) {
		int []score = input();
		int avg = getCalc(score);
		char avgscore =output(avg);
		System.out.println("당신의 학점은 "+avgscore+"입니다.");
	}

	static int[] input() {
		Scanner in = new Scanner(System.in);
		System.out.println("국영수 점수를 입력하세요:  예시)100/100/100");
		String c = in.next();
		StringTokenizer st = new StringTokenizer(c,"/");
		int kor = Integer.parseInt(st.nextToken());
		int eng = Integer.parseInt(st.nextToken());
		int math = Integer.parseInt(st.nextToken()); //여기서 입력받은 값을 메인 함수에 있는 input으로 보내주고 getCalc으로 보내줘야한다.
		int [] score = {kor,eng,math}; //3개의 값을 보내기위해서 배열을 만들어서 보낸다.
		return score;
	}

	//역할 : 입력값을 국영수 점수로 촘정과 평균을 구해야한다.
	static int getCalc(int []score) {
		int sum = 0;
		int avg = 0;
		for (int i = 0;i<score.length;i+=1) {
			sum += score[i];
			avg =sum/3;
		}
		System.out.println("총점: "+sum+"입니다."+"평균은 "+avg+"입니다.");
		return avg;
	} 
	//평균값을 구해서 학점을 구하기
	static char output(int avg) {
		char avgscore ='0';
		switch((avg/10)) {
		case 10:
		case 9:
		case 8: avgscore = 'A';
		break;
		case 7:
		case 6: avgscore = 'B';
		break;
		case 5:
		case 4: avgscore = 'C';
		default : avgscore ='F';
		}
		return avgscore;
	}
}
