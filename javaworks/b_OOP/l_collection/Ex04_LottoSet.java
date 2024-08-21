package l_collection;
import java.util.*;

public class Ex04_LottoSet {

	public static void main(String[] args) {
		Set lottos = new HashSet();
		
//		for(int i = 0; lottos.size()<6 ;i+=1)
		while(lottos.size()<6){ //변수 i가 하는 역할의 비중이 적으므로 없애도 된다.
			int num = (int)(Math.random()*45+1);
			lottos.add(num);
		}
		ArrayList list = new ArrayList(lottos);//[2] set 구조를 ArrayList에 넣어서 정렬이 되게끔 구조를 바꿔준다.
		Collections.sort(list); //[1] set구조는 콜렉션에서 정렬을 할수가 없다.
		System.out.println(lottos);
	}

}
