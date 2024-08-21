package l_collection;
import java.util.*;


public class Ex06_HashMap {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("javassem", "1111");
		map.put("kimjavassem", "2222");
		map.put("leejavassem", "5555");
		map.put("namjavassem", "4444");
		map.put("chajavassem", "1234");
		map.put("javassem", "1234"); //나중에 나온 키 값은 중복이 되어버리면 덮어버린다.
		Scanner in = new Scanner(System.in);
		
		boolean stop = false;
		while (!stop) {
			System.out.println("아이다와 비밀번호를 입력하세요: ");
			System.out.println("아이디-> ");
			String id =in.nextLine();
			System.out.println("비밀번호->");
			String pw = in.nextLine();
			// [1] 입력받은 아이다가 저장부분 key값에 있는지?
			if(map.containsKey(id)) {
				if((map.get(id)).equals(pw)) { //해당 아이디와 비밀번호가 같은지
					System.out.println("로그인 성공하셨습니다.");
					break;
				}else {
					System.out.println("비밀번호가 일치하지 않습니다.");
					continue;
				}
			}else { //key값이 없을시에 다시 while문을 돌린다.
				System.out.println("존재하지 않는 아이디입니다.");
				continue;
			}
		}
		
		
	}

}
