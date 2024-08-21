package c_control;
import java.util.*;
/*
 * 
 * 10자리중 앞에 4자리 입학년도 5번째 단과대 번호
 * 1 공대 2사회대
 * 6~7번째 각 학과번호
 * 공과대학인경우
 * 11- 컴공 12-소프트웨어 13-모바일
 * 22-자바
 * 33-서버
 * 사회대학인경우
 * 11-사회
 * 12-경영
 * 13-경제
 * 
 * 
 */
public class day03_test {
	public static void main (String[]args) {
		Scanner in = new Scanner(System.in); //스캐너를 사용하기위해서 부르고 저장
		System.out.println("10자리학번을 입력하세여 = "); //인풋 받을 공간을 생성
		String num = in.next(); //10자리 학번을 입력할 변수
		int ch = num.charAt(4);// 10자리 받은 번호중에서 5번째 번호를 추출해서 저장
		String sub = num.substring(5,7);//   
		 
		String type = " ";
		if(ch == '1'){ {System.out.println("공과대학");
			if(sub.equals("11")) {System.out.println("컴퓨터과학과입니다.");}
			else if(sub.equals("12")) {System.out.println("소프트웨어학과입니다.");}
			else if(sub.equals("13")) {System.out.println("모바일학과입니다.");}
			else if(sub.equals("22")) {System.out.println("자바학과입니다.");}
			else if(sub.equals("33")) {System.out.println("서버학과입니다.");}
			
		}}else if(ch == '2') {System.out.println("사회대학");}{
			if(sub.equals("11")) {System.out.println("사회과입니다.");}
			else if(sub.equals("12")) {System.out.println("경영학과입니다.");}
			else if(sub.equals("13")) {System.out.println("경제학과입니다.");}}
		
			
		
		
			
		
		
	
		
		
		
		
		
	}

}
