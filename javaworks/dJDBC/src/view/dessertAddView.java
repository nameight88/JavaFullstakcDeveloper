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

public class dessertAddView extends JFrame {


	JButton plus, minus;
	JTextField count;
	JButton ok;
    int selectPrice;
	
	CafeTwosome twosome;

	DessertView dessertview;

	// 생성자 함수에 TeaView의 주소를 받아줌
	// TeaView의 주소를 받는 이유 : 메뉴 버튼 눌렀을 때, TeaExtra를 띄워주기 위해
	// CafeTwosome의 주소를 받는 이유 : TeaExtra에서 사이즈와 온도를 눌렀을 때 그 사이즈와 온도를 CafeTwosome의
	// list에 넣어주기 위해서
	public dessertAddView(DessertView dessertview, CafeTwosome twosome, int selectPrice) {
		super("개수 선택");

		plus = new JButton("+");
		count = new JTextField("1");
		minus = new JButton("-");
		ok = new JButton("OK");
		addLayout();
		eventProc();
		this.dessertview = dessertview;
		this.twosome = twosome;
		this.selectPrice = selectPrice;
		

	}

	void addLayout() {

		JPanel countChoice = new JPanel();
		countChoice.setLayout(new GridLayout(1, 4));

		countChoice.add(new Label("Count"));
		countChoice.add(minus);
		countChoice.add(count);
		countChoice.add(plus);

		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2, 1));
		p.add(countChoice);
		p.add(ok);

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(p, BorderLayout.CENTER);

		setBounds(300, 300, 200, 150);
		setVisible(true);
	}

	void eventProc() {

		ButtonEventHandler btnHandler = new ButtonEventHandler();
		plus.addActionListener(btnHandler);
		minus.addActionListener(btnHandler);
		ok.addActionListener(btnHandler);

	}

	class ButtonEventHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();

			
			if (o == plus) {
				
				int selectedIndex = twosome.result.size()-1;
				ArrayList temp = (ArrayList) twosome.result.get(selectedIndex);
				int countmenu = Integer.parseInt((String) temp.get(4));
				int price = (Integer)temp.get(5);
				
				countmenu += 1;
				price = selectPrice * countmenu;
				count.setText(Integer.toString(countmenu));

				temp.set(4, String.valueOf(countmenu));
				temp.set(5, price);

				twosome.addResult();
			} 
			else if (o == minus) {
				
				int selectedIndex = twosome.result.size()-1;
				ArrayList temp = (ArrayList) twosome.result.get(selectedIndex);
				int countmenu = Integer.parseInt((String) temp.get(4));
				int price = (Integer)temp.get(5);

				if (countmenu > 0) {
					countmenu-=1;
					price = selectPrice * countmenu;
					count.setText(Integer.toString(countmenu));
					
					temp.set(4, String.valueOf(countmenu));
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



