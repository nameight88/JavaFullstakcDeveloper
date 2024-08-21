package c_control;


public class 복습2 {

	public static void main(String[] args) {
		String sn = "891212-1234567";
		char g = sn.charAt(0);
		//		if (g == '0' || g == '9') {
		//			System.out.println("Mz세대입니다.");
		//		}else if(g == '0' || g == '9'){
		//			System.out.println("청년입니다.");
		//		}else if (g == '8') {
		//		System.out.println("젊은이입니다.");
		//		}else{
		//		System.ouy.println("정상인입니다.");
		//		}	
		//	}
		switch(g) {
		case '0' :
		case '9' :System.out.println("청년입니다.");
		break;
		case '8':System.out.println("젊은이입니다.");
		break;
		default : System.out.println("정상인입니다.");
		}

	}	

}


