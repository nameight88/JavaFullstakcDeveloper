package a_sample;

import java.awt.*;
import javax.swing.*;
/*
 * oop 문법의 활용을 위해 GUI(화면)만들기
 * 
 * 자바 UI
 */
class MyScreen{
	//1.맴버 변수선언
	Frame f;
	JButton b1;
	JButton c1;
	JLabel l;
	JList list;
	JComboBox com;
	JCheckBox cb1,cb2;
	
	//2.객체 생성
	MyScreen(){
		f = new Frame("나의 창");
		b1 = new JButton("OK");
		c1 = new JButton("cancel");
		l = new JLabel("Good Morning");
		String [] data1 = {"one","two","three"};
		list = new JList(data1);
		String [] data2 = {"one"};
		com = new JComboBox();
		cb1 = new JCheckBox("male");
		cb2 = new JCheckBox("female");
	
	
	}
	
	
	//3.화면 붙이기
	//4.화면 띄우기
	void addLayOut() {
		f.setLayout(new FlowLayout()); // 한번만 쓰이기 때문에 선언을 안하고 안에 넣어서 적용우 사라진다.
		f.add(b1);
		f.add(c1);
		f.add(l);
		f.add(com);
		f.add(list);
		f.add(cb1);
		f.add(cb2);
		
		
		f.setBounds(300,300,700,500);
		f.setVisible(true);
	}
}
public class Test {

	public static void main(String[] args) {
		
		MyScreen my = new MyScreen();
		my.addLayOut();
	}

}
