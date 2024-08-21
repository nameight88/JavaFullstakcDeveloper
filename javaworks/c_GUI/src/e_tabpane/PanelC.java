package e_tabpane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import e_tabpane.model.ModelC;
public class PanelC extends JPanel {
	JButton btn;
	
	ModelC model;
	
		public PanelC() {
			
			try {
				model = new ModelC();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			btn = new JButton("통닭");
			
			add(btn);
			eventproc();
			
		}
		void eventproc() {
			
			btn.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					
				}
			});
			
		}
}
