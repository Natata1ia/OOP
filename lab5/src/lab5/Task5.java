package lab5;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;


public class Task5 {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(400, 70);
		frame.setTitle("Массив");
		frame.setLayout(new GridLayout(1, 0, 10, 10));
		
		JLabel label1 = new JLabel("Array at ");
		label1.setHorizontalAlignment(JLabel.RIGHT);
		JTextField index = new JTextField("0", 2);
		JLabel label2 = new JLabel(" is -");

		frame.add(label1);
		frame.add(index);
		frame.add(label2);
		
		index.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				try {
					if (index.getText().length() != 0) {
						label2.setText(" is " + Integer.toString(MyArray.array[Integer.parseInt(index.getText())]));
					}
				} catch (ArrayIndexOutOfBoundsException exeption) {
					label2.setText("NO SUCH INDEX");
				} catch (Exception bad_exception) {
					label2.setText("VERY BAD INDEX");
				}
			}
		});

		frame.setVisible(true);
	}
}
