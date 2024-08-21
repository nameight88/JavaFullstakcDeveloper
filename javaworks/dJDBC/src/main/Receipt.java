package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Receipt extends JFrame{
	
	JButton bOk;
	JTextField  tftotal;
	JTextArea  tfrc;
	CafeTwosome twosome;
	
	ArrayList result = new ArrayList();
	
	public Receipt(CafeTwosome twosome, ArrayList result) {
		super("영수증");
		
		bOk = new JButton("OK");
		tftotal = new JTextField();
		tfrc = new JTextArea();
		
		this.twosome = twosome;
		this.result  = result;
		System.out.println("result:");
		System.out.println(result);
		
		// 텍스트필드에 result 출력
		selectAll();
		// 텍스트필드에 총합 출력
		TotalPrice();
		addLayout();
		eventProc();
	}

	void selectAll() {
		StringBuilder sb = new StringBuilder();

		for (Object row : result) {
			sb.append(row.toString()).append(" \n ");
		}
		String text = sb.toString();

		tfrc.setText(text);
	}
	
	void TotalPrice() {
		
		System.out.println("result의 모든 행의 값\n"+result);
	
		// 가격이 들어있는 인덱스
		int priceIndex = 5;
		int totalPrice = 0;
		
		// result의 내부 리스트를 반복하면서 순회중인 내부 리스트 : row 
		// row를 통해 result의 내부에 접근
		for(Object innerList : result) {
			ArrayList row = (ArrayList) innerList;
			// 열 인덱스가 유효한지 확인하고 값 출력
			if (priceIndex>=0 && priceIndex <row.size()) {
				// totalPrice에 가격 값들 더해주기
				totalPrice += (int)row.get(priceIndex);
			}
			else {
				System.out.println("유효하지 않은 열 인덱스");
			}
		}
		System.out.println("총합:\n"+totalPrice);
		// tfTotal에 총합 출력
		tftotal.setText(Integer.toString(totalPrice));
	}
	void addLayout() {
		
		JPanel t = new JPanel();
		t.setLayout(new BorderLayout());
		t.setBorder(new TitledBorder("주문내역"));
		t.add(tfrc, BorderLayout.CENTER);

		JPanel c = new JPanel();
		c.setLayout(new BorderLayout());
		c.setBorder(new TitledBorder("총합"));
		c.add(tftotal, BorderLayout.CENTER);
		
		add(t, BorderLayout.CENTER);
		add(c, BorderLayout.NORTH);
		add(bOk, BorderLayout.SOUTH);
		setBounds(300, 300, 300, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void eventProc() {
		bOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// OK 버튼 누르면 창 끄기
				setVisible(false);
			}
		});
	}
}
