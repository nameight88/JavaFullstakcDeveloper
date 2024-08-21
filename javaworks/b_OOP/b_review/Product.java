package b_review;

public class Product {
	int add;
	int sub;
	int stock;
	private String productNo;
	private String Name;
	private int Stock;
	
	public int income(int add ) {
		this.add= stock +add;
		return this.add;
		
		
	}
	public int sale (int sub ) {
		this.sub = stock - sub;
		return this.sub;
	
	}
	public void output() {
		System.out.println("상품번호: "+productNo+ ",상품명: "+Name+",재고량: "+Stock);
		
		
	}
	public void setProdcutNo(String prodcutNo) {
		this.productNo = prodcutNo;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setStock(int stock) {
		Stock = stock;
	}
}
