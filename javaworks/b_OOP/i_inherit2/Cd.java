package i_inherit2;

public class Cd extends Item {
	Cd() {
		System.out.println("자식 기본생성자");
	}

	String singer;
	Cd(String singer,String num,String title){
		super(num, title);
		this.singer = singer;
		System.out.println("자식 인자생성자");
	}
	public void output() {
		System.out.println("번호: "+num);
		System.out.println("제목: "+title);
		System.out.println("가수: "+singer);
	}
}
