package c_control;
/*
 * break: 블럭을 벗어나게 해주는 코드
 * continue: 블럭의 끝으로 가게 해주는 코드
 */
public class Ex20_Break_Cotinue {

	public static void main(String[] args) {
		for(int i = 0; i<2; i+=1) 
			for(int j =0;j<3; j +=1) {
			if(j == 1)break;}
//			if(j == 1)continue;
				System.out.println("<"+i+j+">");
			
		
System.out.println("데이터");
	}

}
