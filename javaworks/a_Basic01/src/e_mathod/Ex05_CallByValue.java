package e_mathod;
/*
 * Call by value
 * :인자의 자료형이 기본형인 경우
 *  원래 데이터에 영향이 없음
 */
public class Ex05_CallByValue {

	public static void main(String[] args) {
		int a = 10, b = 20;
		add(a,b);
		System.out.println("A= "+a+"B= "+b);
	} // 데이터를 복사를 하고 원래의 값에는 변화가 없다. add 메소드가 출력을 하고나서 add 메소드의 메모리는 없다.
	static void add(int a, int b) {
		a += b;
		System.out.println("A= "+a+"B= "+b);
	} 
}
