package MyPackage.Generators;

public class ZeroMatrix implements IMatrix {
	@Override
	public String getName() {
		return "Нулевая";
	}

	@Override
	public int getElement(int row, int column) {
		return 0;
	}
}
