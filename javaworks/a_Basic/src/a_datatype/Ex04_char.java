package a_datatype;

public class Ex04_char {

	public static void main(String[] args) {
		//자료형에 맞춰서 변수 설정을 해줘야한다.
		char ch ='a';
		System.out.println("문자:" + ch);
		
		int i = 'b';
		System.out.println("문자???" + i); //A자체를 아스키코드로 해석해서 출력을 했다.
		System.out.println("문자???" + (char)i); //앞에 캐스팅을 해줘서 아스키코드로 말고 A를 출력하게 만들어 준다.
		
		
	}

}
/*
 자바이전 언어의 문자체제 아스키코드(Ascii-code) (데이터 단위:1B)
 										1B = 2(8) = 256개 문자 표현
 										영어, 숫자 ,특수기호 등만 표현
 자바이후 언어의 문자체제 유니코드(Uni-code) (데이터 단위:2B)
 				2B = 2(16) = 65535개 문자 표현
 							-ascii-code 가 포함
 							-일본어, 중국어, 한국어 등 표현가능
 							- '\u0000' 이런식으로 표현
      *[ ASCII-CODE]
      	 =	0100 0001 = 'A' 앞에는 = 65
      		대문자 소문자
      	 => 0100 0010 = 'B' = 2(6) + 2(1) = 66
      	'E' = 0100 0101 = 2(s6) + 2(2) + 2(0) = 69
      	'a' = 0110 0001 = 97
      	'b' = 0110 0010 = 98
      	
*/