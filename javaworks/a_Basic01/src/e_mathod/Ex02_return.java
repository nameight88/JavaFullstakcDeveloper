package e_mathod;
// return : 제어권을 반환

public class Ex02_return {

	public static void main(String[] args) {
		
		int sum = add();// 출력을 add() 에서 return 값을 받아서 하고 싶을때
		System.out.println("sum: "+ sum);
		
	}
	
	static int add() { //void가 있을때는 return시 데이터를 안보내겠다는 것이고 원하는 데이터를 보내고 싶으면 맞는 데이터 형을 void대신에 넣어줘야한다.
		int a= 10 , b = 20; //여기서 값을 만듬
		int sum = a+b;
		return sum; //이렇게 하면 제어권을 main함수에게 제어권을 준다.
				//return시 데이터를 하나만 가지고 넘어 갈 수 있다.
				//
	}
}
