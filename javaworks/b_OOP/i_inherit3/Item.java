package i_inherit3;

public abstract class Item {//미완성 함수가 1개라도 있게 되면 클래스도 미완성 클래스로 바꿔줘야한다.

	protected String num;
	protected String title;
	
	public Item(){
		System.out.println("부모 기본생성자");
	}

	public Item(String num,String title)
	{this.num = num;
	this.title = title;
	System.out.println("부모 인자 생성자");
	}
	
	//구현없는 미완성함수
	public abstract void output();
	//abstract 를 선언해주면 미완성 함수 취급이 된다.
	 // 오버라이딩 필수임
}
