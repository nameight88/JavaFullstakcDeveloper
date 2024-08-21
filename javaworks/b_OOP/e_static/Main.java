package e_static;
/*
 *  Static 
 *  - 각 개체들끼리 공유를 하고 싶을때 사용을 한다.
 */
public class Main {
	public static void main(String[] args) {
		
//		Book b1 = new Book();
//		System.out.println("책 갯수 = "+ b1.count);
//		Book b2 = new Book();
//		System.out.println("책 갯수 = "+ b2.count);
//		Book b3 = new Book();
//		System.out.println("책 갯수 = "+ b3.count);
//		
		

		Book b1 = new Book();
		System.out.println("책 갯수 = "+ Book.getCount());
		Book b2 = new Book();
		System.out.println("책 갯수 = "+ Book.getCount());
		Book b3 = new Book();
		System.out.println("책 갯수 = " + Book.getCount());
		
		System.out.println("책 객수=" + Book.getCount());
	


	}
}
