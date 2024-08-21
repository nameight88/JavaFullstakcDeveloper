package mysql_f_emp_exericse;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EmpView {

	// 화면 관련 멤버변수
	JFrame f;
	JTextField tfEmpno, tfEname, tfSal, tfJob;
	JButton bInsert, bUpdate, bDelete, bSelectAll;
	JTextArea ta;

	//#########################
	// 모델단 멤버 변수
	EmpModel model;

	// 멤버변수 객체 생성
	EmpView(){

		//#########################
		// 모델단 멤버변수 객체 생성
		try {
			model = new EmpModelImpl();
			System.out.println("드라이버로딩성공");
		}catch(Exception ex){
			System.out.println("드라이버 로딩 실패");
		}
		f = new JFrame("나의 연습");
		tfEmpno = new JTextField(10);
		tfEname = new JTextField(10);
		tfSal = new JTextField(10);
		tfJob = new JTextField(10);
		bInsert = new JButton("입력");
		bUpdate = new JButton("수정");
		bDelete = new JButton("삭제");
		bSelectAll = new JButton("전체검색");
		ta = new JTextArea();
	}

	// 화면 구성
	void addLayout() {
		JPanel pNorth = new JPanel();
		pNorth.setLayout(new GridLayout(1,2));

		JPanel pNorth1 = new JPanel();
		pNorth1.setLayout(new GridLayout(4,2));
		pNorth1.add(new JLabel("사번"));		pNorth1.add(tfEmpno);
		pNorth1.add(new JLabel("사원명"));		pNorth1.add(tfEname);
		pNorth1.add(new JLabel("월급"));		pNorth1.add(tfSal);
		pNorth1.add(new JLabel("업무"));		pNorth1.add(tfJob);

		JPanel pNorth2 = new JPanel();
		pNorth2.setLayout(new GridLayout(4,1));
		pNorth2.add(bInsert);
		pNorth2.add(bUpdate);
		pNorth2.add(bDelete);
		pNorth2.add(bSelectAll);

		pNorth.add(pNorth1);
		pNorth.add(pNorth2);

		f.add(pNorth, BorderLayout.NORTH);
		f.add(new JScrollPane(ta), BorderLayout.CENTER);

		f.setBounds(200, 200, 600, 500);
		f.setVisible(true);
	}

	// ******************************************************************************
	// 버튼 및 텍스트필드 이벤트 관련
	void eventProc() {
		// 입력버튼이 눌렸을 때
		bInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int empno = Integer.parseInt(tfEmpno.getText());
					String ename = tfEname.getText();
					int sal = Integer.parseInt(tfSal.getText());
					String job = tfJob.getText();

					EmpVO r = new EmpVO();
					r.setEmpno(Integer.parseInt(tfEmpno.getText()));
					r.setEname(tfEname.getText());
					r.setSal(Integer.parseInt(tfSal.getText()));
					r.setJob(tfJob.getText());

					model.insert(r);
					clearTexts();

				}catch(Exception ex) {
					ta.append("연결 실패: "+ ex.getMessage());
				}

			}
		});

		// 사번 텍스트필드에서 사번 입력 후 엔터 쳤을 때
		tfEmpno.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				int empno = (Integer.parseInt(tfEmpno.getText()));

				try {

					EmpVO r = model.selectByEmpno(empno);
					// 각각 화면 텍스트필드에 지정(출력)
					tfEmpno.setText( String.valueOf(r.getEmpno()) );
					tfEname.setText( r.getEname() );
					tfSal.setText(String.valueOf(r.getSal()));
					tfJob.setText(r.getJob() );
					// **** 나머지도

				}catch(Exception ex) {
					ta.setText("사원번호검색실패 :" + ex.getMessage());
				}
			}
		});
		// 사번 입력 후 삭제버튼 눌렸을 때
		bDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int empno = (Integer.parseInt(tfEmpno.getText()));
				try {
					model.delete(empno);
					ta.setText("삭제성공");
				}catch(Exception ex){
					System.out.println("삭제를 실패했습니다: "+ ex.getMessage());
				}
				clearTexts();

			}
		});


		// 수정 버튼이 눌렸을 때
		bUpdate.addActionListener(new ActionListener() // update버튼을 눌렀을때의 이벤트 설정
		{
			public void actionPerformed(ActionEvent ev) {
				try {

					int empno = Integer.parseInt(tfEmpno.getText()); // 스트링 함수를 얻어서 int형으로 교체
					int sal = Integer.parseInt(tfSal.getText());
					String ename = tfEname.getText();
					String Job = tfJob.getText();

					EmpVO r = new EmpVO(); // EmpVO 호출및 선언
					r.setEmpno(empno);
					r.setEname(ename);
					r.setJob(Job);
					r.setSal(sal);
					model.modify(r); // 인터페이스에서 설정을 한 modify를 호출해서 이벤트 발생
					ta.append("수정성공");
				} catch (Exception e1) {
					ta.append("수정실패: " + e1.getMessage());
				}

			}
		});

		bSelectAll.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				try { 
					ArrayList<EmpVO> list = model.selectAll();
					ta.setText("--------- 검색결과 ---------- \n\n");

					for(int i = 0; i<list.size(); i +=1) {
						EmpVO temp = (EmpVO)list.get(i);
						ta.append(temp.toString());
					}
				}catch(Exception ex) {
					System.out.println("전체검색실패: " + ex.getMessage());
					ex.printStackTrace();
				}

			}
		});

	}


	void clearTexts() {
		tfEmpno.setText("");
		tfEname.setText("");
		tfSal.setText("");
		tfJob.setText("");
		ta.setText("");
	}//end of clearTexts





	public static void main(String[] args) {
		EmpView view = new EmpView();
		view.addLayout();
		view.eventProc();

	}

}
