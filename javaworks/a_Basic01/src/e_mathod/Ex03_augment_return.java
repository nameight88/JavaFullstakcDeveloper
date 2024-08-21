package e_mathod;
/*
 * method명 :add
 * 인자 :int 형 2개를 보냄
 * 리턴형 두수를 더한 결과를 리턴
 * 역할 : 
 */
public class Ex03_augment_return {

	public static void main(String[] args) {
	
		int a= 10;
		int b= 20;
		int sum = add(a,b); //1.두 변수 a와 b를 add라는 함수(method)에 전달을 한다.
		System.out.println("합: "+sum); //3.리턴을 받은 값을 출력
		
		
	}
	static int add(int a, int b) {//2.두 변수 a와 b를 받았고 sum이라는 변수를 선언 후에 합을 구하고
								  // sum을 다시 메인 함수에 return을 한다.
		 int sum = a +b;
		 return sum;
	 }
}
//블럭 구분을 좀더 디테일하게 잡아주자