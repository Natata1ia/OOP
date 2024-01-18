package MyPackage;

import javax.swing.JTextArea;

public abstract class AMatrixListener extends JTextArea implements IMatrixListener {
	private static final long serialVersionUID = 1L;

	@Override
	final public void matrixUpdate(Matrix matrix) {
		initialization(matrix);
		for (int i = 0; i < matrix.getHeight(); i++)
			for (int j = 0; j < matrix.getWidth(); j++)
				step(matrix, i, j);
		finalization(matrix);
	}
	
	protected abstract void initialization(Matrix matrix);
	protected abstract void step(Matrix matrix, int i, int j);
	protected abstract void finalization(Matrix matrix);
}
