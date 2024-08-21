package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.CafeTwosome;

public class OtherExtra extends JFrame{

	JButton bRegular, bLarge, bHot, bIce;

	JButton plus, minus;
	JTextField countmenu;
	JButton ok;

	CafeTwosome twosome;

	OtherView otherview;

	int selectprice;


	public OtherExtra(OtherView otherView, CafeTwosome twosome,int selectPirce) {
		super("사이즈 및 온도 선택");
		bRegular = new JButton("R");
		bLarge = new JButton("L");
		plus = new JButton("+");
		countmenu = new JTextField("1");
		minus = new JButton("-");
		ok = new JButton("OK");
		addLayout();
		eventProc();
		this.twosome = twosome;
		this.otherview = otherview;
		this.selectprice =selectPirce;



	}

	void addLayout() {

		// 사이즈
		JPanel size = new JPanel();

		size.setLayout(new GridLayout(1, 3));
		size.add(new Label("Size Select"));
		size.add(bRegular);
		size.add(bLarge);


		JPanel countChoice = new JPanel();
		countChoice.setLayout(new GridLayout(1, 4));

		countChoice.add(new Label("Count"));
		countChoice.add(minus);
		countChoice.add(countmenu);
		countChoice.add(plus);

		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3, 1));
		p.add(size);
		p.add(countChoice);

		p.add(ok);

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(p, BorderLayout.CENTER);

		setBounds(300, 300, 730, 600);
		setVisible(true);
		//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void eventProc() {

		ButtonEventHandler btnHandler = new ButtonEventHandler();
		bRegular.addActionListener(btnHandler);
		bLarge.addActionListener(btnHandler);
		plus.addActionListener(btnHandler);
		minus.addActionListener(btnHandler);
		ok.addActionListener(btnHandler);

	}
	public void receiveMenuSelection(String menuName) {

	}
	class ButtonEventHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();

			// 현재 선택된 메뉴의 인덱스를 가져옴
			int selectedIndex = twosome.result.size()-1;
			ArrayList temp = (ArrayList)twosome.result.get(selectedIndex);
			int count = (int)temp.get(4);
			int price = (int)temp.get(5);


			if (o == bRegular) {

				// 사이즈 정보 수정
				temp.set(2, "R");
				// 리스트에 수정된 정보 저장
				twosome.addResult();


			} 
			else if (o == bLarge) {
				temp.set(2, "L");
				// 가격 정보 수정
				// temp.get(4) : ArrayList의 인덱스 4의 요소 가져옴(가격)
				// String.valueOf() : 가격을 문자열로 변환
				// replace(",","") : 문자열에서 모든 쉼표를 제거. 가격이 
				price += 500;
				selectprice += 500;
				temp.set(5, price);
				twosome.addResult();

			} 
			else if (o == plus) {

				count++;
				countmenu.setText(Integer.toString(count));

				price = price + selectprice;
				System.out.println((int) temp.get(5));
				System.out.println(selectprice);

				temp.set(4, count);
				temp.set(5, price);

				twosome.addResult();

			} 
			else if (o == minus) {
				if ( count > 0 ) {
					count--;
					countmenu.setText(Integer.toString(count));
					price = price - selectprice;

					temp.set(4,count);
					temp.set(5, price);
				}
				twosome.addResult();

			} 
			else if (o == ok) {
				setVisible(false);


			}


		}

	}
}
