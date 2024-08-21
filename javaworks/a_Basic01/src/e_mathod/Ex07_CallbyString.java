package e_mathod;

public class Ex07_CallbyString {

	public static void main(String[] args) {
		//call by reference 와 다르게 영향을 미치지 않는다. String 클래스 별개의 케이스이다.
		//주소 복사를 한게 아니라 새로운 메모리 공간에 똑같은 값을 넣었다.
		String a = ("안녕");
		String b = ("Hi");
		add(a, b);
		System.out.println("A= "+a+" B= "+b);

	}
	static void add(String a,String b) {
		a += b; // a= a+b;
		System.out.println("A= "+a+" B= "+b);
	}


}


