package c_array;
/*
 *	캡슐화
 *
 *	기본적으로 맴버변수 private 지정
 *		   맴버함수 public 지정
 * 데이터 접근을 범위 지정을 함으로써 보안성을 높힌다.
 * 
 * private 지정된 맴버는 접근을 할려고하면 setter/getter가 필요하다
 * stter와 gettr는 자동으로 만들어 지게끔 해줘야한다.
 * this :객체의 래퍼런스 (이름이 맴버 변수와 매개변수가 겹치는 경우가 있기 때문에 this로 구분을 해줘야한다.)
 * 		->맴버를 접근할 때 사용
 */

public class Student {
	
	
	String name;
		private int kor, eng , math;
		private int total;
		private double avg;
		
		
		int calTotal() {
			total  = kor + eng+ math;
			return total;
		}

		public double calAvg() {
			avg = (double)total/3;
			return avg;
		}
		//getter 
		public String getName() {
			return name;
		}//get의 역할은 다른 클래스에서 호출 하는것을 보내주는 역할을 한다.

		public void setName(String name) {
			this.name = name; //this 로 구별을 해준다.
		}
		//setter
		public void setKor(int kor) {
			this.kor = kor;
		}

		public void setEng(int eng) {
			this.eng = eng;
		}

		public void setMath(int math) {
			this.math = math;
		}
		
		
}




/*
 맴버변수(member fields) : 서로 다른 데이터타입의 변수들
 맴버함수(member mathod) : 맴버변수를 처리하는 역할
*/