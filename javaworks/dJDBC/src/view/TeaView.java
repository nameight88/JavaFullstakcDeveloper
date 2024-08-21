package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import main.CafeTwosome;
import view.Extra;
import model.TeaModel;

public class TeaView extends JPanel{
	
	JButton 		bteaPic1, bteaPic2, bteaPic3, bteaPic4, bteaPic5, bteaPic6;

	JButton			bTotalPrice, bCancel, bPay;
	
	
	TeaModel model;
	
	Extra extra;
	
	CafeTwosome twosome;

	// CafeTwosome의 주소를 받는 이유 : TeaView에서 메뉴를 선택했을 때 선택한 메뉴명을 CafeTwosome의 list에 보내주기 위해
	public TeaView(CafeTwosome twosome) {
		addLayout();
		connectDB();
		//sendMenu();
		eventProc();
		this.twosome = twosome;
	}
	
	public void connectDB() {
		try {
			model = new TeaModel();
			System.out.println("티 모델 생성 성공");
		} catch (Exception e) {
			System.out.println("티 모델 생성 실패");
			e.printStackTrace();
		}
	} // end of connectDB
	
	public void eventProc() {
		ButtonEventHandler btnHandler = new ButtonEventHandler();
		
		// 사진버튼 누르면 주문메뉴 추가
		bteaPic1.addActionListener(btnHandler);
		bteaPic2.addActionListener(btnHandler);
		bteaPic3.addActionListener(btnHandler);
		bteaPic4.addActionListener(btnHandler);
		bteaPic5.addActionListener(btnHandler);
		bteaPic6.addActionListener(btnHandler);
	} // end of eventProc
	
	class ButtonEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent ev) {
			Object o = ev.getSource();
			
			if (o==bteaPic1) {
				ArrayList temp = new ArrayList();
				temp.add("tea");
				temp.add(bteaPic1.getText());
				temp.add("");
				temp.add("");
				temp.add(1);
				temp.add(5100);
				twosome.result.add(temp);
				twosome.addResult();
// ********************************************
// 메뉴별 금액을 selectPrice에 넣어준다				
				int selectPrice = 5100;
// **************************************
// 이 selectPrice를 TeaExtra에 보내준다				
				new TeaExtra(TeaView.this, twosome, selectPrice);
			}
			else if (o==bteaPic2) {
				ArrayList temp = new ArrayList();
				temp.add("tea");
				temp.add(bteaPic2.getText());
				temp.add("");
				temp.add("");
				temp.add(1);
				temp.add(5100);
				twosome.result.add(temp);
				twosome.addResult();
				// ********************************************
				// 메뉴별 금액을 selectPrice에 넣어준다	
				int selectPrice = 5100;
				// **************************************
				// 이 selectPrice를 TeaExtra에 보내준다
				new TeaExtra(TeaView.this, twosome, selectPrice);
			}
			else if (o==bteaPic3) {
				ArrayList temp = new ArrayList();
				temp.add("tea");
				temp.add(bteaPic3.getText());
				temp.add("");
				temp.add("");
				temp.add(1);
				temp.add(5100);
				twosome.result.add(temp);
				twosome.addResult();
				// ********************************************
				// 메뉴별 금액을 selectPrice에 넣어준다	
				int selectPrice = 5100;
				// **************************************
				// 이 selectPrice를 TeaExtra에 보내준다
				new TeaExtra(TeaView.this, twosome, selectPrice);
			}
			else if (o==bteaPic4) {
				ArrayList temp = new ArrayList();
				temp.add("tea");
				temp.add(bteaPic4.getText());
				temp.add("");
				temp.add("");
				temp.add(1);
				temp.add(6100);
				twosome.result.add(temp);
				twosome.addResult();
				// ********************************************
				// 메뉴별 금액을 selectPrice에 넣어준다	
				int selectPrice = 6100;
				// **************************************
				// 이 selectPrice를 TeaExtra에 보내준다
				new TeaExtra(TeaView.this, twosome, selectPrice);
			}
			else if (o==bteaPic5) {
				ArrayList temp = new ArrayList();
				temp.add("tea");
				temp.add(bteaPic5.getText());
				temp.add("");
				temp.add("");
				temp.add(1);
				temp.add(4800);
				twosome.result.add(temp);
				twosome.addResult();
				// ********************************************
				// 메뉴별 금액을 selectPrice에 넣어준다	
				int selectPrice = 4800;
				// **************************************
				// 이 selectPrice를 TeaExtra에 보내준다
				new TeaExtra(TeaView.this, twosome, selectPrice);
			}
			else if (o==bteaPic6) {
				ArrayList temp = new ArrayList();
				temp.add("tea");
				temp.add(bteaPic5.getText());
				temp.add("");
				temp.add("");
				temp.add(1);
				temp.add(6100);
				twosome.result.add(temp);
				twosome.addResult();
				// ********************************************
				// 메뉴별 금액을 selectPrice에 넣어준다	
				int selectPrice = 6100;
				// **************************************
				// 이 selectPrice를 TeaExtra에 보내준다
				new TeaExtra(TeaView.this, twosome, selectPrice);
			}
		}
	} // end of ButtonEventHandler

	// DB에 티 메뉴 생성
	public void sendMenu() {
		try {
			model.insertMenu1();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			model.insertMenu2();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			model.insertMenu3();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			model.insertMenu4();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			model.insertMenu5();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			model.insertMenu6();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// end of sendMenu
	

	
	public void addLayout() {
		// 멤버변수 객체 생성
		
		bteaPic1 = new JButton("TWG 카모마일",new ImageIcon("src\\twosome_tea\\TWG카모마일.jpg"));
		bteaPic2 = new JButton("TWG 크림카라멜",new ImageIcon("src\\twosome_tea\\TWG크림카라멜.jpg"));
		bteaPic3 = new JButton("TWG 프렌치얼그레이",new ImageIcon("src\\twosome_tea\\TWG프렌치얼그레이.jpg"));
		bteaPic4 = new JButton("애플 민트티",new ImageIcon("src\\twosome_tea\\애플민트티.jpg"));
		bteaPic5 = new JButton("제주 유기농 녹차",new ImageIcon("src\\twosome_tea\\제주유기농녹차.jpg"));
		bteaPic6 = new JButton("허니 레몬티",new ImageIcon("src\\twosome_tea\\허니레몬티.jpg"));
		
		// 화면구성
		// 패널 생성
		// 위 : 메뉴
		JPanel pNorth = new JPanel();

		// 위 영역
		pNorth.setLayout(new GridLayout(2,3));
		pNorth.add(bteaPic1);
		pNorth.add(bteaPic2);
		pNorth.add(bteaPic3);
		pNorth.add(bteaPic4);
		pNorth.add(bteaPic5);
		pNorth.add(bteaPic6);
		
		// 위 화면에 붙이기
		setLayout(new BorderLayout());
		add(pNorth, BorderLayout.NORTH);
		pNorth.setPreferredSize(new Dimension(200,245));
		pNorth.setBorder(new TitledBorder("티 메뉴"));
		
		// 티 사진 아래에 가격 붙이기
		bteaPic1.setVerticalTextPosition(JButton.BOTTOM);
		bteaPic1.setHorizontalTextPosition(JButton.CENTER);
		
		bteaPic2.setVerticalTextPosition(JButton.BOTTOM);
		bteaPic2.setHorizontalTextPosition(JButton.CENTER);
		
		bteaPic3.setVerticalTextPosition(JButton.BOTTOM);
		bteaPic3.setHorizontalTextPosition(JButton.CENTER);
		
		bteaPic4.setVerticalTextPosition(JButton.BOTTOM);
		bteaPic4.setHorizontalTextPosition(JButton.CENTER);
		
		bteaPic5.setVerticalTextPosition(JButton.BOTTOM);
		bteaPic5.setHorizontalTextPosition(JButton.CENTER);
		
		bteaPic6.setVerticalTextPosition(JButton.BOTTOM);
		bteaPic6.setHorizontalTextPosition(JButton.CENTER);
		
		
		// 전체화면의 위 아래 붙이기
		setLayout(new GridLayout(1,1));
		
		add(pNorth);


		
	} // end of addLayout

}
