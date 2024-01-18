package MyPackage.Generators;

public class DiagonalMatrix implements IMatrix {
	@Override
	public String getName() {
		return "Диагональная";
	}

	@Override
	public int getElement(int row, int column) {
		return (row == column) ? (int) Math.floor(Math.random() * 9) : 0;
	}
}
