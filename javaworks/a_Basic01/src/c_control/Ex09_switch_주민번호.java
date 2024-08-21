package c_control;

public class Ex09_switch_주민번호 {
	public static void main(String[] args) {
		String id ="800102-4234567";
		
//		char ch = id.charAt(8);
		char ch = id.charAt(7);
//		System.out.println(ch);
		
		
		/* 출신지값
		 * 0 서울 출신
		 * 1라면 인천/부산
		 * 2라면 경기
		 * 
		 */
//		String city = ""; 
//		if (ch == '0') {
//		System.out.println("서울입니다.");
//		}else if(ch == '1'){System.out.println("인천/부산입니다.");
//		}else if (ch == '2') {
//			System.err.println("경기입니다.");
//		}
		//위의 코드를 스위치 코드로 전환
		
//		switch(ch) {
//		case '0' : System.out.println("서울입니다.");
//				break;
//		case '1' : System.out.println("인천/부산입니다.");
//				break;
//		case '2' : System.out.println("경기입니다.");
//				break; //여기서 중요한것은 케이스 별로 break를 걸어줘야 내가 원하는 값만 나오게 유도 할 수 있다.
//		default : System.out.println("한국인");
		//프로그램에 반복되는 코드가 많으면 줄일 수 있을까 고민을 해보자
		
//		String city = "";
//		switch(ch) {
//		case '0' : city =("서울입니다.");
//				break;
//		case '1' : city = ("인천/부산입니다.");
//				break;
//		case '2' : city = ("경기입니다.");
//				break; 
////		default : city = ("한국인"); // 여기서 city에 ""라는 공간을 마련을 해주면 default 값으로 초기화를 안해줘도 된다.
//	
//		}
//		System.out.println(city + "출신입니다.");
//		}
		
		String 성별 = "";
		switch(ch) {
		case '9' :
		case '3' :
		case '1' : 성별 = ("남성입니다."); //일일히 "남성입니다."를 붙혀주지 않고 break전에 한번만 걸어주면 된다.
			break;
		case '4' :
		case '0' :
		case '2' : 성별 = ("여성입니다."); 
			break;
					
		}System.out.println(성별);
	}
	}


