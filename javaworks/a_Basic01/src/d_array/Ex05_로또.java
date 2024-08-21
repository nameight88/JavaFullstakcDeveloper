package d_array;
/*
 * 임의의 수 (랜덤 수)
 * 
 *  math.random() : 0.0부터 1.0보다 작은 어떤 수
 *  
 *  math.random() * 10
 *  
 *  (int)(Math.random()*10)
 */
public class Ex05_로또 {
	public static void main(String[] args) {
		int []lotto = new int[6]; //숫자 6개를 담을 공간을 생성
		for(int i = 0; i<lotto.length; i +=1) {
			lotto[i] = (int)(Math.random()*45)+1;
		}
		for(int i = lotto.length-1;i>0;i-=1 ){
			for(int j = 0;j < i;j +=1) {
				if(lotto[j]>lotto[j+1]) {
					int temp = lotto[j];
					
					lotto[j] = lotto[j+1];
					lotto[j+1] = temp;
				}
			}
		}for(int a = 0;a <lotto.length ; a+=1) {
			System.out.print(lotto[a] + " ");
		}
	}
}
