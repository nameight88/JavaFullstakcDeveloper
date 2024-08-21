package c_control;
import java.util.*;

public class Ex10_switch_전화번호 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("전화번호를 입력해주세여:");
		String tel = in.next();
		int idx = tel.indexOf('-');
//		System.out.println(idx);
		
		String localNum = tel.substring(0,idx);
//		System.out.println(localNum);
		
		/*
		 * 지역번호가 02면 서울
		 * 지역번호가 032면인천
		 * 그외에 한국
		 * 
		 */
		String local = "";
		switch(localNum){
		case "02" : local = ("서울입니다.");
			break;
		case "032" : local = ("인천입니다.");
			break;
		default : local = ("한국입니다.");
			
		}System.out.println("현재 번호는 " +local);
}

}
