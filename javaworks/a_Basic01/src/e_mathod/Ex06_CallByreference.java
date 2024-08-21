package e_mathod;
/*
 *  Call By reference
 *   - 메소드의 인자가 참조형인 경우
 *   - 주소복사가 되어 원본에 영향을 미친다.
 *   - 주소가 같기 때문에
 */
public class Ex06_CallByreference {

	public static void main(String[] args) {
		StringBuffer a =new StringBuffer("안녕");
		StringBuffer b =new StringBuffer("Hi");
		add(a, b);
		System.out.println("A= "+a+" B= "+b);
		
	}
	static void add(StringBuffer a,StringBuffer b) { //값을 넘겨 줄때 주소를 넘겨주기 때문에 변화를 주면 주소도 같이 변해서 호출 후에 값에 영향을 준다.
		a.append(b);
		System.out.println("A= "+a+" B= "+b);
	}
}
