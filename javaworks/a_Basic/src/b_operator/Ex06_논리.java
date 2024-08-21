package b_operator;

public class Ex06_논리 {

	/*
	 * 논리 연산자
	 * 
	 *  -일반논리: &&(and) ||(or)
	 *  
	 *  -이진논리: & 		|	^
	 *  
	 * A    B		A&&B   A||B     입력신호가 둘다 들어왔을떄 and 연산자
	 * 0(F) 0(F)	0		0		둘중에 하나에 신호가 들어왔을때 or 연산자
	 * 0(F) 1(T)	0		1
	 * 1(T) 0(F)	0		1
	 * 1(T) 1(T)	1		1
	 */
	
	public static void main(String[] args) {
		int 성적 = 75;
		char 태도 = 'A';
		
		if(성적 >= 80 || 태도 == 'A') //성적이 80점 이상 "이거나" 태도가 "A"이면 우등생
			System.out.println("우등생");
		
		if(성적 >= 80 && 태도 == 'A')//성적이 80점 이상 "이고" 태고가 "A"이면 성적향상반
			System.out.println("성적향상반");
		else
			System.out.println("성적향상반이 아님");
		

	}

}
