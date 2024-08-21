package e_static;

public class Book {
	//맴버 변수는 자동으로 초기화가 된다.
	private static int count;
	
	//지역변수는 선언을 해줘야한다.
	
	public Book(){
		count +=1;
		System.out.println("책 학권 생성");
	
	}
//	public int getCount() {
//		return count; //static로 포함을 안시켜주면 가져올 수 가 없다.
//	}
	public static int getCount() {
		return count;
	}

}
