package view;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;

import main.CafeTwosome;
import view.OtherExtra;
import dao.OtherDao;
import model.OrderModel;

public class OtherView extends JPanel{
	OrderModel model;
	OtherDao dao;
	JButton b_other1
		, b_other2 
		, b_other3 
		, b_other4
		, b_other5
		, b_other6
		, bAdd
		, totalPtice
		, Cancel
		, Pay;
	//음료 버튼들 1 = 스피치, 2= 스초프, 3= 오렌지자몽주스, 4= 키위바나나주스,5=자몽에이드 ,6=청포도에이드
	
	JPanel p_o;
	
	JTabbedPane otherPane;
	
//	CheckboxGroup group = new CheckboxGroup();
//	Checkbox b_sr, b_sl, b_sm,b_h,b_i; // 음료 옵션들을 고를 체크 박스
	CafeTwosome twosome;
	
	OtherExtra extra;
	

	public OtherView(CafeTwosome twosome) {
		this.twosome = twosome;
		addLayout();
		connectDB();
		eventProc();
	}
	
	public void eventProc() {
		//음료 버튼을 눌렀을때
		ButtonEventHandler bt = new ButtonEventHandler();
		
		b_other1.addActionListener(bt);
		b_other2.addActionListener(bt);
		b_other3.addActionListener(bt);
		b_other4.addActionListener(bt);
		b_other5.addActionListener(bt);
		b_other6.addActionListener(bt);
		
		
	}
	class ButtonEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent ev) {
			Object o = ev.getSource();
			
			if (o ==b_other1 ) {
				ArrayList temp = new ArrayList();
				temp.add("other");
				temp.add(b_other1.getText());
				temp.add("");
				temp.add("ICE");
				temp.add(1);
				temp.add(6100);
				twosome.result.add(temp);
				twosome.addResult();
				int selectPirce = 5100;
				new OtherExtra(OtherView.this, twosome, selectPirce);
				
			}else if (o ==b_other2) {
				ArrayList temp = new ArrayList();
				temp.add("other");
				temp.add(b_other2.getText());
				temp.add("");
				temp.add("ICE");
				temp.add(1);
				temp.add(6100);
				twosome.result.add(temp);
				twosome.addResult();
				int selectPirce = 6100;
				new OtherExtra(OtherView.this, twosome,selectPirce);
			}else if (o ==b_other3) {
				ArrayList temp = new ArrayList();
				temp.add("other");
				temp.add(b_other3.getText());
				temp.add("");
				temp.add("ICE");
				temp.add(1);
				temp.add(6300);
				twosome.result.add(temp);
				twosome.addResult();
				int selectPirce = 6300;
				new OtherExtra(OtherView.this, twosome,selectPirce);
			}else if (o ==b_other4) {
				ArrayList temp = new ArrayList();
				temp.add("other");
				temp.add(b_other4.getText());
				temp.add("");
				temp.add("ICE");
				temp.add(1);
				temp.add(5800);
				twosome.result.add(temp);
				twosome.addResult();
				int selectPirce = 5800;
				new OtherExtra(OtherView.this, twosome,selectPirce);
			}else if (o == b_other5) {
				ArrayList temp = new ArrayList();
				temp.add("other");
				temp.add(b_other5.getText());
				temp.add("");
				temp.add("ICE");
				temp.add(1);
				temp.add(5800);
				twosome.result.add(temp);
				twosome.addResult();
				int selectPirce = 5800;
				new OtherExtra(OtherView.this, twosome,selectPirce);
			}else if (o == b_other6) {
				ArrayList temp = new ArrayList();
				temp.add("other");
				temp.add(b_other6.getText());
				temp.add("");
				temp.add("ICE");
				temp.add(1);
				temp.add(6300);
				twosome.result.add(temp);
				twosome.addResult();
				int selectPirce = 6300;
				new OtherExtra(OtherView.this, twosome,selectPirce);
			}
		}
	}

	
	public void connectDB() {
		try{
			model = new OrderModel();
		}catch(Exception ex) {
			System.out.println("드라이버 로딩실패: "+ex.getMessage());
			ex.printStackTrace();
		}
	}
	public void addLayout(){
	    
//	    group = new CheckboxGroup();
	    
	    // 음료 버튼들을 포함할 패널 설정

	    // 음료 버튼들 생성 및 이름 설정
	    b_other1 = new JButton("스트로피치프라페", new ImageIcon("src\\twosome_other\\1.png"));
	    b_other2 = new JButton("스초생프라페", new ImageIcon("src\\twosome_other\\2.jpg"));
	    b_other3 = new JButton("오렌지자몽주스", new ImageIcon("src\\twosome_other\\3.png"));
	    b_other4 = new JButton("키위바나나주스", new ImageIcon("src\\twosome_other\\4.png"));
	    b_other5 = new JButton("자몽에이드", new ImageIcon("src\\twosome_other\\5.png"));
	    b_other6 = new JButton("청포도에이드", new ImageIcon("src\\twosome_other\\6.jpg"));

	    JPanel p_o = new JPanel();
	    p_o.setLayout(new GridLayout(2, 3));
	    
	    // 음료 버튼들을 패널에 추가
	    p_o.add(b_other1);
	    p_o.add(b_other2);
	    p_o.add(b_other3);
	    p_o.add(b_other4);
	    p_o.add(b_other5);
	    p_o.add(b_other6);
	    
	    setLayout(new BorderLayout());
		add(p_o, BorderLayout.NORTH);
		p_o.setPreferredSize(new Dimension(200,245));
		p_o.setBorder(new TitledBorder("음료 메뉴"));
	   
	    
	    //버튼의 위치 설정
	    b_other1.setVerticalTextPosition(JButton.BOTTOM);
	    b_other1.setHorizontalTextPosition(JButton.CENTER);

	    b_other2.setVerticalTextPosition(JButton.BOTTOM);
	    b_other2.setHorizontalTextPosition(JButton.CENTER);
	    
	    b_other3.setVerticalTextPosition(JButton.BOTTOM);
	    b_other3.setHorizontalTextPosition(JButton.CENTER);
	    
	    b_other4.setVerticalTextPosition(JButton.BOTTOM);
	    b_other4.setHorizontalTextPosition(JButton.CENTER);
	    
	    b_other5.setVerticalTextPosition(JButton.BOTTOM);
	    b_other5.setHorizontalTextPosition(JButton.CENTER);
	    
	    b_other6.setVerticalTextPosition(JButton.BOTTOM);
	    b_other6.setHorizontalTextPosition(JButton.CENTER);

	    // 프레임에 패널들을 추가
	    setLayout(new GridLayout(1,1));
		
		add(p_o);

	}
	
}
