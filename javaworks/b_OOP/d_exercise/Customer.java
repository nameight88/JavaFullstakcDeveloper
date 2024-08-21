package d_exercise;
/*/*전화번호 이름 마일리지 변수가 필요함.
 * 
 */
 

public class Customer {
	private String tel;
	private String name;
	private int milage;
	
	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMilage(int milage) {
		this.milage = milage;
	}

	public String getTel() {
		return tel;
	}

	public String getName() {
		return name;
	}

	public int getMilage() {
		return milage;
	}

	void output() {
		System.out.println(name+"님"+tel+milage+"점 있습니다.");
	}
	//default constructor
	//아무것도 안했을시에 자동으로 생성을 해주지만 이미 생성자 함수를 하나 만들었기때문에
		//만들어 줘야한다.
		//무조건 맨위에 첫줄에서 사용을 해야한다.
	public Customer() {
		this("0000","이름없음",10);
	}
	
	
	// constructor
	public Customer(String name, String tel, int milage){
		this.name = "홍길순";
		this.milage = 10000;
		this.tel = "1234";
	
	}
	public Customer(String name, String tel ){
		this.name = "홍길순";
		this.tel = "1234";
		this.milage = 10000;
		
	}
	
}
