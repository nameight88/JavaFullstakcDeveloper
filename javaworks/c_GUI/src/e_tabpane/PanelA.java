package e_tabpane;
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import e_tabpane.model.ModelA;

public class PanelA extends JPanel {
	JTable table;
	MyTableModel tm;
	
	ModelA model;
	
	
	public PanelA() {
		
		try {
			model = new ModelA();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		tm = new MyTableModel();
		table = new JTable(tm);

		setLayout(new BorderLayout());
		add(new JScrollPane(table), BorderLayout.CENTER);
		
		

	}
	class MyTableModel extends AbstractTableModel{
		ArrayList data = new ArrayList(); //테이블에 출력할 데이터를 선언
		String [] columnNames = {"메뉴","가격"}; // 컬럼명을 선언

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
}
