package MyPackage;

public class MaxListener extends AMatrixListener {
	private static final long serialVersionUID = 1L;
	int max;

	@Override
	protected void initialization(Matrix matrix) {
		max = matrix.getElement(0, 0);
	}

	@Override
	protected void step(Matrix matrix, int i, int j) {
		if (max < matrix.getElement(i, j)) max = matrix.getElement(i, j);
	}

	@Override
	protected void finalization(Matrix matrix) {
		this.setText("MAX = " + max);
	}
}
