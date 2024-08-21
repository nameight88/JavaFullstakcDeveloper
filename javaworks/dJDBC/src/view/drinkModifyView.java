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

public class drinkModifyView extends JFrame {
	JButton bRegular, bLarge, bHot, bIce;

	JButton plus, minus;
	JTextField count;
	JButton ok;

	CafeTwosome twosome;
	
    int menuprice;
    int row;
	


	// 생성자 함수에 TeaView의 주소를 받아줌
	// TeaView의 주소를 받는 이유 : 메뉴 버튼 눌렀을 때, TeaExtra를 띄워주기 위해
	// CafeTwosome의 주소를 받는 이유 : TeaExtra에서 사이즈와 온도를 눌렀을 때 그 사이즈와 온도를 CafeTwosome의
	// list에 넣어주기 위해서
	public drinkModifyView(CafeTwosome twosome, int menuprice, int row) {
		super("수정");

		bIce = new JButton("ICE");
		bHot = new JButton("HOT");
		bRegular = new JButton("R");
		bLarge = new JButton("L");
		plus = new JButton("+");
		count = new JTextField(1);
		minus = new JButton("-");
		ok = new JButton("OK");
		addLayout();
		eventProc();
		
		this.twosome = twosome;
		this.menuprice = menuprice;
		this.row = row;
		


	}

	void addLayout() {

		
		// 사이즈
		JPanel size = new JPanel();

		size.setLayout(new GridLayout(1, 3));
		size.add(new Label("Size Select"));
		size.add(bRegular);
		size.add(bLarge);

		// 온도
		JPanel ondo = new JPanel();

		ondo.setLayout(new GridLayout(1, 3));
		ondo.add(new Label("Temperature Select"));
		ondo.add(bHot);
		ondo.add(bIce);

		JPanel countChoice = new JPanel();
		countChoice.setLayout(new GridLayout(1, 4));

		countChoice.add(new Label("Count"));
		countChoice.add(minus);
		countChoice.add(count);
		countChoice.add(plus);

		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4, 1));
		p.add(size);
		p.add(ondo);
		p.add(countChoice);

		p.add(ok);

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(p, BorderLayout.CENTER);

		setBounds(300, 300, 730, 600);
		
		setVisible(true);
		//			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void eventProc() {

		ButtonEventHandler btnHandler = new ButtonEventHandler();
		
		bIce.addActionListener(btnHandler);
		bHot.addActionListener(btnHandler);
		bRegular.addActionListener(btnHandler);
		bLarge.addActionListener(btnHandler);
		plus.addActionListener(btnHandler);
		minus.addActionListener(btnHandler);
		ok.addActionListener(btnHandler);

	}

	class ButtonEventHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			
			int selectrow = row;
			ArrayList temp = (ArrayList) twosome.result.get(selectrow);
			int price = (Integer)temp.get(5);
			int countmenu = Integer.parseInt((String) temp.get(4));

			if(o == bIce) {
				
				temp.set(3, "ICE");
				twosome.addResult();
				
			}else if (o == bHot) {
			
				
				temp.set(3, "Hot");
				twosome.addResult();
			}else if (o==bRegular) {
				// 사이즈 정보 수정
				temp.set(2, "R");
				// 리스트에 수정된 정보 저장
				
				temp.set(4, 1);
				temp.set(5, menuprice);
				
				twosome.addResult();
			}
			else if (o==bLarge) {
				
				temp.set(2, "L");
				// 가격 정보 수정
				// temp.get(4) : ArrayList의 인덱스 4의 요소 가져옴(가격)
				// String.valueOf() : 가격을 문자열로 변환
//				int price = Integer.parseInt((String) temp.get(4));
	            price += 500;
	            
	            menuprice += 500;
	            temp.set(5, price);
	            twosome.addResult();
	            
			}
			else if (o == plus) {
				
				
				countmenu += 1;
				price = menuprice * countmenu;
				count.setText(Integer.toString(countmenu));

				temp.set(4, String.valueOf(countmenu));
				temp.set(5, price);

				twosome.addResult();
			} 
			else if (o == minus) {
				
				if (countmenu>0) {
				countmenu -= 1;
				price = menuprice * countmenu;
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



