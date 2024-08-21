package main;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;

import dao.OrderDao;
import model.OrderModel;
import view.CoffeeView;
import view.DessertView;
import view.OtherView;
import view.TeaView;
import view.dessertModifyView;
import z_kiosk.MyFrame;
import z_kiosk.ChartB;



public class CafeTwosome extends JFrame {

	CoffeeView		coffee;
	TeaView			tea;
	OtherView		other;
	DessertView		dessert;
	MyFrame chart; 

	JLabel			laOrder, laTotal;
	JButton			bTotalPrice, bCancel, bPay, bmodify;

	
	JTextField		tfTotal;

	MyTableModel 	tm;
	JTable    		table;

	OrderDao		model;
	
	String			temp;
	int				menuprice;
	int				row;
	String			menuname;
	String			category;

	public ArrayList result = new ArrayList();

	public void addResult() {

		tm.data = result;
		tm.fireTableDataChanged();


	}

	void TotalPrice() {
		
		tm.data = result;
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
				System.out.println("result의 각 행의 값\n"+row.get(priceIndex));
				// totalPrice에 가격 값들 더해주기
				totalPrice += (int)row.get(priceIndex);
				
			}
			else {
				System.out.println("유효하지 않은 열 인덱스");
			}
		}
		System.out.println("총합:\n"+totalPrice);
		// tfTotal에 총합 출력
		tfTotal.setText(Integer.toString(totalPrice));
	
	}



	public CafeTwosome(){

		super("투썸플레이스");

		coffee  = new CoffeeView(this);
		tea		= new TeaView(this);
		other	= new OtherView(this);
		dessert	= new DessertView(this);
	

		laOrder	= new JLabel("- 주문 정보 -", SwingConstants.CENTER);
		laTotal	= new JLabel("- 총 금액 -", SwingConstants.CENTER);

		bTotalPrice = new JButton("결제금액확인");
		bCancel = new JButton("취소");
		bPay    = new JButton("결제");
		bmodify = new JButton("수정");

		tfTotal = new JTextField(30);

		tm	= new MyTableModel();
		table = new JTable(tm);
		
		
		addLayout();
		eventProc();
		chart   = new MyFrame();
		
	}


	void addLayout() {

		JTabbedPane pane = new JTabbedPane();
		pane.addTab("커피", coffee);
		pane.addTab("티", tea);
		pane.addTab("그 외 음료", other );
		pane.addTab("케이크", dessert);
		pane.addTab("통계", chart);
		

		JPanel pOrder = new JPanel();
		pOrder.setLayout(new BorderLayout());
		pOrder.add(laOrder, BorderLayout.NORTH);
		pOrder.add(new JScrollPane(table), BorderLayout.CENTER);
		pOrder.setPreferredSize(new Dimension(200,245));

		JPanel pTotal = new JPanel();

		pTotal.setLayout(new BorderLayout());
		pTotal.add(laTotal, BorderLayout.NORTH);
		pTotal.add(tfTotal, BorderLayout.CENTER);
		pTotal.setPreferredSize(new Dimension(200,80));

		JPanel pPrice = new JPanel();

		pPrice.setLayout(new BorderLayout());
		pPrice.add(pOrder, BorderLayout.NORTH);
		pPrice.add(pTotal, BorderLayout.CENTER);

		JPanel pSelect = new JPanel();
		pSelect.setLayout(new FlowLayout());
		pSelect.add(bTotalPrice, BorderLayout.NORTH);
		bTotalPrice.setPreferredSize(new Dimension(160,70));
		pSelect.add(bmodify, BorderLayout.SOUTH);
		bmodify.setPreferredSize(new Dimension(160,70));
		pSelect.add(bPay, BorderLayout.SOUTH);
		bPay.setPreferredSize(new Dimension(160,70));
		pSelect.add(bCancel, BorderLayout.SOUTH);
		bCancel.setPreferredSize(new Dimension(160,70));

		JPanel pSouth = new JPanel();
		pSouth.setLayout(new BorderLayout());
		pSouth.add(pPrice, BorderLayout.NORTH);
		pSouth.add(pSelect, BorderLayout.CENTER);

		// 화면크기지정
		setLayout(new BorderLayout());
		add(pane, BorderLayout.CENTER);
		add(pSouth, BorderLayout.SOUTH);

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
		bmodify.addActionListener(btnHandler);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				row = table.getSelectedRow();
				int col = 0;
				int col2 = 1;
				int col3 = 3;
				temp = (String)table.getValueAt(row, col3);
				category = (String)table.getValueAt(row, col);
				menuname = (String)table.getValueAt(row, col2);
				

					try {
						model = new OrderModel();
						menuprice=model.selectPrice(category, menuname);
					} catch (Exception e1) {
						e1.printStackTrace();
					}



			}
		});
	}

	public class ButtonEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			Object o = ev.getSource();

			if(o==bTotalPrice){
				TotalPrice();
			}
			else if(o==bCancel) {
				clearText();
			}
			else if(o==bPay) {
				new Receipt(CafeTwosome.this, result);
			}
			else if(o==bmodify) {

				if(temp.equals("") || temp == null) {
					dessertModify();
				}else {
					drinkModify();
				}
			}
		}

	}
	
	void dessertModify() {
		new dessertModifyView(this, menuprice, row);
	}
	
	void drinkModify(){
		JOptionPane.showMessageDialog(null, "전체취소하고 다시 선택하세요");
	}
	

	void clearText() {
		tfTotal.setText(null);
		result.clear();
	    tm.fireTableDataChanged();
	}


	public class MyTableModel extends AbstractTableModel{

		ArrayList data = new ArrayList();	// 테이블에 출력할 데이타
		String [] columnNames = {"카테고리","메뉴","사이즈","온도","개수","가격"};// 컬럼명

		public int getRowCount() {			
			return data.size();
		}
		public int getColumnCount() {			
			return columnNames.length;
		}
		public Object getValueAt(int rowIndex, int columnIndex) {
			ArrayList temp = (ArrayList)data.get(rowIndex);			
			if (temp.size()>columnIndex) {
				return temp.get(columnIndex);
			}return null;
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

	}
	public static void main(String[] args) {
		new CafeTwosome();
	}
}

