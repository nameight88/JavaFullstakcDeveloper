package b_review;
import java.util.*;


public class Main {

	public static void main(String[] args) {
		Product p = new Product();
		Scanner in = new Scanner(System.in);
		System.out.println("상품번호는 입력하세요: ");	
		System.out.println("상품명을 입력하세요: ");	
		System.out.println("초기재고량을 입력하세요: ");
		int stock = in.nextInt();
		p.setProdcutNo(in.next());
		p.setName(in.next());
		p.setStock(stock);
		
	
		System.out.println("판매량을 입력하세요: ");
		int sub = in.nextInt();
		p.sale(sub);
		p.output();
	
		
		
		System.out.println("입고량을 입력하세요: ");
		int add = in.nextInt();
		p.income(add);
		p.output();
		
		
		
	}

}
