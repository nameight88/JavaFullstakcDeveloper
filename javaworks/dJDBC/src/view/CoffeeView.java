package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import main.CafeTwosome;
import model.CoffeeModel;

public class CoffeeView extends JPanel{

	//	String[]c_name= {"에스프레소", "아메리카노", "카페라떼", "카페모카", "카푸치노", "카라멜마키아토"};
	//	int[]c_no= {1,2,3,4,5,6};
	//	int[]c_price= {3000, 3000, 4000, 4500, 4500, 5000};


	CoffeeModel model;

	Extra extra;

	JButton		bEs, bAm, bLa, bMc, bcp, bcm; 
	JButton		bTotalPrice, bCancel, bPay;

	CafeTwosome twosome;

	public CoffeeView(CafeTwosome twosome){

		addLayout();
		connectDB();
		eventProc();
		this.twosome=twosome;

	}
	
//	public void connectDB() {
//		try {
//			model = new CoffeeModel();
//			System.out.println("커피 모델 생성 성공");
//		} catch (Exception e) {
//			System.out.println("커피 모델 생성 실패");
//			e.printStackTrace();
//		}
//	} // end of connectDB


	public void eventProc(){
		ButtonEventHandler btnHandler = new ButtonEventHandler();

		// 사진 버튼 누르면 주문메뉴 추가 이벤트 등록
		bEs.addActionListener(btnHandler);
		bAm.addActionListener(btnHandler);
		bLa.addActionListener(btnHandler);
		bMc.addActionListener(btnHandler);
		bcp.addActionListener(btnHandler);
		bcm.addActionListener(btnHandler);


	}

	// 버튼 이벤트 핸들러 만들기
	class ButtonEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			Object o = ev.getSource();

			if(o==bEs){  
				String es = bEs.getText();
				ArrayList temp = new ArrayList();
				temp.add("coffee");
				temp.add(es);
				temp.add("");
				temp.add("");
				temp.add(1);
				temp.add(3000);

				twosome.result.add(temp);
				twosome.addResult();

				int selectPrice=3000;

				new Extra(CoffeeView.this, twosome,selectPrice);

			}
			else if(o==bAm){
				String am = bAm.getText();
				ArrayList temp = new ArrayList();
				temp.add("coffee");
				temp.add(am);
				temp.add("");
				temp.add("");
				temp.add(1);
				temp.add(3000);

				twosome.result.add(temp);
				twosome.addResult();

				int selectPrice=3000;

				new Extra(CoffeeView.this, twosome,selectPrice);

			}			
			else if(o==bLa){  
				String la = bLa.getText();
				ArrayList temp = new ArrayList();
				temp.add("coffee");
				temp.add(la);
				temp.add("");
				temp.add("");
				temp.add(1);
				temp.add(4000);

				twosome.result.add(temp);
				twosome.addResult();

				int selectPrice=4000;

				new Extra(CoffeeView.this, twosome,selectPrice);

			}
			else if(o==bMc){ 
				String mc = bMc.getText();
				ArrayList temp = new ArrayList();
				temp.add("coffee");
				temp.add(mc);
				temp.add("");
				temp.add("");
				temp.add(1);
				temp.add(4000);

				twosome.result.add(temp);
				twosome.addResult();

				int selectPrice=4000;

				new Extra(CoffeeView.this, twosome,selectPrice);

			}
			else if(o==bcp){ 
				String cp = bcp.getText();
				ArrayList temp = new ArrayList();
				temp.add("coffee");
				temp.add(cp);
				temp.add("");
				temp.add("");
				temp.add(1);
				temp.add(4500);

				twosome.result.add(temp);
				twosome.addResult();
				int selectPrice=4500;

				new Extra(CoffeeView.this, twosome,selectPrice);
			}
			else if(o==bcm){ 
				String cm = bcm.getText();
				ArrayList temp = new ArrayList();
				temp.add("coffee");
				temp.add(cm);
				temp.add("");
				temp.add("");
				temp.add(1);
				temp.add(4500);

				twosome.result.add(temp);
				twosome.addResult();
				
				int selectPrice=4500;

				new Extra(CoffeeView.this, twosome,selectPrice);
			}

		}
	}




	public void connectDB(){

		try {

			model = new CoffeeModel();

		}catch(Exception ex) {
			System.out.println("드라이버로딩실패");
			ex.printStackTrace();
		}

	}

	// 커피메뉴 layout
	public void addLayout(){
		//		String[]c_name= {"에스프레소", "아메리카노", "카페라떼", "카페모카", "카푸치노", "카라멜마키아토"};
		//		int[]c_no= {1,2,3,4,5,6};
		//		int[]c_price= {3000, 3000, 4000, 4500, 4500, 5000};



		bEs = new JButton("에스프레소", new ImageIcon("src\\twosome_coffee\\11.png"));
		bAm = new JButton("아메리카노", new ImageIcon("src\\twosome_coffee\\22.png"));
		bLa = new JButton("카페라떼", new ImageIcon("src\\twosome_coffee\\33.png"));
		bMc = new JButton("카페모카", new ImageIcon("src\\twosome_coffee\\44.png"));
		bcp = new JButton("카푸치노", new ImageIcon("src\\twosome_coffee\\55.png"));
		bcm = new JButton("카라멜마키아토", new ImageIcon("src\\twosome_coffee\\66.png"));

		JPanel pNorth = new JPanel();
		
		pNorth.setLayout(new GridLayout(2,3));
		pNorth.add(bEs);
		pNorth.add(bAm);
		pNorth.add(bLa);
		pNorth.add(bMc);
		pNorth.add(bcp);
		pNorth.add(bcm);

		setLayout(new BorderLayout());
		add(pNorth, BorderLayout.NORTH);
		pNorth.setPreferredSize(new Dimension(200,245));
		pNorth.setBorder(new TitledBorder("커피 메뉴"));

		bEs.setVerticalTextPosition(JButton.BOTTOM);
		bEs.setHorizontalTextPosition(JButton.CENTER);

		bAm.setVerticalTextPosition(JButton.BOTTOM);
		bAm.setHorizontalTextPosition(JButton.CENTER);

		bLa.setVerticalTextPosition(JButton.BOTTOM);
		bLa.setHorizontalTextPosition(JButton.CENTER);

		bMc.setVerticalTextPosition(JButton.BOTTOM);
		bMc.setHorizontalTextPosition(JButton.CENTER);

		bcp.setVerticalTextPosition(JButton.BOTTOM);
		bcp.setHorizontalTextPosition(JButton.CENTER);

		bcm.setVerticalTextPosition(JButton.BOTTOM);
		bcm.setHorizontalTextPosition(JButton.CENTER);

		setLayout(new GridLayout(1,1));
		add(pNorth);
		// !!Pane 을 맨위에 선언해놓고 얘를 어디에(전체적으로) 넣을지 안 정함!!


	}
}
