package f_singleton;
/*
 * 목적: DBConnect 객체가 1개 공유
 */
public class DBConnect {
	//2.새로운 맴버 변수 하나 선언
	static DBConnect con; // = null;을 안해도 아무것도 없는 값을 가지고 있다.

	private DBConnect() { //1.public 대신에 private 로 접근 제한을 걸어준다. (다른 함수하고 겹치지 않게 만들기위해서)
		System.out.println("디비연동");
	}
	public static DBConnect getInstance() { //3.객체 생성이 되기전에 메모리를 먼저 받기위해 static 으로 바꿔줘야한다.
		if(con == null) {
			con = new DBConnect();
		}
		return con; //딱 한번의 메모리를 할당 받기 위한 코드
	}
	//주의 void를 붙히면 생성자 함수가 아니게 된다.
	
	//이런식의 코드를 싱글톤 패턴이라고 부르고 이렇게 코드를 짠후 메인에서 출력을 하면 디비연동이라는 값은 한번만 나오게된다.
}
