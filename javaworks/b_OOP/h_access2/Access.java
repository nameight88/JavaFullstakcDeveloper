package h_access2;
//[1] 뒤에 sub를 붙혀준다.

/*
 * 접근지정자
 * 
 * private :다른 클래스에서 접근제한
	public : 다른 패키지에서도 접근 허용
	protected : 동일패키지에서 접근허용
				다른패키지인 경우 자식 클래스만 허용
	default : 동일패키지에서 접근허용
 */
public class Access {

	private String a ="프라이빗";
	public String b = "퍼블릭";
	protected String c = "프로젝티드";
	String d = "디폴트";

	public void output() {
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}






}
