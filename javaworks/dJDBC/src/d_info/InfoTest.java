package d_info;
import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InfoTest extends JFrame {

	// 1. 멤버변수선언
	JTextArea ta;
	JTextField tfName, tfId ,tfTel , tfSex, tfAge, tfHome;
	JButton bAdd , bShow, bSearch , bDelete , bCancel , bExit;

	// 데이타베이스 연동 변수 선언
	InfoModel model;

	// 2. 객체 생성
	InfoTest(){
		super("나의 정보");
		
		ta = new JTextArea (50,50);

		tfName = new JTextField(15);
		tfId = new JTextField();
		tfTel = new JTextField();
		tfSex = new JTextField();
		tfAge = new JTextField();
		tfHome = new JTextField();

		bAdd = new JButton("Add");
		bShow = new JButton("Modify");
		bSearch = new JButton("Search");
		bDelete = new JButton("Delete");
		bCancel = new JButton("Cancel");
		bExit = new JButton("Exit");

		// 데이타베이스 연동 객체 생성
		try {
			model = new InfoModelImpl();
			ta.setText("드라이버 로딩 성공");
		}catch(Exception ex) {
			ta.setText("드라이버 로딩 실패:" + ex.getMessage());
		}
	}

	// 3. 화면 붙이기 및 출력
	void addLayout() {

		setLayout (new BorderLayout());
		add(ta, BorderLayout.CENTER);



		JPanel p = new JPanel();
		p.setLayout(new GridLayout(6,2));
		//p.add(new JLabel("name"));
		p.add(new JLabel("이름", JLabel.CENTER));
		p.add(tfName);
		p.add(new JLabel("ID"));
		p.add(tfId);

		p.add(new JLabel("Tel"));
		p.add(tfTel);
		p.add(new JLabel("Sex"));
		p.add(tfSex);
		p.add(new JLabel("Age"));
		p.add(tfAge);
		p.add(new JLabel("Home"));
		p.add(tfHome);

		add(p,BorderLayout.WEST);



		JPanel u = new JPanel();
		u.setLayout(new GridLayout(1,6));
		u.add(bAdd);
		u.add(bShow);
		u.add(bSearch);
		u.add(bDelete);
		u.add(bCancel);
		u.add(bExit);
		add(u, BorderLayout.SOUTH);

		setBounds(300, 300 , 700, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	void eventProc() {
		// exit 버튼이 눌렸을 때
		bExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				System.exit(0);		
			}
		});
		
		// cancel 버튼이 눌렸을 때
		bCancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
					clearTexts();			
			}
		});
		
		// add 버튼이 눌렸을 때
		bAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				
					try {
						// 1. 사용자 입력값 얻어오기
						String name = tfName.getText();
						String id 	= tfId.getText();
						String tel	= tfTel.getText();
						String sex  = tfSex.getText();
						String home	= tfHome.getText();
						int age = Integer.parseInt(tfAge.getText());
						
						// 2. 여러 입력값들을 VO 객체로 지정
						// InfoVO vo = new InfoVO(name, id, tel, ~~~~ );
						InfoVO vo = new InfoVO();
						vo.setName(name);
						vo.setId(id);
						vo.setTel(tel);
						vo.setGender(sex);
						vo.setAge(age);
						vo.setHome(home);
						
						
						model.insertData(vo);
						clearTexts();
						
					} catch (Exception e1) {
						ta.append("연결실패: " + e1.getMessage());
					}
					
			}
		});
		
		
		
		// 주민번호 입력창에서 엔터쳤을 때
		tfId.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				
				String id = tfId.getText();
				
				// 성별
				
				
				// 출신지
				
				
				// 나이 
				
			}
		});
		
		// 전화번호에서 엔터쳤을 때
		tfTel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				String tel = tfTel.getText();
				try {
				InfoVO vo = model.searchByTel(tel);
				// 각각 화면 텍스트필드에 지정(출력)
				tfName.setText( vo.getName() );
					// **** 나머지도
				
				}catch(Exception ex) {
					ta.setText("전화번호검색실패 :" + ex.getMessage());
				}
			}
		});
		
		// 'Search' 버튼이 눌렸을 때
		bSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				try {
					ArrayList<InfoVO> list = model.searchAll();
					ta.setText(" ========= 검색결과  ======= \n\n");
					
					// 기본 for -> 향상된 for 수정
					for(int i=0; i<list.size(); i++) {
						InfoVO temp = (InfoVO)list.get(i);
						ta.append(temp.toString());
					}	
				} catch (Exception e1) {
					System.out.println("전체검색실패:" + e1.getMessage());
					e1.printStackTrace();
				}				
			}
		});
		
		
		// 'Delete' 버튼이 눌렸을 때
		bDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String tel = tfTel.getText();
				
				try {
					model.deleteData(tel);
				} catch (Exception e1) {
					ta.setText("삭제실패:"+ e1.getMessage());
				}
				
				clearTexts();
			}
		});
		
		// 'Modify' 버튼이 눌렸을 때
		bShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					// 1. 사용자 입력값 얻어오기
					String name = tfName.getText();
					String id 	= tfId.getText();
					String tel	= tfTel.getText();
					String sex  = tfSex.getText();
					String home	= tfHome.getText();
					int age = Integer.parseInt(tfAge.getText());

					InfoVO vo = new InfoVO();
					vo.setName(name);
					vo.setId(id);
					vo.setTel(tel);
					vo.setGender(sex);
					vo.setAge(age);
					vo.setHome(home);
					
					
					model.modifyData(vo);
					clearTexts();
					
				} catch (Exception e1) {
					ta.append("수정실패: " + e1.getMessage());
				}
				
			}
		});
		
		
	} // end of eventProc()
	
	void clearTexts() {
		tfName.setText("");
		// 나머지도
		
		ta.setText("");
	}
	
	
	public static void main(String[] args) {

		InfoTest test = new InfoTest();
		test.addLayout();
		test.eventProc();

	}

}


/*
 	ActionEvent : 자주 사용하는 이벤트 묶음
 	
 		` 버튼 클릭시
 		` 메뉴아이템을 클릭시
 		` 리스트 더블클릭시
 		` 텍스트필드에서 엔터쳤을 때
 		
 */












