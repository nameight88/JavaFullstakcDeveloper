package c_control;
import java.util.*;

public class 연습_나이구하기 {
	/*9 : 숫자
	 * '9' : 문자 char
	 * "9" : 문자열 String
	 * 
	 */
	public static void main(String[] args) {
		String id = "241212-3234567";
		String age_str = id.substring(0,2);

		//String -> int 형으로 변환
		Calendar c= Calendar.getInstance(); 
		int year = c.get(Calendar.YEAR);
		int age = Integer.parseInt(age_str);
		System.out.println(age);
		char x = id.charAt(7);

		int age_i = 0;
		if(x == '1' | x == '2') { //&&는 and ||or 연산자
			age_i = year - ( 1900+ age) + 1;
		}
		else if (x == '3' | x == '4') {
			age_i = year - ( 2000+ age) + 1;
		}
		//	switch(x) {
		//	case '1' :
		//	case '2' :
		//	break;
		//	case '3' :
		//	case '4' :
		//	break;

		System.out.println("나이: "+age_i);}

}
