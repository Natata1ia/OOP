package lab2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Frame {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(500, 300);
		frame.setTitle("Вклад");

		frame.setLayout(new GridLayout(0, 2, 10, 10));

		frame.add(new JLabel("Тип вклада:", SwingConstants.CENTER));
		JComboBox<String> vkladType = new JComboBox<String>(new String[] {"Стандартный",  "Пенсионный","Премиум","Максимальный"});
		frame.add(vkladType);

		frame.add(new JLabel("Сумма вклада (Руб.):", SwingConstants.CENTER));
		JTextField vkladCount = new JTextField("10000");
		frame.add(vkladCount);
		
		ButtonGroup group = new ButtonGroup();
		JRadioButton threeMonth = new JRadioButton("3 месяца");
		threeMonth.setHorizontalAlignment(JRadioButton.CENTER);
		group.add(threeMonth);
		frame.add(threeMonth);
		
		JRadioButton sixMonth = new JRadioButton("6 месяцев");
		sixMonth.setHorizontalAlignment(JRadioButton.CENTER);
		group.add(sixMonth);		
		frame.add(sixMonth);
		
		JRadioButton oneYear = new JRadioButton("1 год");
		oneYear.setHorizontalAlignment(JRadioButton.CENTER);
		group.add(oneYear);
		frame.add(oneYear);
		
		JRadioButton threeYear = new JRadioButton("3 года");
		threeYear.setHorizontalAlignment(JCheckBox.CENTER);
		group.add(threeYear);
		frame.add(threeYear);

		JButton vkladCalculate = new JButton("Рассчитать сумму в конце срока");
		JLabel vkladResult = new JLabel("Итого: - рублей");
		vkladResult.setHorizontalAlignment(JLabel.CENTER);
		
		frame.add(vkladCalculate);
		frame.add(vkladResult);
		
		vkladCalculate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				float count = Float.parseFloat(vkladCount.getText());
				float precent = 3 + vkladType.getSelectedIndex() * 5
						+ ((threeMonth.isSelected()) ? -2f : 0f) 
						+ ((sixMonth.isSelected()) ? 2f : 0f)
						+ ((oneYear.isSelected()) ? -1f : 0f)
						+ ((threeYear.isSelected()) ? 2f : 0f);
				
				float result = count*precent/100 +count; 
				
				vkladResult.setText("Итог: " + result + " рублей");
			}
		});

		frame.setVisible(true);
	}
}