package z_recursive;

//재귀호출 : 자기가 자기자신을 호출함
//피보나치 수열이나 펙토리얼 같은것을 구할때 사용이 된다.

public class ASumTest_recursive {
	public static void main(String[] args) {
		int sum = 0;
		sum = sumFunc(5);
		System.err.println("총합:"+sum);
	}
	static int sumFunc(int i) {
		if ( i== 1) return 1;
		return i + sumFunc(i-1);
	}
	static int pb(int i) {
		if ( i== 1) return 1;
		return i + sumFunc(i-1);
}}
