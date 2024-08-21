package d_contstucotor2;

public class Main {

	public static void main(String[] args) {

		Student h = new Student(); 

		Student h2 = new Student("홍길동", 100,88,77);

		System.out.println(h.name + "님의 총점: " + h.calTotal()); // Student에서 만든 함수 메소드를 호출해서 출력

		System.out.println(h.name + "님의 평균: " + h.calAvg());

		System.out.println(h2.name + "님의 총점: " + h.calTotal()); 

		System.out.println(h2.name + "님의 평균: " + h.calAvg());


	}

}
