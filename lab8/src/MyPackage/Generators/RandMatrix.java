package MyPackage.Generators;

public class RandMatrix implements IMatrix {
	@Override
	public String getName() {
		return "Случайная";
	}

	@Override
	public int getElement(int row, int column) {
		return (int) Math.floor(Math.random() * 9);
	}
}
