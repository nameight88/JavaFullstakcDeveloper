package c_array;
import java.util.*;
public class Main {
// 3명의 학생의 국영수 점수를 입력받아서 총점의 평균을 구하기
// 클래스 배열 경우
	/*
	 * 배열도 new로 객체 생성필요
	 * 클래스도 new로 새로 생성을 해줘야한다.
	 */
	public static void main(String[] args) {
		Student [] s = new Student[3];
		Scanner in = new Scanner(System.in);
		
		
		for(int i = 0; i<s.length ; i+=1) {
			s[i] = new Student();
			System.out.println("이름을 입력하세요: ");
			s[i].setName(in.next());
			//Exception in thread "main" java.lang.NullPointerException: Cannot invoke "c_array.Student.setName(String)" because "s[i]" is null
			//at c_array.Main.main(Main.java:14) new로 새로운 객체 생성을 안해주면 student 안에 null이라는 값만 존재하는 걸로 인시하기 떄문에 새로 객체 생성을 해서 값을 받아줘야한다.
			
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
