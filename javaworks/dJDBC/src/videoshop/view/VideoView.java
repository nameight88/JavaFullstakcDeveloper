package	 videoshop.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import com.mysql.cj.xdevapi.Table;

import videoshop.model.VideoDao;
import videoshop.model.dao.VideoModel;
import videoshop.model.vo.Video;


public class VideoView extends JPanel 
{	
	//	member field
	JTextField	tfVideoNum, tfVideoTitle, tfVideoDirector, tfVideoActor;
	JComboBox	comVideoJanre;
	JTextArea	taVideoContent;

	JCheckBox	cbMultiInsert;
	JTextField	tfInsertCount;

	JButton		bVideoInsert, bVideoModify, bVideoDelete;

	JComboBox	comVideoSearch;
	JTextField	tfVideoSearch;
	JTable		tableVideo;

	VideoTableModel tbModelVideo;

	//모델변수 설정
	VideoDao model;

	//##############################################
	//	constructor method
	public VideoView(){
		addLayout(); 	// 화면설계
		initStyle();
		eventProc();
		connectDB();	// DB연결
	}

	public void connectDB(){	// DB연결
		try {
			model = new VideoModel();
			System.out.println("비디오 모델 생성 성공");
		}catch(Exception ex) {
			System.out.println("비디오 모델 생성 실패: "+ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void eventProc(){
 		//'다중입고' 체크박스에 이벤트 발생하면
		cbMultiInsert.addActionListener(new ActionListener() {
			// 어떤 값을 가져올때는 보통 get으로 얻어오지만 true/false일때는 is를 사용
			public void actionPerformed(ActionEvent e) {
				tfInsertCount.setEditable(cbMultiInsert.isSelected());

			}
		});
		//일일히 다 위에 코드처럼 작성을 해도 되지만 이렇게 축약도 가능하다.
		ButtonEventHandler hdlr = new ButtonEventHandler();
		bVideoInsert.addActionListener(hdlr);
		bVideoModify.addActionListener(hdlr);
		bVideoDelete.addActionListener(hdlr);
		tfVideoSearch.addActionListener(hdlr);

		// JTable에 클릭 했을때
		tableVideo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = tableVideo.getSelectedRow(); //눌렀을때의 행이 비디오 번호이므로 중요하다
				int col = 0;
				int videoNum = (Integer)tableVideo.getValueAt(row, col);
				try {
					
					Video v = model.searchByPk(videoNum);
					tfVideoNum.setText(String.valueOf(v.getVideoNo()));
					tfVideoActor.setText(v.getActor());
					tfVideoDirector.setText(v.getDirector());
					tfVideoTitle.setText(v.getVideoName());

				}catch(Exception ex){
					System.out.println("비디오 검색 실패: "+ex.getMessage());
					ex.printStackTrace();
				}
			}
		});

	}
//end of eventProc

	// 버튼 이벤트 핸들러 만들기
	class ButtonEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			Object o = ev.getSource();

			if(o==bVideoInsert){  
				registVideo();					// 비디오 등록

			}
			else if(o==bVideoModify){  
				modifyVideo();					// 비디오 정보 수정
			}
			else if(o==bVideoDelete){  
				deleteVideo();					// 비디오 정보 삭제
			}
			else if(o==tfVideoSearch){
				searchVideo();					// 비디오 검색
			}
		}
	}
//end of ButtonEventHandler implements ActionListener

	// 입고 클릭시  - 비디오 정보 등록
	public void registVideo(){
		//JOptionPane.showMessageDialog(null, "입고"); // 나중에 이런 메시지는 개발자가 확인용이므로 실제로는 불필요한 메시지는 삭제를 하자
		/*
		 *	화면에 입력값 얻어오기
		 *	얻어온 입력값을 video 맴버 지정
		 */
		
		Video v = new Video();
		v.setGenre(	(String)comVideoJanre.getSelectedItem()); //받아오는 값이 오브젝트라서 스트링으로 형변환을 해주어야한다.
		v.setVideoName( tfVideoTitle.getText());
		v.setActor( tfVideoActor.getText());
		v.setDirector( tfVideoDirector.getText());
		//		v.setVideoNo( .getText());

		int count = Integer.parseInt(tfInsertCount.getText());

		try {
			model.insertVideo(v, count);
			//화면지우기
		}catch(Exception ex) {
			System.out.println("입고 실패: "+ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void initStyle(){   // 입력하지 못하게 만듬.
		tfVideoNum.setEditable(false);  //쉽게 말해 읽기모드처럼 사용을 해서 관리자만 이용이 가능하게 설정을 한다.
		tfInsertCount.setEditable(false);		
		//tfInsertCount.setEnaled(faslse); 아예 수정을 못하게 만든다.
		tfInsertCount.setHorizontalAlignment(JTextField.RIGHT); //숫자가 오른쪽 정렬이 되게 해준다.
	}
//end of registVideo

	// 수정 클릭시 - 비디오 정보 수정
	public void modifyVideo(){
		
		try {
			Video v = new Video();
			String title = tfVideoTitle.getText();
			String director = tfVideoTitle.getText();
			String actor = tfVideoTitle.getText();
			String datail = tfVideoTitle.getText();
			String genre = tfVideoTitle.getText();
			int num = Integer.parseInt(tfVideoNum.getText());
			
			v.setActor(actor);
			v.setDirector(director);
			v.setExp(datail);
			v.setGenre(genre);
			v.setVideoNo(num);
			model.bVideoModify(v);
			
		}catch(Exception ex) {
			System.out.println("수정에 실패했습니다: "+ex.getMessage());
			ex.printStackTrace();
		}
	}
//end of modifyVideo

	// 삭제 클릭시 - 비디오 정보 삭제
	public void deleteVideo()
	{	
		int videoNum = (Integer.parseInt(tfVideoNum.getText()));
		try {
			model.deleteVideo(videoNum);
		}catch(Exception ex) {
			System.out.println("삭제를 실패했습니다: "+ex.getMessage());
			ex.printStackTrace();
		}
	}
// end of deleteVideo

	// 비디오현황검색
	public void searchVideo(){
		//JOptionPane.showMessageDialog(null, "검색");
		int idx = comVideoSearch.getSelectedIndex();
		String keyword = tfVideoSearch.getText();

		try {
			ArrayList data = model.selectVideos(idx,keyword);
			tbModelVideo.data = data;
			tableVideo.setModel(tbModelVideo);
			tbModelVideo.fireTableDataChanged();
		}catch(Exception ex) {
			System.out.println("검색 실패: "+ex.getMessage());
			ex.printStackTrace();
		}
	}
//end of searchVideo

	//  화면설계 메소드
	public void addLayout(){
		//멤버변수의 객체 생성
		tfVideoNum = new JTextField();
		tfVideoTitle = new JTextField();
		tfVideoDirector = new JTextField();
		tfVideoActor = new JTextField();

		String []cbJanreStr = {"멜로","엑션","스릴","코미디"};
		comVideoJanre = new JComboBox(cbJanreStr);
		taVideoContent = new JTextArea();

		cbMultiInsert = new JCheckBox("다중입고");
		tfInsertCount = new JTextField("1",5);

		bVideoInsert = new JButton("입고");
		bVideoModify = new JButton("수정");
		bVideoDelete = new JButton("삭제");

		String []cbVideoSearch = {"제목","감독"};
		comVideoSearch = new JComboBox(cbVideoSearch);
		tfVideoSearch = new JTextField(15);

		tbModelVideo = new VideoTableModel();
		tableVideo = new JTable(tbModelVideo);

		//*********************************************************************
		// 화면 구성
		//왼쪽영역
		JPanel p_west = new JPanel();
		p_west.setLayout(new BorderLayout());
		// 왼쪽 가운데
		JPanel p_west_center = new JPanel();	
		p_west_center.setLayout(new BorderLayout());
		// 왼쪽 가운데의 윗쪽
		JPanel p_west_center_north = new JPanel();
		p_west_center_north.setLayout(new GridLayout(5,2));
		p_west_center_north.add(new JLabel("비디오번호"));
		p_west_center_north.add(tfVideoNum);
		p_west_center_north.add(new JLabel("장르"));
		p_west_center_north.add(comVideoJanre);
		p_west_center_north.add(new JLabel("제목"));
		p_west_center_north.add(tfVideoTitle);
		p_west_center_north.add(new JLabel("감독"));
		p_west_center_north.add(tfVideoDirector);
		p_west_center_north.add(new JLabel("배우"));
		p_west_center_north.add(tfVideoActor);

		// 왼쪽 가운데의 가운데
		JPanel p_west_center_center = new JPanel();
		p_west_center_center.setLayout(new BorderLayout());
		// BorderLayout은 영역 설정도 해야함
		p_west_center_center.add(new JLabel("설명"),BorderLayout.WEST);
		p_west_center_center.add(taVideoContent,BorderLayout.CENTER);

		// 왼쪽 화면에 붙이기
		p_west_center.add(p_west_center_north,BorderLayout.NORTH);
		p_west_center.add(p_west_center_center,BorderLayout.CENTER);
		p_west_center.setBorder(new TitledBorder("비디오 정보입력"));

		// 왼쪽 아래
		JPanel p_west_south = new JPanel();		
		p_west_south.setLayout(new GridLayout(2,1));

		JPanel p_west_south_1 = new JPanel();
		p_west_south_1.setLayout(new FlowLayout());
		p_west_south_1.add(cbMultiInsert);
		p_west_south_1.add(tfInsertCount);
		p_west_south_1.add(new JLabel("개"));
		p_west_south_1.setBorder(new TitledBorder("다중입력시 선택하시오"));
		// 입력 수정 삭제 버튼 붙이기
		JPanel p_west_south_2 = new JPanel();
		p_west_south_2.setLayout(new GridLayout(1,3));
		p_west_south_2.add(bVideoInsert);
		p_west_south_2.add(bVideoModify);
		p_west_south_2.add(bVideoDelete);

		p_west_south.add(p_west_south_1);
		p_west_south.add(p_west_south_2);

		p_west.add(p_west_center,BorderLayout.CENTER);
		p_west.add(p_west_south, BorderLayout.SOUTH);   // 왼쪽부분완성

		//---------------------------------------------------------------------
		// 화면구성 - 오른쪽영역
		JPanel p_east = new JPanel();
		p_east.setLayout(new BorderLayout());

		JPanel p_east_north = new JPanel();
		p_east_north.add(comVideoSearch);
		p_east_north.add(tfVideoSearch);
		p_east_north.setBorder(new TitledBorder("비디오 검색"));

		p_east.add(p_east_north,BorderLayout.NORTH);
		p_east.add(new JScrollPane(tableVideo),BorderLayout.CENTER);
		// 테이블을 붙일때에는 반드시 JScrollPane() 이렇게 해야함 


		// 전체 화면에 왼쪽 오른쪽 붙이기
		setLayout(new GridLayout(1,2));

		add(p_west);
		add(p_east);

	}
//end of addLayout

	//화면에 테이블 붙이는 메소드 
	class VideoTableModel extends AbstractTableModel { 

		ArrayList data = new ArrayList();
		String [] columnNames = {"비디오번호","제목","장르","감독","배우"};


		//=============================================================
		// 1. 기본적인 TabelModel  만들기
		// 아래 세 함수는 TabelModel 인터페이스의 추상함수인데
		// AbstractTabelModel에서 구현되지 않았기에...
		// 반드시 사용자 구현 필수!!!!

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
}
//end of VideoTableModel extends AbstractTableModel


