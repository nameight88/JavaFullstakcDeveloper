package a_datatype;


// 한줄 주석 '//'사용 -> 한줄 주석

/*
 * 여러줄
 * 주석
 * 
 */

/**
 * 여러줄 주석
 * 설명문 주석
 * 	이렇게 주석을 다는 방법이 3개가 있다.
 *
 */

/*
 * 명명 규칙
 * 	- 문자 + 숫자 + "_" (%)
 *  - 첫글자 숫자 금지
 *  - 길이제한 상관없음
 *  - 대소문자 구분 엄격히 
 *  - 키워드 안됨
 *  
 *  # 명명 권장사항
 *  	- 패키지명은 전부 소문자 사용 
 *  	- 클래스명은 첫글자는 대문자이면서 영단어의 첫글자 대문자 사용
 *  	 Ex)CuteDog
 *  		-> 낙타표기법(Camel Case)
 *  	-함수/변수명 첫글자는 소문자 but 영단어의 첫글자 대문자 사용
 *  		Ex)	catBathAndFeed
 *  	
 */



public class Ex01_constantname {

	public static void main(String[] args) {
	// 변수선언
	char	chName;
	int i;
	//int int; 키워드 중복으로 에러가 발생한다.
	double abcdefgh;
	boolean a;

	//값 저장
	chName = '김';  //문자형 ' '
	i = 100;
	abcdefgh = 3.6;
	a = true;
	
			//출력
	System.out.println(chName);
	System.out.print(i);
	System.out.println(abcdefgh);
	System.out.println(a);
	}

}


/*
	변수(costant)
	 - 매모리상에 값을 저장하는 공간
	 자료형 (data type)
	 1.기본형Primitive)
	 	-논리형 : boolean (1B) 값을 저장을 할때 true or false  둘중에 하나만 설정 가능
	 	-문자형 : char(2B)
	 	-정수형 : int(4B) / long(8B) 		(byte/short)
	 	-실수형 : double(8B) /  		(float)(4B)
	 	정수는 4B 실수는 8B
	 	변환하는데 용량을 적게 쓰는게 필요하다.
	 	
	 2.참조형(Reference)
	  	-배열 /클래스
*/


/* 참고 내용
	1 bit: 0 or 1
	8 bit = 1byte
	
	1024 byte(B) = 1KB
	1024KB =1MB
	1024MB =1GB
	1024GB =1TB
	int ; 4B = 32bit
		0ibt : 부호 (0=+,1:-)
		31bit = 숫자표현
		-2(31) ~ +2(31)
		대략 22억
*/

