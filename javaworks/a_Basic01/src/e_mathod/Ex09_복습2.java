package e_mathod;
import java.util.*;

public class Ex09_복습2 {

	public static void main(String[] args) {
		char [][] ch = input();//(input에서 makesquare에서 배열 초기화가 된 ch maint 함수에서 값을 받아준다.)
		output(ch); //JVM이 순서상으로 다시 아웃풋으로 가기 때문에 main으로 끌고 온  ch값을 다시 output으로 보내준다.
	}
	/*
	 * 역할 : 두 정수와 알파벳 문자 하나를 입력 받음
	 * 
	 * [예] 두 정수와 알파벳 문자 하나를 입력:
	 * 	34F
	 */
	static char [][] input() {
		Scanner in1 = new Scanner(System.in); //스캐너를 하나 더 만들어줘서 정수형과 문자를 따로 받을수 있게 해준다.
		Scanner in2 = new Scanner(System.in);
		System.out.println("두 정수와 문자 하나를 입력해주세요: ");
		int a = in1.nextInt();
		int b = in1.nextInt();
		String c = in2.next(); // 각각 정수와 문자를 받음
		char x = c.charAt(0); // 문자열을 문자로 추출
		makeSquare(a,b,x);
		char [][] ch = makeSquare(a,b,x); //makeSquare에 보낼때 a와 b만 보내는 것이 아니라 x까지 같이 보내줘야한다.
		return ch; //(makeSquare에서 값을 받고 저장할 공간을 ch 변수를 만들어서 저장을 해준다.)
		// 이름을 중복하게 만들어서 해주는걸 오버로딩이라고 한다.
	}
	/*
	 * 역할: makeSquare 안에서 생성한 문자배열에 저장된 문자를 화면에 출력해주세요.
	 */

	static void output(char [][]ch){//인자값을 넣어줄땐 똑같이 작성을 해줘야 받을 수 있다.
		for(int i =0 ; i<ch.length; i+=1) {
			for(int j = 0;j<ch[i].length; j+=1) {
				System.out.print(ch[i][j]); }System.out.println(); // 출력을 2차배열이기 때문에 for문 2번을 써서 출력값을 만들어준다.
		}
	}
	/*
	 * 역할: input()함수에서 입력받은 첫번째 정수만큼의 행과
	 * 		두번재 정수만큼의 열의 배열을 만들어서
	 * 		입력받은 문자를 시작하는 배열값을 지정합니다.
	 * 
	 * [예]
	 * 	F G H I
	 * 	J K L M
	 *  N O P Q
	 */
	static char[][] makeSquare(int a,int b,char x) {//자료형이 달라도 보낼 수 있다.(전부다 기본형 자료형이기 때문에 참조형이 있을 경우
		char [][] ch =new char [a][b];//배열 선언
		for(int i = 0;i<ch.length  ; i +=1) {	//범위를 a미만으로 하는게 아니라 배열 선언을 한 ch에서 범위를 설정을 해줘야한다.
			for(int j = 0;j<ch[i].length;j+=1) { 
				ch[i][j] = x +=1; //알파벳 하나 씩 증가하는거 예제를 접목을 시켰을때 이와 같은 코드가 나온다.
			}// (하나씩 증가하게 행과 열을 만들어서 다시 input으로 보내준다.)
		}return ch; //리턴을 보낼때 메서드 설정에서 자료형을 맞춰주고 리턴으로 보낼떄는 자료형을 맞춰주지 않아도 상관이 없다.
	}
}

