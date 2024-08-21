package g_innerclass;
/*
 * InnerClass
 * 클래스 안에 클래스가 있다.
 */

class Outer{
	
	 static class Inner{ // [2]스태틱을 붙혔을 경우
		static void nanaba() { //[3] 안쪽까지 스태틱을 붙혔을 경우
			System.out.println("잡아보슈");
		}
	}
}


public class test {
	public static void main(String[] args) {
		//[1]
//		Outer o = new Outer();
//		Outer.Inner in = o.new Inner();
//		in.nanaba();
		
		//[2]
//		Outer.Inner in = new Outer.Inner();
//		in.nanaba();
		
		//[3]
		Outer.Inner.nanaba();
	}
}
