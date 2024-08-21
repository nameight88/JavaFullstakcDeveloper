package c_array;
import java.util.*;
public class MainExercise {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("학생 수를 입력해주세요: ");
		Student [] s = new Student[in.nextInt()];

		for (int i = 0 ; i<s.length; i+=1){
			s[i] = new Student();
			System.out.println("학생의 이름을 입력하세요: ");
			s[i].setName(in.next());
			System.out.println("국어점수를 입력해주세요: ");
			s[i].setKor(in.nextInt());
			System.out.println("영어점수를 입력해주세요: ");
			s[i].setEng(in.nextInt());
			System.out.println("수학점수를 입력해주세요: ");
			s[i].setMath(in.nextInt());
			System.out.println(s[i].name+"님의 평균은 "+ s[i].calTotal() + "평균은 "+s[i].calAvg()+"입니다.");
			
		}


	}

}
