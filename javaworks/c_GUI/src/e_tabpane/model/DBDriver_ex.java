package e_tabpane.model;
// 싱클톤 패턴
// 웹에선 기본적으로 쓰이는 패턴이다.
/*
 * 웹에서 사람들이 많은 사람들이 접속을 했을때의 
 */
public class DBDriver_ex {
//여기서 DB드라이버를 하나 만들어 줘서 각각의 모델들에게 각각 선언을 적게 해줘서 적은 메모리를 차지 할 수 있게 한다.
	static DBDriver_ex dbd = null;
	private DBDriver_ex() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("드라이버 로딩");
	}
	//처음에 dbd == null 값으로 가지고 있었을때 DB드라이버 객체를 생성을 하게 만들어주고
	// 그 이후엔 값을 가지게 되었으므로 그 값을 리턴한다.
	public static DBDriver_ex getInstance() throws Exception {
		if ( dbd == null) dbd = new DBDriver_ex();
		return dbd;
	}
}
