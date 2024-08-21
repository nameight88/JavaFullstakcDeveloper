package c_control;

public class Ex18_dowhile개념 {
	public static void main(String[] args) {
		//		int x = 0;
		//		for(int count = 0 ;count <=10 ;count +=1 ) {
		//			x += count;
		////		}
		//		-------------------------------------------------
		//		int x = 0;
		//		int count = 1;
		//		while(count <= 10) {
		//			x += count;
		//			count +=1;
		//		}
		//		---------------------------------------------------
		int x = 0;
		int count = 1;
		do {
			x += count;
			count +=1;
		}while(count<=10);// while문과 다르게 비교를 먼저하고 그 후에 조건을 제시한다.
		System.out.println(x);
	}

}
