package y_useful;
/*날짜 관련된 클래스 : java util 패키지 안에 있다.
 * 			'Date
 * 			'Calendar
 * 			'LocalDate
 * 			'LocalDateTime //LocalDate 쪽 함수들이 요즘 쓰이고 있다.
 */
import java.util.*;
public class Calendar_sample {


	public static void main(String[] args) {
		Calendar c= Calendar.getInstance(); //컴퓨터가 이미 시간 정보를 갖고 있기 때문에 getInstance를 사용한다.
		//년,월,일 구하기
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1; //월을 구하고나서 +1을 해줘야한다. 서양식 월개념은 자료형이 문자열이기 때문에 다르다.
		int date = c.get(Calendar.DATE );
		System.out.println(year+"/"+month+"/"+date);
		//시,분,초 구하기
		int hour = c.get(Calendar.HOUR);
		int min = c.get(Calendar.MINUTE);
		int sec = c.get(Calendar.SECOND);
		System.out.println(hour+"H "+min+"M "+sec+"S ");
		
		//요일 구하기
		//일요일:1
		String[] day_of_week= {"일","월","화","수","목","금","토"};
		int week_int = c.get(Calendar.DAY_OF_WEEK);
		System.out.println(day_of_week[week_int-1]+"요일입니다.");// -1을 안해주면 수요일이 아닌 목요일이 나온다.
		
		//배열 선언을 안했을시 switch 나 if문을 여러개를 써서 해야하기 때문에 배열을 하면 편하다.
		
	}

}
