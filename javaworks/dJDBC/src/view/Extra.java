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

public class Extra extends JFrame {
	JButton bRegular, bLarge, bHot, bIce;

	JButton plus, minus;
	JTextField countmenu;
	JButton ok;

	CafeTwosome twosome;

	CoffeeView coffeeView;
// *********************************
// 메뉴금액 받아올 변수를 선언해준다
	int selectPrice;


	// 생성자 함수에 TeaView의 주소를 받아줌
	// TeaView의 주소를 받는 이유 : 메뉴 버튼 눌렀을 때, TeaExtra를 띄워주기 위해
	// CafeTwosome의 주소를 받는 이유 : TeaExtra에서 사이즈와 온도를 눌렀을 때 그 사이즈와 온도를 CafeTwosome
	
// *****************************************************
// selectPrice : TeaView에서 메뉴별 고정된 금액인 selectPrice를 가져온다
	public Extra(CoffeeView coffeeview, CafeTwosome twosome, int selectPrice) {
		super("사이즈 및 온도 선택");
		bRegular = new JButton("R");
		bLarge = new JButton("L");
		bHot = new JButton("Hot");
		bIce = new JButton("Ice");
		plus = new JButton("+");
		countmenu = new JTextField("1");
		minus = new JButton("-");
		ok = new JButton("OK");
		addLayout();
		eventProc();
		this.coffeeView  = coffeeView;
		this.twosome     = twosome;
		// *****************************
		// teaExtra에서 선언한 selectPrice에 TeaView에서 가져온 selectPrice를 넣어준다
		this.selectPrice = selectPrice;

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
		countChoice.add(countmenu);
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
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void eventProc() {

		ButtonEventHandler btnHandler = new ButtonEventHandler();
		bRegular.addActionListener(btnHandler);
		bLarge.addActionListener(btnHandler);
		bHot.addActionListener(btnHandler);
		bIce.addActionListener(btnHandler);
		plus.addActionListener(btnHandler);
		minus.addActionListener(btnHandler);
		ok.addActionListener(btnHandler);

	}
	
	  // TeaView에서 선택한 메뉴 정보를 받는 함수
    public void receiveMenuSelection(String menuName) {
        // TeaView에서 선택한 메뉴 정보를 이용하여 처리
    	
    }

	class ButtonEventHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();

			// 현재 선택된 메뉴의 인덱스를 가져옴
			int selectedIndex = twosome.result.size()-1;
			ArrayList temp = (ArrayList)twosome.result.get(selectedIndex);
			int count =  (int)temp.get(4);
			int price =  (int)temp.get(5);
//			int price = Integer.parseInt((String) temp.get(4));
			
			// TeaView에서 어떤 버튼이 눌렸는지 알 수 있는 코드
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
//				int price = Integer.parseInt((String) temp.get(4));
	            price += 500;
	            
// *************************************************
// 후에 plus minus 할 경우 large 선택된 금액을 해주기 위해 여기서 selectPrice에 500을 더해준다
	            selectPrice += 500;
	            temp.set(5, price);
	            twosome.addResult();

			} 
			else if (o == bHot) {
				temp.set(3, "Hot");
				twosome.addResult();
			} 
			else if (o == bIce) {
				temp.set(3, "ICE");
				twosome.addResult();
			} 
			else if (o == plus) {

	            count++;
	            countmenu.setText(Integer.toString(count));
// **************************************************
// 고정된 금액인 selectPrice를 더해준다	            
                price     = price + selectPrice;
                System.out.println((int) temp.get(5));
                System.out.println(selectPrice);
	            
	            temp.set(4, count);
	            temp.set(5, price);
	            
	            twosome.addResult();
			} 
			else if (o == minus) {
	            
	            if (count > 0) {
	                count--;
	                countmenu.setText(Integer.toString(count));
// **************************************************
// 고정된 금액인 selectPrice를 빼준다
	                price     = price - selectPrice;
	                // list의 가격에 써져있는 값이 아니라 해당 메뉴의 가격 그 자체를 가져와야 함
	                
		            System.out.println((int) temp.get(5));
		            System.out.println(selectPrice);
	                temp.set(4, count);
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
