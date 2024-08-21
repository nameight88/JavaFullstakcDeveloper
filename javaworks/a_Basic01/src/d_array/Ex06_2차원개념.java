package d_array;

public class Ex06_2차원개념 {
	public static void main(String[] args) {
		int[][] data = new int [3][2];

data[2][0] = 3;

data[2][1] = 5;
// 값지정(저장)
	for(int i = 0;i<data.length; i +=1) {
		
		for(int j= 0;j<data[i].length;j +=1) {
			//각각의 배열값에 임의 수를 저장
			data[i][j] = (int)(Math.random()*10); //0이 안들어 갈려면 +1을 넣어주면 된다.
		}
	}


		for(int i= 0;i<data.length;i+=1) {
			for(int j = 0;j <data[i].length; j+=1) {
				System.out.print(data[i][j]+ " ");
			}System.out.println();
		}
	}
}
