package d_array;
import java.util.*;
public class Ex03_최대값찾기 {
	/*최대값은 배열 중에서 가장 큰 값을 찾아내는 알고리즘이다. 

사람은 데이타를 보면 척보고 어느것이 가장 크고, 어느것이 가장 작은지 알아낼 수 있다.

그러나 컴퓨터는 본다, 비교한다 라는 기능을 자동으로 할 수 없으므로 두뇌가 행동하는 것과 같은 기능을 부여해야 한다. 

최대값을 찾는 방법은 이렇다. 

​

우선 임의의 변수를 정의하고 예를 들어 max 라 하자. 

​

1. 이 변수에 배열의 첫번째 값을 입력한다. 

2. 이 값이 가장 크다고 가정하고 다음번 방에 있는 데이타와 비교를 한다. 

3. 이 변수에 저장된 값보다 큰 값이 들어오면 더 큰 값으로 저장 한다. 

4. 이 과정(2-3단계)을 배열이 끝날때 까지 반복하면 된다. 
	 * 
	 */
	public static void main(String[] args) {
		//	Scanner in = new Scanner(System.in);
		//	System.out.println("숫자들을 입력해주세요: ");
		//	int num = in.nextInt();
		//	int [] x =new int[num];
		//	int max_a = x[0];
		//	for (int i =1;i <x.length; i+=1) {
		//		if(max_a < x[i]) {
		//			max_a = x[i];
		//		}System.out.println("가장 큰 값: "+ max_a);
		//	}

		int[]su = {38,4,20,88,57,29,5};
		int max = su[0]; //배열에서 최대값을 찾는 방법은 하나의 수를 넣어주고 그 수를 하나씩 비교하면서 더 작은 수를 만나면 무시 더 큰 수를 만나면 그 수를 넣어서 비교를 한다.
		for (int i = 1; i < su.length ;i+=1) {
			if(max < su[i]) {
				max =su [i];
			}
		}System.out.println("가장 큰 값: "+ max);

	}

}
