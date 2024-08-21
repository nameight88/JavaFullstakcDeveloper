package i_inherit2;

public class Book extends Item {
	Book(){
		this("0000","제목없음","미상","미출판사");//this 함수는 무조건 처음에 나와야한다.
		System.out.println("자식 기본생성자");
		
	}
	String Writer;
	String publisher;

	Book(String num,String title,String Wtiter, String publisher){ 
		super(num, title);
		this.Writer = Writer;
		this.publisher = publisher;
		System.out.println("자식 인자생성자");
	}

	public void output() {
		System.out.println("번호: "+num);
		System.out.println("제목: "+title);
		System.out.println("작가: " +Writer);
		System.out.println("출판사: "+publisher);

	}

}
