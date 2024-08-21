package e_mathod;

public class Ex02_return2 {

	public static void main(String[] args) {
		int []data = add(); // 이름을 다르게 해도 상관없지만 보통 헷갈리지 않게 같은 변수명으로 선언을 해준다.
		// 합산후 출력
		int sum = data[0] + data[1]; // int sum이라는 변수는 data [0]배열 값과 data[1]값을 더한다.
		System.out.println("합: "+sum);
	}
	static int[] add(){ //배열일 경우에도 똑같은 자료형으로 보내줘야한다.
	int a = 10, b = 20;
	int [] data = {a,b};
	return data; //리턴값은 1개만 가능하기 때문에 int a와 b를 data라는 배열에 초기화 후에 보내면 된다.
	}
}
//함수에서 어떤게 넘어가고 어떤걸 받는지를 확인을 잘 해줘야 한다.