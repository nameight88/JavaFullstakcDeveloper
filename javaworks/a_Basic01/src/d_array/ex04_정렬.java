package d_array;

public class ex04_정렬 {
	public static void main(String[] args) {
		
		int []su = {20,2, 49,8,12,5}; //배열 설정
		
		//정렬(버블 정렬) 정렬의 방법은 여러가지가 있다.
		for(int i = su.length -1;i>0 ;i-- ) {
			for(int j = 0;j <i; j+=1) {
				if(su[j] > su[j+1]) { // 두 수를 비교를 해서 더 큰 숫자를 앞에 숫자와 교체
					int temp = su[j]; // 두 수를 바꿀때의 저장공간 확보
					su[j] = su[j+1];
					su[j+1] = temp;
				}
			}
		}
		//출력
		for (int i  = 0; i<su.length; i+=1) {
			System.out.print(su[i]+ " ");
		}
		
	}

}
