package i_inherit2;

public class Item {

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
	
	
	public void output() {
		
	}

}
