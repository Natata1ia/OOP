package MyPackage;

public class SumListener extends AMatrixListener {
	private static final long serialVersionUID = 1L;
	int sum;

	@Override
	protected void initialization(Matrix matrix) {
		sum = 0;
	}

	@Override
	protected void step(Matrix matrix, int i, int j) {
		sum += matrix.getElement(i, j);
	}

	@Override
	protected void finalization(Matrix matrix) {
		this.setText("SUM = " + sum);
	}
}
