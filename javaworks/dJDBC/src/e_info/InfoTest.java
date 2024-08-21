package e_info;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

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


		bShow.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				try {
					InfoVo vo = new InfoVo();
					vo.setName		(tfName.getText());
					vo.setAge		(Integer.parseInt(tfAge.getText()));
					vo.setGender	(tfSex.getText());
					vo.setHome		(tfHome.getText());
					vo.setId		(tfId.getText());
					vo.setTel		(tfTel.getText());
					model.modifyData(vo);
					clearTexts();

					ta.append("수정성공");
				} catch (Exception e1) {
					ta.append("수정실패: " + e1.getMessage());
				}

			}
		});



		// add 버튼이 눌렸을 때
		bAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {

				try {
					//사용자 입력값 얻어오기


					// 여러 입력값들을 하나의 VO 객체로 지정
					// infoVo vo  =new(name,id,tel,~~~)
					InfoVo vo = new InfoVo();
					vo.setName(tfName.getText());
					vo.setAge(Integer.parseInt(tfAge.getText()));
					vo.setGender(tfSex.getText());
					vo.setHome(tfHome.getText());
					vo.setId(tfId.getText());
					vo.setTel(tfTel.getText());

					model.insertData(vo);
					
					ta.append("연결성공");
				} catch (Exception e1) {
					ta.append("연결실패: " + e1.getMessage());
				}
				clearTexts();
				searchAll();
			}
		});



		bSearch.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				searchAll();

			}
		});
		//end of bSearch


		tfTel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				String tel = tfTel.getText();

				try{
					InfoVo vo = model.searchByTel(tel);
					//각각 화면 텍스트필드에 지정(출력)
					tfName.setText(vo.getName());
					tfSex.setText(vo.getGender());
					tfId.setText(vo.getId());
					tfHome.setText(vo.getHome());
					tfAge.setText(String.valueOf(vo.getAge()));
				}catch(Exception ex) {
					ta.setText("전화번호 검색실패 :" + ex.getMessage());
				}
			}
		}
				);


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
		bDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String tel = tfTel.getText();
				try {
					model.deleteData(tel);
					
				}catch(Exception ex){
					System.out.println("삭제를 실패했습니다: "+ ex.getMessage());
				}
				clearTexts();
				searchAll();
			}
		});



	} // end of eventProc()

	void searchAll() {
		try { 
			ArrayList<InfoVo> list = model.searchALL();
			ta.setText("--------- 검색결과 ---------- \n\n");

			for(int i = 0; i<list.size(); i +=1) {
				InfoVo temp = (InfoVo)list.get(i);
				ta.append(temp.toString());
			}
		}catch(Exception ex) {
			System.out.println("전체검색실패: " + ex.getMessage());
			ex.printStackTrace();
		}
	}//end of searchAll()


	void clearTexts() {
		tfName.setText("");
		// 나머지도
		tfAge.setText("");
		tfId.setText("");
		tfHome.setText("");
		tfSex.setText("");
		tfTel.setText("");
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












