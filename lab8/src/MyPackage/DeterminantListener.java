package MyPackage;

public class DeterminantListener extends AMatrixListener {
	private static final long serialVersionUID = 1L;
	int result;
	
	public int determinant(int[][] arr) {
		int result = 0;
		if (arr.length == 1) {
			result = arr[0][0];
			return result;
		}
		if (arr.length == 2) {
			result = arr[0][0] * arr[1][1] - arr[0][1] * arr[1][0];
			return result;
		}
		for (int i = 0; i < arr[0].length; i++) {
			int temp[][] = new int[arr.length - 1][arr[0].length - 1];

			for (int j = 1; j < arr.length; j++) {
				for (int k = 0; k < arr[0].length; k++) {

					if (k < i) {
						temp[j - 1][k] = arr[j][k];
					} else if (k > i) {
						temp[j - 1][k - 1] = arr[j][k];
					}
				}
			}
			result += arr[0][i] * Math.pow(-1, (int) i) * determinant(temp);
		}
		return result;
	}

	@Override
	protected void initialization(Matrix matrix) {
		result = 0;
	}

	@Override
	protected void step(Matrix matrix, int i, int j) {
	}

	@Override
	protected void finalization(Matrix matrix) {
		result = determinant(matrix.data);
		this.setText("DET = " + result);
	}
}
