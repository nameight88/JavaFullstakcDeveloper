package c_event;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyScreen{

	JFrame f;
	JButton b1;
	JButton c1;


	MyScreen(){
		f = new JFrame("나의 창");
		b1 = new JButton("OK");
		c1 = new JButton("cancel");
	}	
	void addLayOut() {
		f.setLayout(new FlowLayout()); // 한번만 쓰이기 때문에 선언을 안하고 안에 넣어서 적용우 사라진다.
		f.add(b1);
		f.add(c1);

		f.setBounds(300,300,700,500);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}//end of addLayout

	void eventPro() {
		//[2]이벤트 핸들러 객체생성
		MyHandle hdlr = new MyHandle();

		//[3] 이벤트 컴포넌트와 이벤트 객체를 등록(연결)
		b1.addActionListener(hdlr);
		//이벤트 처리



	}//end of eventPro

	//[1] 이벤트 핸들러 : 이벤트처리하는 클래스

	class MyHandle implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "버튼을 눌렀습니다.");
		}
	}

}//end of class MyScreen
public class Test {

	public static void main(String[] args) {

		MyScreen my = new MyScreen();
		my.addLayOut();
		my.eventPro();
	}

}
