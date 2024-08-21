package c_control;
import java.util.*;
public class Ex07_if문전화번호 {

	public static void main(String[] args) {
		
//		String tel = "02-123-4567";
//		
//		//문자를 하나만 얻는 것은 char at
//		int idx = tel.indexOf("-");
//		String num = tel.substring(0,idx); //0부터 2앞에까지 꺼까지
//		
//		System.out.println(num);
		
		//System.out.println(idx);
		/*
		 * 지역 번호가 02이면 서울입니다
		 * 그렇지 않고 번호가 032이면 인천입니다.
		 * 그외의 번호는 한국입니다.
		 */
		Scanner in = new Scanner(System.in); //스캐너를 설치
		System.out.println("번호를 입력하세여 = "); //번호를 받을 input 생상
		String num = in.next(); //번호를 받아서 저장할 변수 생성
		
//		String localtel = "032-123-4567";
		
		int index = num.indexOf("-"); //번호를 받을곳을 "-"을 기준으로 슬라이싱
		String local = num.substring(0,index); //받을 번호는 첫번째부터 슬라이싱 앞에거 까지 저장
		
		if (local.equals ("02"))
			System.out.println("서울입니다.");
		else if (local.equals("032"))
			System.out.println("인천입니다.");
		else 
			System.out.println("한국입니다."); //02였을때 서울 032였을때 인천 그외에 한국이라는 if조건문 생성
		
		String city = " "; //빈문자를 변수를 선언을 해서 초기화를 해놔야 에러가 발생하지 않는다.
		char ch = num.charAt(5);
		
		if(local.equals("02")) {{
			city = "서울";
		}if(ch == '3') { 
				System.out.println("마포구입니다.");
		}else {
				System.out.println("강남구입니다.");
			}}else if(local.equals("032")) { 
			city = "인천";
			}else 
			city = "한국";
		System.out.println(city + "입니다.");
		//여기서 city = " "로 미리 초기화를 해놓은 상태로 else부분을 없애면 에러가 발생하지 않고 작동한다.
	
		}
//	char at = num.charAt(5);
//	System.out.println(at);
//	
	/*
	 * 지역번호가 02라면 "서울입니다."
	 * 서울인경우에 5번째 문자의 값이 3이라면 마포구
	 * 그렇지 않으면 강남구 라고 출력
	 */
	
	
	

	private static String next() {
		// TODO Auto-generated method stub
		return null;
	}

}
