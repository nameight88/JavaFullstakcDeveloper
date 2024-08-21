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
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;

import main.CafeTwosome;
import model.DessertModel;
import vo.Dessert;

public class DessertView extends JPanel{

	DessertModel model;

	JButton		 b_wcg, b_wgcm, b_wnyc, b_wscc, b_wt, b_wcc;	//홀케이크 종류 선택버튼

	JButton      b_pcg, b_pgcm, b_pnyc, b_pscc, b_pt, b_pcc;	//케이크 종류 선택버튼


	JPanel		 b_w, b_p;

	JTabbedPane tabbedPane;
	
	CafeTwosome twosome;


	public DessertView(CafeTwosome twosome){

		addLayout();
		connectDB();
		eventProc();
		this.twosome = twosome;
	}


	public void eventProc(){
		ButtonEventHandler btnHandler = new ButtonEventHandler();

		// 이벤트 등록
		b_wcg.addActionListener(btnHandler);
		b_wgcm.addActionListener(btnHandler);
		b_wnyc.addActionListener(btnHandler);
		b_wscc.addActionListener(btnHandler);
		b_wt.addActionListener(btnHandler);
		b_wcc.addActionListener(btnHandler);
		b_pcg.addActionListener(btnHandler);
		b_pgcm.addActionListener(btnHandler);
		b_pnyc.addActionListener(btnHandler);
		b_pscc.addActionListener(btnHandler);
		b_pt.addActionListener(btnHandler);
		b_pcc.addActionListener(btnHandler);

	}

	// 버튼 이벤트 핸들러 만들기
	class ButtonEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			Object o = ev.getSource();

			if(o==b_wcg){  
				// 갸또쇼콜라 홀케이크 선택시 이벤트

				String wcg = "홀"+b_wcg.getText();
				
				ArrayList temp = new ArrayList();
				temp.add("dessert");
				temp.add(wcg);
				temp.add("");
				temp.add("");
				temp.add("1");
				temp.add(37000);
				
				twosome.result.add(temp);
				twosome.addResult();
				
				int selectPrice = 37000;
				
				new dessertAddView(DessertView.this, twosome, selectPrice);
			}
			else if(o==b_wgcm){  
				// 그뤼에르 치즈무스 홀케이크 선택시 이벤트
				
				String wgcm = "홀"+b_wgcm.getText();
				
				ArrayList temp = new ArrayList();
				temp.add("dessert");
				temp.add(wgcm);
				temp.add("");
				temp.add("");
				temp.add("1");
				temp.add(37000);
				
				twosome.result.add(temp);
				twosome.addResult();

				int selectPrice = 37000;
				
				new dessertAddView(DessertView.this, twosome, selectPrice);
			}			
			else if(o==b_wnyc){  
				// 뉴욕치즈케이크 홀케이크 선택시 이벤트
				
				String wnyc = "홀"+b_wnyc.getText();
				
				ArrayList temp = new ArrayList();
				temp.add("dessert");
				temp.add(wnyc);
				temp.add("");
				temp.add("");
				temp.add("1");
				temp.add(37000);
				
				twosome.result.add(temp);
				twosome.addResult();

				int selectPrice = 37000;
				
				new dessertAddView(DessertView.this, twosome, selectPrice);
			}
			else if(o==b_wscc){ 
				// 스트로베리초코생크림 홀케이크 선택시 이벤트
				
				String wscc = "홀"+b_wscc.getText();
				
				ArrayList temp = new ArrayList();
				temp.add("dessert");
				temp.add(wscc);
				temp.add("");
				temp.add("");
				temp.add("1");
				temp.add(37000);
				
				twosome.result.add(temp);
				twosome.addResult();

				int selectPrice = 37000;
				
				new dessertAddView(DessertView.this, twosome, selectPrice);
			}
			else if(o==b_wt){ 
				// 마스카포네 티라미수 홀케이크 선택시 이벤트
				
				String wt = "홀"+b_wt.getText();
				
				ArrayList temp = new ArrayList();
				temp.add("dessert");
				temp.add(wt);
				temp.add("");
				temp.add("");
				temp.add("1");
				temp.add(37000);
				
				twosome.result.add(temp);
				twosome.addResult();

				int selectPrice = 37000;
				
				new dessertAddView(DessertView.this, twosome, selectPrice);

			}
			else if(o==b_wcc){ 
				// 퀸즈캐롯 홀케이크 선택시 이벤트
				
				String wcc = "홀"+b_wcc.getText();
				
				ArrayList temp = new ArrayList();
				temp.add("dessert");
				temp.add(wcc);
				temp.add("");
				temp.add("");
				temp.add("1");
				temp.add(36000);
				
				twosome.result.add(temp);
				twosome.addResult();

				int selectPrice = 36000;
				
				new dessertAddView(DessertView.this, twosome, selectPrice);
			} 
			else if (o == b_pcg) {
				// 클래식갸또쇼콜라 조각케이크 선택시 이벤트
				
				String pcg = "조각"+b_pcg.getText();
				
				ArrayList temp = new ArrayList();
				temp.add("dessert");
				temp.add(pcg);
				temp.add("");
				temp.add("");
				temp.add("1");
				temp.add(6500);
				
				twosome.result.add(temp);
				twosome.addResult();

				int selectPrice = 6500;
				
				new dessertAddView(DessertView.this, twosome, selectPrice);
			} 
			else if (o == b_pgcm) {
				// 그뤼에르치즈무스 조각케이크 선택시 이벤트
				
				String pgcm = "조각"+b_pgcm.getText();
				
				ArrayList temp = new ArrayList();
				temp.add("dessert");
				temp.add(pgcm);
				temp.add("");
				temp.add("");
				temp.add("1");
				temp.add(6200);
				
				twosome.result.add(temp);
				twosome.addResult();

				int selectPrice = 6200;
				
				new dessertAddView(DessertView.this, twosome, selectPrice);
			} 
			else if (o == b_pnyc) {
				// 뉴욕치즈케이크 조각케이크 선택시 이벤트
				
				String pnyc = "조각"+b_pnyc.getText();
				ArrayList temp = new ArrayList();
				temp.add("dessert");
				temp.add(pnyc);
				temp.add("");
				temp.add("");
				temp.add("1");
				temp.add(5900);
				
				twosome.result.add(temp);
				twosome.addResult();

				int selectPrice = 5900;
				
				new dessertAddView(DessertView.this, twosome, selectPrice);
			} 
			else if (o == b_pscc) {
				// 스트로베리초코생크림 조각케이크 선택시 이벤트
				
				String pscc = "조각"+b_pscc.getText();
				ArrayList temp = new ArrayList();
				temp.add("dessert");
				temp.add(pscc);
				temp.add("");
				temp.add("");
				temp.add("1");
				temp.add(6700);
				
				twosome.result.add(temp);
				twosome.addResult();
	
				int selectPrice = 6700;
				
				new dessertAddView(DessertView.this, twosome, selectPrice);
			} 
			else if (o == b_pt) {
				// 마스카포네 티라미수 조각케이크 선택시 이벤트
				
				String pt = "조각"+b_pt.getText();
				ArrayList temp = new ArrayList();
				temp.add("dessert");
				temp.add("");
				temp.add("");
				temp.add("");
				temp.add("");
				temp.add("1");
				temp.add(6500);
				
				twosome.result.add(temp);
				twosome.addResult();

				int selectPrice = 6500;
				
				new dessertAddView(DessertView.this, twosome, selectPrice);
			} 
			else if (o == b_pcc) {
				// 퀸즈캐롯 조각케이크 선택시 이벤트
				
				String pcc = "조각"+b_pcc.getText();
				ArrayList temp = new ArrayList();
				temp.add("dessert");
				temp.add(pcc);
				temp.add("");
				temp.add("");
				temp.add("1");
				temp.add(6500);
				
				twosome.result.add(temp);
				twosome.addResult();
				
				int selectPrice = 6500;
				
				new dessertAddView(DessertView.this, twosome, selectPrice);
			}
		}

	}
	

	public void connectDB(){

		try {

			model = new DessertModel();

		}catch(Exception ex) {
			System.out.println("드라이버 로딩 실패");
			ex.printStackTrace();
		}

	}

	public void addLayout(){

		//홀케이크 탭
		
		b_w = new JPanel();
		b_w.setLayout(new GridLayout(2,3));

		b_wcg = new JButton("클래식갸또쇼콜라", new ImageIcon("src\\twosome_dessert\\w_cg.jpg"));
		b_wgcm = new JButton("그뤼에르치즈무스", new ImageIcon("src\\twosome_dessert\\w_gcm.jpg"));
		b_wnyc = new JButton("뉴욕치즈케이크", new ImageIcon("src\\twosome_dessert\\w_nyc.jpg"));
		b_wscc = new JButton("스트로베리초코생크림", new ImageIcon("src\\twosome_dessert\\w_gcm.jpg"));
		b_wt = new JButton("마스카포네티라미수", new ImageIcon("src\\twosome_dessert\\w_t.jpg"));
		b_wcc = new JButton("퀸즈캐롯", new ImageIcon("src\\twosome_dessert\\w_cc.jpg"));

		b_w.add(b_wcg);
		b_w.add(b_wgcm);
		b_w.add(b_wnyc);
		b_w.add(b_wscc);
		b_w.add(b_wt);
		b_w.add(b_wcc);
		
		b_wcg.setVerticalTextPosition(JButton.BOTTOM);
		b_wcg.setHorizontalTextPosition(JButton.CENTER);
		
		b_wgcm.setVerticalTextPosition(JButton.BOTTOM);
		b_wgcm.setHorizontalTextPosition(JButton.CENTER);
		
		b_wnyc.setVerticalTextPosition(JButton.BOTTOM);
		b_wnyc.setHorizontalTextPosition(JButton.CENTER);
		
		b_wscc.setVerticalTextPosition(JButton.BOTTOM);
		b_wscc.setHorizontalTextPosition(JButton.CENTER);
		
		b_wt.setVerticalTextPosition(JButton.BOTTOM);
		b_wt.setHorizontalTextPosition(JButton.CENTER);
		
		b_wcc.setVerticalTextPosition(JButton.BOTTOM);
		b_wcc.setHorizontalTextPosition(JButton.CENTER);

		
		// 조각케이크 탭
		
		
		b_pcg = new JButton("클래식갸또쇼콜라", new ImageIcon("src\\twosome_dessert\\p_cg.jpg"));
		b_pgcm = new JButton("그뤼에르치즈무스", new ImageIcon("src\\twosome_dessert\\p_gcm.jpg"));
		b_pnyc = new JButton("뉴욕치즈케이크", new ImageIcon("src\\twosome_dessert\\p_nyc.jpg"));
		b_pscc = new JButton("스트로베리초코생크림", new ImageIcon("src\\twosome_dessert\\p_gcm.jpg"));
		b_pt = new JButton("마스카포네티라미수", new ImageIcon("src\\twosome_dessert\\p_t.jpg"));
		b_pcc = new JButton("퀸즈캐롯", new ImageIcon("src\\twosome_dessert\\p_cc.jpg"));

		b_p = new JPanel();
		b_p.setLayout(new GridLayout(2,3));
		
		b_p.add(b_pcg);
		b_p.add(b_pgcm);
		b_p.add(b_pnyc);
		b_p.add(b_pscc);
		b_p.add(b_pt);
		b_p.add(b_pcc);
		
	    setLayout(new BorderLayout());
		add(b_p, BorderLayout.NORTH);
		b_p.setPreferredSize(new Dimension(200,245));
		b_p.setBorder(new TitledBorder("디저트 메뉴"));
		
		b_pcg.setVerticalTextPosition(JButton.BOTTOM);
		b_pcg.setHorizontalTextPosition(JButton.CENTER);
		
		b_pgcm.setVerticalTextPosition(JButton.BOTTOM);
		b_pgcm.setHorizontalTextPosition(JButton.CENTER);
		
		b_pnyc.setVerticalTextPosition(JButton.BOTTOM);
		b_pnyc.setHorizontalTextPosition(JButton.CENTER);
		
		b_pscc.setVerticalTextPosition(JButton.BOTTOM);
		b_pscc.setHorizontalTextPosition(JButton.CENTER);
		
		b_pt.setVerticalTextPosition(JButton.BOTTOM);
		b_pt.setHorizontalTextPosition(JButton.CENTER);
		
		b_pcc.setVerticalTextPosition(JButton.BOTTOM);
		b_pcc.setHorizontalTextPosition(JButton.CENTER);
		
		
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("홀케이크", b_w);
        tabbedPane.addTab("조각케이크", b_p);
        
        add(tabbedPane, BorderLayout.CENTER);
	}
	

}
