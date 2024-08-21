package e_tabpane;
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MyScreen extends JFrame {
	PanelA a;
	PanelB b;
	PanelC c;
	
	ArrayList result = new ArrayList();
	
	public void addRsult() {
		//데이터 확인만
//		for ( int i = 0 ; i<3; i+=1) {
//			ArrayList temp = new ArrayList();
//			temp.add("메뉴"+i);
//			temp.add(1000*(i+1));
//			result.add(temp);
		
		
		// PanelA에 있는 화면 JTable(view)/테이블 모델에 값을 지정 
		a.tm.data = result;
		a.tm.fireTableDataChanged();
	}
	
	MyScreen(){
		a = new PanelA();
		b = new PanelB(this); // this:MyScreen 객체주소
		c = new PanelC();
		
		JTabbedPane pane = new JTabbedPane();
		pane.addTab("고객관리", a);
		pane.addTab("비디오관리", b);
		pane.addTab("대여관리", c);
		
		
		//JFrame 기본 layout 속성 : BorderLayout
		// north, shouth, center, west ,east 영역
		// stendard : center
		add(pane, BorderLayout.CENTER);
//		add(a);
//		add(b);
//		add(c);
		pane.setSelectedIndex(2);
		
		setBounds(200,200,500,400);
		setVisible(true);
		
		//addResult();
		
	}
	public static void main(String[] args) {
		
			MyScreen ms = new MyScreen();
	}

}
