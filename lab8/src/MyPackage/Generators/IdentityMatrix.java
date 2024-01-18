package MyPackage.Generators;

public class IdentityMatrix implements IMatrix {
	@Override
	public String getName() {
		return "Единичная";
	}

	@Override
	public int getElement(int row, int column) {
		return (row == column) ? 1 : 0;
	}
}
