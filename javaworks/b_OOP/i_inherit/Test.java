package i_inherit;
/*
 * 상속클래스는 자식 클래스는 부모 클래스를 사용 할 수 있어야한다.
 */

public class Test {
	public static void main(String[]args) {
		
//		Mom m = new Mom();
//		m.gene();
//		m.job();
		
//		Sister s = new Sister();
//		s.gene();
//		s.sytudy();
//		s.job(); 
		//상속을 하게 되면 부모 클래스에서 먼저 출력이 되고 그 다음에 자식 클래스가 생성이 된다.
		
//	객체 생성을 상상을 했을때 가계도를 생각을 하면된다. 자식 클래스는 부모 클래스의 메소드를 호출 할 수 있다.
		//단 부모 클래스는 자식 클래스의 메소드를 호출 할 수 없다.
		
		// 부모변수에 지식객체 생성
		Mom m2 = new Sister();
		m2.job();
		//m2.study(); // 부모 클래스는 자식 클래스에 있는 메소드를 호출 할 수 없다.
		//자식변수에 부모객체 생성불가
		//다른 언어는 부모 클래스에 있는 메소드를 호출해주지만 자바는 오버라이딩시 자식 객체에 있는 메소드를 호출해준다.
//		Sister s2 = new Mom();
		
	}
}
/*


	int a = 100; (O)
	double b = 3,6; (O)
	double b = 100; (O)
	int d = 3.6; (X)
	int d = (int)3.6(O)


*/