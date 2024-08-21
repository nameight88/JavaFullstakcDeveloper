package c_control;

import java.util.*;



/*
 * 자료형
 *  - 기본형 :boolean/ char/ int/ double
 *  - 참조형 : 클래스/ 배열
 *  		(*)String
 * 
 */
public class Ex01_if문_주민번호 {

	public static void main(String[] args) {
		String id = new String("991116-1234567");
		
		char sung = id.charAt(7); //문자를 그냥 가져오면 사라지기 때문에
								 // 저장할 공간을 만들어 줘야한다.
		if (sung == '1' || sung == '3' || sung == '9') {
			System.out.println("당신은 남자입니다.");}
		else if (sung == '0' || sung == '2' || sung == '4')// else 는 추가적인 조건을 걸어버릴 수가 없다.{
			System.out.println("당신은 여자입니다."); //인식을 할때 -와 같은 특수문자는 인식을 안하는거 같음
		//학번 주민번호 는 무조건 숫자처리가 아닌 문자처리로 한다. 숫자처리로 했을때 계산이 될수도 있기 때문에 문자처리로 해결한다.
		
//		Scanner input = new Scanner(System.in);
//		System.out.println("문자입력: ");
//		String str = input.next();
//		char ch = str.charAt(0);
//		// String ->char 형병환이 안된다.
//		//형변환은 기본형은 기본형끼리 참조형은 참조형끼리 같은 유형끼리만 형변환이 가능하다.
//		System.out.println("입력확인: " + ch);
		
		
	 
			}
		
		}



