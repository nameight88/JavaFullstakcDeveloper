package c_control;

public class ex03_shortCircuitLogic {

	public static void main(String[] args) {
		int a = 3;
//		if (a>3 && ++a>3) {
//			System.out.println("조건만족");
//			System.out.println("A=" + a); //자바만 3이라는 결과 출력 앞에서 먼저 false로 인식이 되어서 뒤에 있는 ++a를 실행을 안함.
			
//		if (a>1 || ++a>3) {
//			System.out.println("조건만족2");
//			System.out.println("A="+a);}  //앞에가 먼저 True가 되었기 때문에 뒤에 있는 조건을 인식을 안하고 넘어갔다.
//		
		// shortCircuitLogic: 일반 논리 연산자에서 발생한다.
							// 앞에 조건에 의해 결과가 정해지면 뒤에 조건을 실행하지 않음.
	// 일반논리 연산자 자리에 이진논리연산자를 사용했을때	
		
		
//	if (a>3 & ++a>3) {
//			System.out.println("조건만족");
//			System.out.println("A=" + a); //
			
		if (a>1 | ++a>3) {
			System.out.println("조건만족2");
			}  //
	System.out.println("A="+a);
		
	
	}
	}



