package b_info;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
public class InfoTest2 extends JFrame {


	//1.맴버변수 선언
	JTextArea ta;
	JTextField tfName, tfId,tfTel,tfAge,tfHome,tfSex;
	JButton bAdd, bShow,bSearch, bDelete, bCancel, bExit;	

	//2. 객체 생성

	InfoTest2(){
		super("나의 정보");//이렇게 코드를 짜면 제목이 생긴다.

		ButtonGroup bg = new ButtonGroup();
		bg.add(bAdd);
		bg.add(bShow);
		bg.add(bSearch);
		bg.add(bDelete);
		bg.add(bCancel);
		bg.add(bExit);

		bAdd = new JButton("Add", new ImageIcon("src\\imgs\\1.png"));
		bShow = new JButton("Show");
		bSearch = new JButton("Search");
		bDelete = new JButton("Delete");
		bCancel = new JButton("Cancel");
		bExit = new JButton("Exit");
		ta = new JTextArea();
		tfName = new JTextField(10);
		tfId = new JTextField(10);
		tfTel = new JTextField(10);
		tfHome = new JTextField(10);
		tfAge = new JTextField(10);
		tfSex = new JTextField(10);
	}

	void addLayout() {
		setLayout(new BorderLayout());
		add(ta, BorderLayout.CENTER);
		JPanel ps = new JPanel();		
		ps.setLayout(new GridLayout(1,6));
		ps.add(bAdd);
		ps.add(bShow);
		ps.add(bSearch);
		ps.add(bDelete);
		ps.add(bCancel);
		ps.add(bExit);
		add(ps,BorderLayout.SOUTH);




		JPanel pw = new JPanel();
		pw.setLayout(new GridLayout(6,2));
		pw.add(new JLabel("Name", JLabel.CENTER));
		pw.add(tfName);
		pw.add(new JLabel("Id", JLabel.CENTER));
		pw.add(tfId);
		pw.add(new JLabel("Tel", JLabel.CENTER));
		pw.add(tfTel);
		pw.add(new JLabel("Age", JLabel.CENTER));
		pw.add(tfAge);
		pw.add(new JLabel("Home", JLabel.CENTER));
		pw.add(tfHome);
		pw.add(new JLabel("Sex", JLabel.CENTER));
		pw.add(tfSex);
		add(pw,BorderLayout.WEST);


		setBounds(300,300,700,500);
		setVisible(true);


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void eventProc(){
		bExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "종료합니다.");
				System.exit(0);
			}
		}
				);//end of bExit


		bCancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				clearTexts();
			}
		}); 
		//end of bCancel

		bAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {

			}
		});
		//end of bAdd

		bShow.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {

			}
		});
		//end of bShow

		bSearch.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {

			}
		});
		//end of bSearch

		bDelete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {

			}
		});
		//end of bDelete

		tfId.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {//주민번호 입력창에서 엔터를 쳤을떄

				String id	 = 	tfId.getText();
				char sex1	 = 	id.charAt(7);
				char loc 	 = 	id.charAt(8);
				String a = "";
				switch(sex1) {
				case '1' :	
				case '3' :	
				case '5' :
					a = ("남성입니다.");
					break;
				case'2':	
				case'4':
				case'6':
					a = ("여성입니다.");
					break;
				} 
				tfSex.setText(a);
				JOptionPane.showMessageDialog(null, "고객님 주민번호는 " + id + "입니다.");
				JOptionPane.showMessageDialog(null, "고객님 성별은 " + a );
				String city = "";
				switch (loc) {
				case'0' : city = ("서울");
					break;
				case'1' : city = ("인천/부천");
					break;	
				case'2' : city = ("경기");
					break;
				default : city = ("한국");
				}
				tfHome.setText(city);
				JOptionPane.showMessageDialog(null, "출신지 " + city + "입니다.");
				Calendar c= Calendar.getInstance(); 
				int year = c.get(Calendar.YEAR);
				String age_str = id.substring(0,2);
				int age = Integer.parseInt(age_str);
				int age_i=0;
				if(sex1 =='1' | sex1 =='2') {
					age_i = year - ( 1900+ age) + 1;
				}
				else if (sex1 == '3' | sex1 == '4') {
					age_i = year - ( 2000+ age) + 1;
				}
//					tfAge.setText(age_i);
				JOptionPane.showMessageDialog(null, "고객님 나이는 " + age_i+"입니다." );

			}
		}
				);//end of bExit

	}// end of eventProc
	void clearTexts() {
		tfName.setText("");
		tfId.setText("");
		tfTel.setText("");
		tfAge.setText("");
		tfHome.setText("");
		tfSex.setText("");


	}// end of clearTexts

	public static void main(String[] args) {
		InfoTest2 test = new InfoTest2();
		test.addLayout();
		test.eventProc();
	}//자바에서 자주 사용하는 이벤트 ActionEvent
	// 주로 버튼 클릭시,메뉴 아이템을 클릭시
	//리스트에서 더블 클릭 했을때
	//텍스트필드에서 엔터를 쳤을때


	//
}

