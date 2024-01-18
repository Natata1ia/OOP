package lab4;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;


public class Document {
	
	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(300, 200);
		frame.setTitle("Справочник");
		frame.setLayout(new GridLayout(6, 0));
		
		JCheckBox defaultData = new JCheckBox("Использовать данные по умолчанию");
		JTextField firstName = new JTextField("Введите имя");
		JTextField lastName = new JTextField("Введите фамилию");
		JRadioButton mrb = new JRadioButton("Мужской", true);
		JRadioButton frb = new JRadioButton("Женский");
		ButtonGroup group = new ButtonGroup();
		group.add(frb); group.add(mrb);
		
		JTextField welcomeField = new JTextField("Привет!");
		firstName.setEditable(true);
		lastName.setEditable(true);
		welcomeField.setEditable(false);
		
		frame.add(defaultData);
		frame.add(firstName);
		frame.add(lastName);
		frame.add(mrb);
		frame.add(frb);
		frame.add(welcomeField);
		
		CheckListener listener = new CheckListener();
		listener.box = defaultData;
		listener.components.add(firstName);
		listener.components.add(lastName);
		listener.components.add(mrb);
		listener.components.add(frb);
		
		defaultData.addActionListener(listener);
		
		firstName.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				welcomeField.setText("Привет, " + firstName.getText() +" "+ lastName.getText() + "!");
			}
		});
		lastName.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				welcomeField.setText("Привет, " + firstName.getText() +" "+ lastName.getText() + "!");
			}
		});
				
		frame.setVisible(true);
	}
}
