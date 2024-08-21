package a_datatype;

public class Ex02_형변환 {

	public static void main(String[] args) {

		//***** 	기본형
		// (1)변수의 자료형과 값이 일치
		// (2)크기가 큰 자료형에 작은 값을 넣을 때 (자동형변환)
		// (3) 크기가 작은 자료형에 큰 값을 넣을때
		// -> 에러발생
		// -> 형변환필요(****casting)
		//
		int z;
		z = (int)1.6; //int함수로 형변환을 해서 double에서 담을 수 있는 데이터량이기떄문에 표현 할 수 있는 만큼만 한다.
		System.out.println(z);
		int su;
		su = '수';
		System.out.println(su);
		double d;
		d = 100000;
		System.out.println(d);
//		int su2;
//		su2 = 1.2; 
//		float f;
//		f = 1.2; // 4B 변수에 8B 값을 넣고자 하는 상황 -> 에러 발생
		float f;
		f = 1.2f;
		System.out.println(f);
		long big;
		big = 10000000000000L; //L을 붙힘으로써 Long으로 변환
		System.out.println(big);}
	
		{}
		

}
//코드 줄 맞춤 ctrl + a >> ctrl + i
// ''을 쓸떈 자료 하나만 들어간다
// " "을 할땐 자료형이 들어간다.
