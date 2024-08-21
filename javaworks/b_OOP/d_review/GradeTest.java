package d_review;
import java.util.*;

public class GradeTest {

	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	System.out.println("점수를 입력하세요: ");
	String score = in.nextLine();
	StringTokenizer st = new StringTokenizer(score,",");
	int count = st.countTokens();
//	int count = Integer.parseInt(st.nextToken());
	int [] jumsu = new int [count];//배열 선언 및 배열 생성
	for(int i = 0; i<jumsu.length; i +=1) {
		jumsu[i] = Integer.parseInt(st.nextToken());
	}
	
	
//	int [] jumsu = new int [3];
//	jumsu[0] = 100;
//	jumsu[1] = 90;
//	jumsu[2] = 80;
	
	GradeExpr a =new GradeExpr(jumsu);
	
	
	System.out.println("총점:"+a.getTotal());
	System.out.println("평균:"+a.getAverage());
	System.out.println("최저 점수: "+a.getBadScore());
	System.out.println("최고 점수: "+a.getGoodScore());
	}

}
