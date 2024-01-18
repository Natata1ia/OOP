package MyPackage;

public class TraceListener extends AMatrixListener {
	private static final long serialVersionUID = 1L;
	int trace;

	@Override
	protected void initialization(Matrix matrix) {
		trace = 0;
	}

	@Override
	protected void step(Matrix matrix, int i, int j) {
		if (i == j) trace += matrix.getElement(i, j);
	}

	@Override
	protected void finalization(Matrix matrix) {
		this.setText("TRACE = " + trace);
	}
}
