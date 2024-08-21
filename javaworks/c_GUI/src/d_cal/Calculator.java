package d_cal;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//패널 5,3
public class Calculator extends JFrame {

	//1.맴버변수 선언
	
	JTextArea ta;
	JTextField tfNum;
	JButton bAdd, bSub, bDiv, bMul, bEqual,b0;
	JButton [] b = new JButton[10];

	int prev = 0, next = 0; // 연사자 전에 숫자를 저장 변수
	char op; //선택한 연산자를 저장할 변수
	//2. 객체 생성
	Calculator(){
		super("Calculator");

//		ButtonGroup bg = new ButtonGroup();
//
//		bAdd = new JButton("+");
//		bAdd = new JButton("-");
//		bAdd = new JButton("*");
//		bAdd = new JButton("/");
//		bAdd = new JButton("=");

		for(int i = 0; i<b.length; i+=1) {
			b[i] = new JButton(String.valueOf(i));
		}


		bSub = new JButton("-");
		bAdd = new JButton("+");
		bDiv = new JButton("/");
		bMul = new JButton("*");
		bEqual = new JButton("=");
		tfNum = new JTextField();
		for (int i = 0; i<b.length; i+=1) {
			b[i] = new JButton(String.valueOf(i));
		} 
	}






	//3.화면 붙히기 및 출력
	void addLayout() {
		setLayout(new BorderLayout());
		JPanel pc = new JPanel();
		pc.setLayout(new GridLayout(5,3));
		for(int i = 0 ;i<b.length ; i+=1) {
			pc.add(b[i]);
		}
		pc.add(b[0]);
		pc.add(bAdd);
		pc.add(bDiv);
		pc.add(bSub);
		pc.add(bMul);
		pc.add(bEqual);
		add(pc,BorderLayout.CENTER);

		add(tfNum,BorderLayout.NORTH);


		setBounds(300,300,400,600);
		setVisible(true);


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//	---------------------------------------------------------
	//4.이벤트처리
	void eventProc() { 
		//숫자가 눌렸을때
		for (int i = 0; i<b.length;i+=1) {
			int su = i;
			b[i].addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) {
					String str = b[su].getText();
					String prevNum = tfNum.getText();
					tfNum.setText(prevNum + str);
				}
			});
		}
		// '+' 버튼이 눌렀을 때

		bAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
					//Tf 값을 얻어와서 prev 변수에 저장
				String prev_str = tfNum.getText();
				int prev = Integer.parseInt(prev_str);
					//op = '+';
				char op = '+';
					//tf 비우기
				tfNum.setText(null);
			}
		});



		// '=' 버튼이 눌렀을 때
		bEqual.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				
						//tf 입력한 숫자값을 얻어와서 next 변수 저장
				int next = Integer.parseInt(tfNum.getText());
						//op 변수값에 따라 계산하여 출력
						int result = 0;
						switch(op) {
						case'+' : result = prev + next;
						break;
						case'-' :
						break;
						}
						
						tfNum.setText(String.valueOf(result));
			}
		});
	}
		void clearTexts() {
			bAdd.setText("");
			bMul.setText("");
			bDiv.setText("");
			bSub.setText("");
			bEqual.setText("");
			
	}

	public static void main(String[] args) {
		Calculator c = new Calculator();
		c.addLayout();
		c.eventProc();


	}

}
