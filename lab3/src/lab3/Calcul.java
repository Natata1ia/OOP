package lab3;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class Calcul {
	
	public static void main(String[] args) {
	
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(400, 100);
		frame.setTitle("Calculator");		
		frame.setLayout(new FlowLayout());
		
		IOperation operations[] = new IOperation[4];
		operations[0] = new AND();
		operations[1] = new OR();
		operations[2] = new XOR();
		operations[3] = new NAND();
		
		JTextField operandA = new JTextField("0", 5);
		JTextField operandB = new JTextField("0", 5);
		JTextField resultText = new JTextField("0", 5);
		JLabel resultLabel = new JLabel("");
		JButton calculate = new JButton("=");
		JComboBox<String> operation = new JComboBox<String>();
		
		for (IOperation op : operations) operation.addItem(op.getSign());
	
		frame.add(operandA);
		frame.add(operation);
		frame.add(operandB);
		frame.add(calculate);
		frame.add(resultText);
		frame.add(resultLabel);
		
	
		calculate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int result = operations[operation.getSelectedIndex()]
						.estimate(
								Integer.parseInt(operandA.getText()), 
								Integer.parseInt(operandB.getText())
						);
				resultLabel.setText(operandA.getText() + " " + 
						operations[operation.getSelectedIndex()].getName() + 
						" " + operandB.getText() + " получится " + Integer.toString(result));
				
				resultText.setText(Integer.toString(result));
			}
		});
		
		frame.setVisible(true);
	}
}
