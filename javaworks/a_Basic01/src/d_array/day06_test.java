package d_array;

public class day06_test {

	public static void main(String[] args) {
		//		int [] arr = {66,55,44,33,22,11};
		//		int sum = 0;
		//
		//		for(int i= 0;i<arr.length;i+=1) {
		//			sum += arr[i];
		//		}
		//		System.out.println("sum = "+sum);
		//	}
		//	int  [] [] arr = { 	{ 90, 90, 90, 90, 90 },
		//			{ 80, 80, 80, 80, 80 },
		//			{ 70, 70, 70, 70, 70 },
		//			{ 60, 60, 60, 60, 60 } };
		//			
		//	int  sum = 0;
		///*  배열의 각각의 값을 더하는 코드 */ 
		//	
		//for(int i= 0; i <arr.length;i +=1) {
		//	
		//	for(int j = 0;j <arr[i].length;j+=1) {
		//		sum += arr[i][j]; //2차원 배열 개념을 배울때 주의
		//	}
		//}
		//
		//System.out.println( "sum = " + sum );
		int  [] [] score = { { 98, 98, 90, 92, 99 },
				{ 81, 82, 83, 84, 85 },						
				{ 60, 65, 60, 65, 69 }, 
				{ 77, 74, 79, 78, 72} };

		int  sum[] = new int[ score.length];
	
		/*  배열의 각각의 값을 더하는 코드 */ 
		for(int i = 0;i <score.length; i+=0) {
			for(int j = 0;j <score[i].length; j+=0) {
				sum[i] += score[i][j];
			}
		}
		for(int i=0; i<score.length; i+=1){
			System.out.println( i+"번째 학생의 총점 " + sum[i] );
			System.out.println( i+"번째 학생의 평균 " + sum[i]/5 );		
		}
	}
}


