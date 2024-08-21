package j_final;
/*
 * 	final: 변경불가
 * 	->final field : 상수(변하지 않는 값)
 *  ->final method : 오버라이딩을 못하게 만든다.
 *  ->final	class :  부모클래스가 안된다.
 *  
 *  [참고] 추상화는 부모클래스 역할만 할 수 있다.
 */
class parent{
	final String field = "부모님꺼"; // 자료형 앞쪽에 final을 붙히면 된다.
	final public void Home() { //[2]부모클래스에 home을 상수화를 하기위해서 final을 붙히면 오버라이딩이 안된다.
		System.out.println("부모님이 만드시거");
	}
}
class Child extends parent{
	public Child() {
	}
//	public void home() { //[1]오버라이딩 -> 부모클래스에 있는 home을 재정의
		//[3] 오류가 발생하게 된다.
		System.out.println("물려받아 탕진");
	}
 

public class Test {

	public static void main(String[] args) {
		parent p = new Child();
		System.out.println(p.field);
		p.home();
	}

}
