package b_info;
import java.awt.*;
import javax.swing.*;
public class InfoTest extends JFrame {
	
	
//1.맴버변수 선언
	JTextArea ta;
	JTextField tfName, tfId,tfTel,tfAge,tfHome,tfSex;
	JButton bAdd, bShow,bSearch, bDelete, bCancel, bExit;	
	
//2. 객체 생성
	
	InfoTest(){
		super("나의 정보");//이렇게 코드를 짜면 제목이 생긴다.
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(bAdd);
		bg.add(bShow);
		bg.add(bSearch);
		bg.add(bDelete);
		bg.add(bCancel);
		bg.add(bExit);
		
		bAdd = new JButton("Add");
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
	
	
	
	
	public static void main(String[] args) {
		InfoTest test = new InfoTest();
		test.addLayout();
	}

	
}
