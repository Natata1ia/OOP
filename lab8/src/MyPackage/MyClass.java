package MyPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import MyPackage.Generators.DiagonalMatrix;
import MyPackage.Generators.IMatrix;
import MyPackage.Generators.IdentityMatrix;
import MyPackage.Generators.RandMatrix;
import MyPackage.Generators.TriangleBottomMatrix;
import MyPackage.Generators.TriangleTopMatrix;
import MyPackage.Generators.ZeroMatrix;

public class MyClass {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(250, 450);
		frame.setTitle("Матрицы");
		frame.setLayout(new BorderLayout());
		
		Font font = new Font("Arial", Font.BOLD, 17);
		
		Matrix mymatrix = new Matrix(10, 10);
		
		IMatrix[] generators = { 
				new DiagonalMatrix(),
				new IdentityMatrix(),
				new RandMatrix(),
				new ZeroMatrix(),
				new TriangleBottomMatrix(),
				new TriangleTopMatrix()
		};
		
		AMatrixListener[] matrixListeners = {
				new MatrixListener(),
				new MaxListener(),
				new SumListener(),
				new TraceListener(),
				new DeterminantListener()
		};
		
		JComboBox<String> matrixChooser = new JComboBox<String>();
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 25));
		matrixChooser.setFont(font);
		
		for (AMatrixListener matrix : matrixListeners) {
			matrix.setFont(font);
			panel.add(matrix);
		}
		
		for (IMatrix matrix : generators) matrixChooser.addItem(matrix.getName());
		
		frame.add(matrixChooser, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);

		matrixChooser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mymatrix.setGenerator(generators[matrixChooser.getSelectedIndex()]);
				mymatrix.update();
				for (AMatrixListener matrix : matrixListeners)
					matrix.matrixUpdate(mymatrix);
			}
		});
		
		frame.setVisible(true);
	}
}
