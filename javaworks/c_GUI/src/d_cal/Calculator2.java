package d_cal;
import java.awt.*;
import javax.swing.*;


public class Calculator2 extends JFrame{
	//1.맴버변수선언
	JFrame f;
	JButton bAdd, bSub, bDiv, bMul, bEqual;
	JButton [] b = new JButton[10];

	//2.객체생성
	Calculator2(){
		f = new JFrame("유치원계산기");

		bAdd = new JButton("+");
		bAdd = new JButton("-");
		bAdd = new JButton("*");
		bAdd = new JButton("/");
		bAdd = new JButton("=");

		for(int i = 0; i<b.length; i+=1) {
			b[i] = new JButton(String.valueOf(i));
		}
	}
	//3.화면 붙이기
	void addLayout() {
		
	}
	//4.이벤트처리
	void eventProc() {

	}
	public static void main(String[] args) {
		Calculator2 c = new Calculator2();
		c.addLayout();
		c.eventProc();
	}

}
