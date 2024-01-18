package lab4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

public class CheckListener implements ActionListener {
	
	public ArrayList<JComponent> components = new ArrayList<JComponent>();
	
	public JCheckBox box;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for (JComponent obj : components) {
			obj.setEnabled(!box.isSelected());
		}
	}
}
