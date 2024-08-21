package i_inherit3;

public class Dvd extends Item {
	Dvd() {
		System.out.println("자식 기본생성자");
	}

	String actor;
	String director;

	Dvd(String actor,String director,String num,String title){
		super(num, title);
		this.actor = actor;
		this.director = director;
		System.out.println("자식 인자생성자");
	}
	public void output() {
		System.out.println("번호: "+num);
		System.out.println("제목: "+title);
		System.out.println("배우: "+actor);
		System.out.println("감독: "+director);

	}	
}
