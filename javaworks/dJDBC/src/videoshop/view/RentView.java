package  videoshop.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import videoshop.model.RentDao;
import videoshop.model.dao.RentModel;



public class RentView extends JPanel 
{
	JTextField tfRentTel, tfRentCustName, tfRentVideoNum;
	JButton bRent;
	
	JTextField tfReturnVideoNum;
	JButton bReturn;
	
	JTable tableRecentList;
	
	RentTableModel rentTM;
	RentDao model;

	
	//==============================================
	//	 생성자 함수
	public RentView(){
		addLayout();	//화면구성
		eventProc();	
		connectDB();	//DB연결
		
		showNotReturn();
	}
	
	// DB 연결
	void connectDB(){
		try {
			model = new RentModel();
		} catch (Exception e) {
			System.out.println("대여관리 - > 드라이버 로딩 실패:" +e.getMessage());
			e.printStackTrace();
		}
	}
	
	//미납 목록보기
	public void showNotReturn() {
		try {
			
			rentTM.data = model.selectNoReturn();
			tableRecentList.setModel(rentTM);
			rentTM.fireTableDataChanged();
			
		} catch (Exception e) {
			System.out.println("미납목록보기 실패: "+e.getMessage());
			e.printStackTrace();
		}
	}
	//대여버튼일 눌렸을때 전화번호를 엔터 반납버튼을 눌렀을때
	//view에서 이벤트를 등록 model에서 인터페이스 구현
	
	// 이벤트 등록
	//전화번호 엔터 쳤을때
	public void eventProc(){
		tfRentTel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tel = tfRentTel.getText();
				try {
					model.selectTel();
				}catch(Exception ex) {
					System.out.println("검색 실패: "+ex.getMessage());
					ex.printStackTrace();
				}
			}
		});
	//대여버튼을 눌렀을때
		bRent.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				rentVideo();
				showNotReturn();
			}
		});
	//반납을 눌렀을때
		bReturn.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent e) {
				returnVideo();
				showNotReturn();
			}
		});           
	}
	
	/*	객체 생성 및 화면 구성   */
	void addLayout(){

		tfRentTel = new JTextField();
		tfRentCustName = new JTextField();
		tfRentVideoNum = new JTextField();
		bRent = new JButton("대여"); //버튼 안에 넣을 글자를 넣어야한다.
		// 위에서 왼쪽
		
		tfReturnVideoNum = new JTextField(20);
		bReturn = new JButton("반납");
		// 위에서 오른쪽
		
		rentTM = new RentTableModel();
		tableRecentList = new JTable(rentTM);//리스트에 어떤 값을 넣을지 설정을 해줘야한다.
		// 리스트
		
		//화면 구성
		JPanel pNorth = new JPanel(); //윗쪽에 배치할 새로운 패널을 선언
		
		//화면의 윗쪽 왼쪽
		JPanel pNorth_left = new JPanel(); //윗쪽 왼쪽에 만들 공간은 선언
		pNorth_left.setBorder(new TitledBorder("대     여")); //타이틀을 만들어서 분류를 해준다.
		pNorth_left.setLayout(new GridLayout(4,2)); //4행 2열
		pNorth_left.add(new JLabel("전 화 번 호"));
		pNorth_left.add(tfRentTel);
		pNorth_left.add(new JLabel("고 객 명"));
		pNorth_left.add(tfRentCustName);
		pNorth_left.add(new JLabel("비디오 번호"));// 라벨안에 글자값을 넣어서 저장
		pNorth_left.add(tfRentVideoNum);
		pNorth_left.add(bRent);
		
		//화면의 윗쪽 오른쪽
		JPanel pNorth_right = new JPanel();
		pNorth_right.setBorder(new TitledBorder("반     납"));
		pNorth_right.add(new JLabel("비디오 번호"));
		pNorth_right.add(tfReturnVideoNum);
		pNorth_right.add(bReturn);
		
		pNorth.setLayout(new GridLayout(1,2));
		pNorth.add(pNorth_left);
		pNorth.add(pNorth_right);
		//화면의 가운데
		JPanel pCenter = new JPanel();
		pCenter.setLayout(new BorderLayout());
		pCenter.add(new JScrollPane(tableRecentList), BorderLayout.CENTER);
		
		//전체화면 설정
		setLayout(new BorderLayout());
		add(pNorth, BorderLayout.NORTH);
		add(pCenter, BorderLayout.CENTER);
		
		
	}

	class RentTableModel extends AbstractTableModel { 
		  
		ArrayList data = new ArrayList();
		String [] columnNames = {"비디오번호","제목","고객명","전화번호","반납예정일","반납여부"};

			public int getColumnCount() { 
		        return columnNames.length; 
		    } 
		     
		    public int getRowCount() { 
		        return data.size(); 
		    } 

		    public Object getValueAt(int row, int col) { 
				ArrayList temp = (ArrayList)data.get( row );
		        return temp.get( col ); 
		    }
		    
		    public String getColumnName(int col){
		    	return columnNames[col];
		    }
	}

	
	void rentVideo (){
	/*
	 * 전화번호 입력값 얻어오기
	 * 대여할 비디오번호 입력값 얻어오기
	 * model rentVideo(전화번호와 비디오번호) 호출
	 * 화면 비우기
	 */
	String tel = tfRentTel.getText();
	int vNum = Integer.parseInt(tfRentVideoNum.getText());
	try {
		model.RentVideo(tel, vNum);
		//화면비우기
	}catch(Exception ex){
	System.out.println("대여 실패: "+ex.getMessage());
	ex.printStackTrace();
		}
	}
//end of rentVideo
	void returnVideo(){
	/*
	 * 반납할 비디오 번호 입력값 얻어오기
	 * 
	 */
		int vnum = Integer.parseInt(tfReturnVideoNum.getText());
		try {
			model.ReTurnVideo(vnum);
		} catch (Exception e) {
			System.out.println("반납실패: "+e.getMessage());
			e.printStackTrace();
		}
	}
//end of returnVideo
	
}
