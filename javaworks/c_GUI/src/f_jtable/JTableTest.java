package f_jtable;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class JTableTest {
	JFrame frame;
	JTable table; //화면에 출력되는 뷰(view)만 담당을 한다. 
	JButton button;
	MyTableModel tbModel; // 테이블의 테이터와 컬럼을 관리를 한다.

	public JTableTest() {
		frame = new JFrame("테이블 테스트");
		button = new JButton("눌러주세요");


		
		tbModel = new MyTableModel();	//테이블 위에 생성
		table = new JTable(tbModel); // 테이블 안에 tbModel 를 넣어준다.
		//JTable은 안쪽에 넣는다고해서 화면에 바로 출력이 되는게 아니여서 new JScrollPane를 호출을
		// 하고 거기 안에 넣어줘야 화면에 출력이 가능하다.

		frame.add(new JScrollPane(table), BorderLayout.CENTER);
		frame.add(button, BorderLayout.SOUTH);
		frame.setBounds(300, 300, 500, 400); // 크기 지정
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		//x박스를 누를때 종료

		// 버튼이 눌렸을 때
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change();

			}
		});
		//테이블에서 마우스 클릭 했을 때 -> 액션 이벤트로 해결이 불가능한 행동이다.
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				Integer value = (Integer)table.getValueAt(row, col); //오브젝트라서 형변
				System.out.println(row+","+col+"눌림 >" + value);
				
			}
		});
	}

	void change(){
		ArrayList data = new ArrayList();
		for(int i = 0 ; i<4;i+=1) {
			ArrayList temp = new ArrayList();
			for(int j = 0 ;j<4; j+=1) {
				temp.add( new Integer(i+j)); //deptecated 나중에 사라질수도있다.
			}
			data.add(temp);
		}
		// 그 데이터를 테이블 모델에 지정 -> 그 테이블모델을 테이블에 지정
		tbModel.data = data;
		table.setModel(tbModel);
		// 테이터가 이미 변경이 되어서 화면에 다시 반영하기 위해서 다시 호출을 해야한다.
		tbModel.fireTableDataChanged();

	}

	// 추상적 모델이기 때문에 구현을 해저야하기 때문에 오버라이딩을 해서 구현을 해줘야한다.
	// 테이블 모델을 만드는 이유는 테이블과 컬럼들을 실질적으로 관리를 해줘야하기 때문이다.



	class MyTableModel extends AbstractTableModel{

		ArrayList data = new ArrayList(); //테이블에 출력할 데이터를 선언
		String [] columnNames = {"하나","둘","셋","넷"}; // 컬럼명을 선언

		public int getRowCount() {

			return data.size();
		}
		public int getColumnCount() {

			return columnNames.length;//배열은 length로 카운트 가능
		}
		public Object getValueAt(int rowIndex, int columnIndex) {
			ArrayList temp = (ArrayList)data.get(rowIndex);

			return temp.get(columnIndex);
		}
		public String getColumnName(int col) {
			//오버라이딩을 해서 col값을 불러서 안쪽에 넣어주면 내가 설정한 컬럼값으로 설정이 가능하다.
			return columnNames[col];
		}

	}



	public static void main(String[] args) {
		new JTableTest();
	}

}
