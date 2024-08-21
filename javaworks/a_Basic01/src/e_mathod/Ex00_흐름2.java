package e_mathod;

public class Ex00_흐름2 {
	public static void main(String[] args) {//A C E F D B
		System.out.println("A");
		test();
		System.out.println("B");
	}
	static void test() {
		System.out.println("C");
		sample();
		imsi();
		System.out.println("D");			
	}	 
	static void sample() {
		System.out.println("E");	
	}
	static void imsi() {
		System.out.println("F");	
	}



}
