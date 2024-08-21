package c_control;

public class Ex12_for개념 {
	public static void main(String[] args) {
//		for(char ch ='A' ; ch <= 'Z' ; ch+=1 ) //A부터 Z까지 하나씩 증가하는 함수를 char ch로 설정한다.
			//for문을 사용할때 ";"를 2번을 사용을 한다. 
//			{System.out.print(ch);}
//		System.out.println();
//	for(char ch= 'Z' ; ch>='A'; ch--)
//	{System.out.println(ch);}
//	
//	
//	for(char ch='A'; ch <='S'; ch+=1)
//	{System.out.print(ch);}
//	}
//		int sum = 0;
//	for(int i=1 ;i<=10 ; i+=1 )
//		
//		//{sum = sum + i}와 같은 함수이다.
//	{sum += i;} 
//	System.out.print(sum);// 블럭안과 밖을 구분을 해주어야한다.
	
	/*
	 * 1부터 100까지 홀수의 합과 짝수의 합을 구해라
	 */
	int sum1 = 0; //짝수를 담을 변수 설정
	for (int a = 1 ;a <=100; a+=1) //100미만까지의 합을 구할 for문 작성
		if(a%2==0) // 2로 나누었을때 0이면 짝수
			{sum1 += a;} // 그 값들을 합한다.
	System.out.println(sum1);
	int sum2 = 0;
		for (int b = 1 ; b <= 100 ; b+=1)
		if(b%2!=0)
			{sum2 += b;}
	System.out.println(sum2);}
	//처음부터 변수를 2개를 설정을 하고 if 짝수 else 홀수 이런식으로 코드를 짜는게 반복 되는 부분이 적게 든다.
	
	
	{
//		
//	for(int a = 11; a>0; a-=1)
//	{System.out.println(a);}
			
//	//1~30


	 */
}		