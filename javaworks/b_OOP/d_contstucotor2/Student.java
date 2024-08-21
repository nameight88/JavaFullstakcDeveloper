package d_contstucotor2;

/*
 * this : 객체의 맴버를 지칭하기 위해
 * 
 * this() :다른 생성자함수를 호출
 *  -> 맨 첫 줄에 기술해야한다.
 */

public class Student {

	String name;
	private int kor, eng , math;
	private int total;
	private double avg;

	//			생성자함수
	Student(String name,int kor, int eng, int math){
		this.name= name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		System.out.println("인자생성자");
	}
	//			default constructor
	Student(){
//		this.name = "이름없음";
//		this.kor = 50;
//		this.eng = 50;
//		this.math = 50;
		this("이름없음",50,50,50); // 생성자함수를 이용
		System.out.println("기본생성자");
	}


	int calTotal() {
		total  = kor + eng+ math;
		return total;
	}

	public double calAvg() {
		avg = (double)total/3;
		return avg;
	}

	public String getName() {
		return name;
	}

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