package MyPackage;

public class MatrixListener extends AMatrixListener {
	private static final long serialVersionUID = 1L;
	String text;

	@Override
	protected void initialization(Matrix matrix) {
		text = "";
	}

	@Override
	protected void step(Matrix matrix, int i, int j) {
		if (i > 0 && j == 0) text += "\n";
		if (j > 0) text += " ";
		text += matrix.getElement(i, j);
	}

	@Override
	protected void finalization(Matrix matrix) {
		this.setText(text);
	}
}
