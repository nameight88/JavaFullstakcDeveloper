package c_control;

public class Ex_05대입연산자 {
	
	public static void main(String[]args) {
	int a =10;
	int b =7;
	
	a = a + b;
	System.out.println("result= "+a); 
	
	a -= b;
	System.out.println("result="+a); //20
	
	a += b;
	System.out.println("result="+a); // 17
	
	a *= b;
	System.out.println("result="+a); // 119
	
	a /= b;
	System.out.println("result="+a); // 17
	
	a %= b;
	System.out.println("result="+a); // 3
	}
}
