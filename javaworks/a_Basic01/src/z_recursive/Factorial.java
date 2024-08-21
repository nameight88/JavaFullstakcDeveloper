package z_recursive;

public class Factorial {

	public static void main(String[] args) {
		 // 5!
		int Fac= 0;
		Fac = sumFunc(5);
		System.err.println("총합:"+Fac);
	}
	static int sumFunc(int i) {
		if ( i== 1) return 1;
		return i * sumFunc(i-1);
	}

}
