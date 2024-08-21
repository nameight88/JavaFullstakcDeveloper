package h_access;

/*
 * 접근지정자
 * 
 * private 
	public 
	protected 
 */
public class Access {

	private String a ="프라이빗";
	public String b = "퍼블릭";
	protected String c = "프로텍트";
	String d = "디폴트";

	public void output() {
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}






}
