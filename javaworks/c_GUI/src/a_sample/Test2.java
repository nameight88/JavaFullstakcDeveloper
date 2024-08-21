package a_sample;
import java.awt.*;
import javax.swing.*;
/*
 * AWT - > Swing
 *  이름앞에 J
 */
class MyFrame extends JFrame{
	JButton b1;
	JButton c1;
	JLabel l;
//	JCheckBox cb1, cb2;
	JList list; // 여러개를 선택이 가능하다
	JComboBox com;//하나만 선택 가능
	JRadioButton r1, r2;
	TextField tf;
	TextArea ta;
	
	
	MyFrame(){
		b1 = new JButton("OK");
		c1 = new JButton("cancel");
		l = new JLabel("Good Morning");
//		cb1 = new JCheckBox("male");
//		cb2 = new JCheckBox("female");
		String [] data = {"one","two","three","four",};
		list = new JList(data);
		String [] data1 = {"one","two","three","four",};
		com = new JComboBox(data1);
		r1 = new JRadioButton("men");
		r2 = new JRadioButton("girl");
		ButtonGroup bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		tf = new TextField("이름입력: ",30);
		ta = new TextArea(10,50);
		
	}
	void addLayout() {
		//1) FloewLayout - 윗줄 강단 중앙배치(컴포넌트 크기유지)
		setLayout(new BorderLayout()); // 한번만 쓰이기 때문에 선언을 안하고 안에 넣어서 적용우 사라진다.
		//2) GridLayout - 행과 열에 맞춰 배치(컴포넌트 크기 유지X)
		//3) BorderLayout //5개까지만 변수들을 위치 설정을 해줘야한다.
		add(b1);
		add(c1);
		add(l);
		/*
		 * JPanel = new Jpanel();
		 * p.setLayout(new GridLayout(4,3));
		 * p.add(cb1);
		 * p.add(cb2);
		 */
//		add(cb1.BorderLayout.SOUTH);
//		add(cb2.BorderLayout.SOUTH);
		add(list);
		add(com);
	
		add(r1);
		add(r2);
		add(tf);
		add(ta);
		
		setBounds(300,300,700,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}

public class Test2 {

	public static void main(String[] args) {
		MyFrame my = new MyFrame();
		my.addLayout();

	}

}
