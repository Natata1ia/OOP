package lab6;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Animation {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setTitle("Анимация");
		frame.setLayout(new GridLayout());
		

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		frame.add(panel);
		
		frame.setVisible(true);
		
		Ball ball1 = new Ball(panel, 60, 60, 3f, 6f, 30);
		ball1.setColor(Color.GREEN);
		Ball ball2 = new Ball(panel, 50, 100, 3f, -9f, 20);
		Ball ball3 = new Ball(panel, 200, 150, -8f, -10f, 60);
		ball3.setColor(Color.RED);
		
		ball1.start();
		ball2.start();
		ball3.start();
	}
}
