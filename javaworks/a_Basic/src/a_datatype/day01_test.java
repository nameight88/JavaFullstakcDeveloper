package a_datatype;

public class day01_test {public static void main(String[] args) {
	int age;
	age = 24;
	System.out.println(age);
	double kg = 78, cm = 175;
	System.out.println(cm);
	System.out.println(kg);
	System.out.println("나이="+age+",몸무게"+kg+",키="+cm);
byte a = 64;
byte b = 64;
byte result = (byte)(a+b);   // byte 라는 키워드를 사용했을때 용량이 넘치므로 컴파일 에러가 뜬다. 
// 위에는 자동으로 int로 계산을 할려고한다. byte로 계산을 할려고 하면
// byte result = (byte)(a+b); 로 하면 계산이 되긴한다.
System.out.println("result = " + result);
int i = 360;
byte c = (byte) i;
System.out.println("i=" + i);
System.out.println("c=" + c);} //byte는 360까지의 값을 담을 수 없기 때문에 byte로 변환을 하게 되면 byte -127~128까지
								//표현이 가능하기 때문에 360을 256으로 나누면 104가 남은 값이 출력이 된다.
char a = 'a';


}
  