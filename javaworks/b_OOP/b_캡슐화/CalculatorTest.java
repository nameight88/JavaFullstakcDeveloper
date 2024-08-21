package b_캡슐화;
import java.util.*;
public class CalculatorTest {

	public static void main(String[] args) {
	CalculatorExpr c = new CalculatorExpr();
	Scanner in = new Scanner(System.in);
	System.out.println("숫자를 입력해주세요: ");
	c.setNum1(in.nextInt());
	c.setNum2(in.nextInt());
	
	System.out.println("덧셈: "+ c.getAddtion());
	System.out.println("뺼셈: " + c.getSubtraction());
	System.out.println("곱셈: " + c.getMultplication());
	System.out.println("나누기: " + c.getDivision());
	}

}
