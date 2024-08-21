package d_array;
/*
 *로또 번호 생성
 *정렬
 *출력
 * 
 *
 */
public class Ex07_lotto {
	public static void main(String[] args) {
		//임임의 번호 생성
		int [][]lotto = new int [5][6];
		for(int i= 0; i< lotto.length;i+=1) {
			for(int j = 0;j < lotto[i].length;j+=1) {
				lotto[i][j] = (int)(Math.random()*45+1);
			}
		}
		//정렬
		for(int k = 0;k<lotto.length;k+=1) {
			for(int i = lotto.length; i>0; i -=1) {
				for(int j = 0; j<i ; j+=1) {
					if(lotto[k][j]>lotto[k][j+1]) {
						int a = lotto[k][j];
						lotto[k][j] = lotto[k][j+1];
						lotto[k][j+1] = a;}
				}
			}
		}
		//출력
		for(int a = 0 ; a <lotto.length; a+=1) {
			for (int b = 0; b <lotto[a].length ; b+=1) {
				System.out.print(lotto[a][b] + " ");
			}
			System.out.println();
		}
	}
}

