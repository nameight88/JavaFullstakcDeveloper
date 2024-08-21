import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import view.CoffeeView;
import view.DessertView;
import view.OtherView;
import view.TeaView;


public class CafeTwosome extends JFrame {

	CoffeeView		coffee;
	TeaView			tea;
	OtherView		other;
	DessertView		dessert;

	JLabel			laOrder, laTotal;
	JButton			bTotalPrice, bCancel, bPay;

	JTextField		tfTotal;

	JTextArea		taOrder;


	public CafeTwosome(){
		
		super("투썸플레이스");

		coffee  = new CoffeeView();
		tea		= new TeaView();
		other	= new OtherView();
		dessert	= new DessertView();

		laOrder	= new JLabel("- 주문 정보 -", SwingConstants.CENTER);
		laTotal	= new JLabel("- 총 금액 -", SwingConstants.CENTER);

		bTotalPrice = new JButton("결제금액확인");
		bCancel = new JButton("취소");
		bPay    = new JButton("결제");
		
		tfTotal = new JTextField(30);
		taOrder = new JTextArea(10,20);

		addLayout();
		eventProc();
	}


	void addLayout() {
		
		JTabbedPane pane = new JTabbedPane();
		pane.addTab("커피", coffee);
		pane.addTab("티", tea);
		pane.addTab("그 외 음료", other );
		pane.addTab("케이크", dessert);

		JPanel pOrder = new JPanel();

		pOrder.setLayout(new BorderLayout());
		pOrder.add(laOrder, BorderLayout.NORTH);
		pOrder.add(taOrder, BorderLayout.CENTER);
		pOrder.setPreferredSize(new Dimension(200,245));

		JPanel pTotal = new JPanel();

		pTotal.setLayout(new BorderLayout());
		pTotal.add(laTotal, BorderLayout.NORTH);
		pTotal.add(tfTotal, BorderLayout.CENTER);

		JPanel pPrice = new JPanel();

		pPrice.setLayout(new BorderLayout());
		pPrice.add(pOrder, BorderLayout.NORTH);
		pPrice.add(pTotal, BorderLayout.CENTER);
		pTotal.setPreferredSize(new Dimension(200,80));

		JPanel pSelect = new JPanel();
		pSelect.setLayout(new FlowLayout());
		pSelect.add(bTotalPrice, BorderLayout.NORTH);
		bTotalPrice.setPreferredSize(new Dimension(220,70));
		pSelect.add(bPay, BorderLayout.SOUTH);
		bPay.setPreferredSize(new Dimension(220,70));
		pSelect.add(bCancel, BorderLayout.SOUTH);
		bCancel.setPreferredSize(new Dimension(220,70));

		JPanel pSouth = new JPanel();
		pSouth.setLayout(new BorderLayout());
		pSouth.add(pPrice, BorderLayout.NORTH);
		pSouth.add(pSelect, BorderLayout.CENTER);

		// 화면크기지정
		setLayout(new BorderLayout());
		add(pane, BorderLayout.CENTER);
		add(pSouth, BorderLayout.sOUTH);

		setBounds(300,300,730,965);
		setVisible( true );
		setResizable(false);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );	
	}

	void eventProc() {

		ButtonEventHandler btnHandler = new ButtonEventHandler();

		// 이벤트 등록
		bTotalPrice.addActionListener(btnHandler);
		bCancel.addActionListener(btnHandler);
		bPay.addActionListener(btnHandler);

	}

	class ButtonEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			Object o = ev.getSource();

			if(o==bTotalPrice){  
				// 결제금액확인 선택시 이벤트
			}
			else if(o==bCancel){  
				// 취소버튼 선택시 이벤트
			}			
			else if(o==bPay){  
				// 결제버튼 선택시 이벤트
			}
		}
	}
	public static void main(String[] args) {
		new CafeTwosome();
	}
}

