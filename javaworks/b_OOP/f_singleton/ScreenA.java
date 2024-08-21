package f_singleton;

public class ScreenA {
	DBConnect con;
	
	public ScreenA() {
		con = DBConnect.getInstance();
	}
	public void use() {
		System.out.println("");
	}
}
