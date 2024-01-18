package MyPackage.Generators;

public class TriangleBottomMatrix implements IMatrix {
	@Override
	public String getName() {
		return "Треугольная(снизу)";
	}

	@Override
	public int getElement(int row, int column) {
		return (row >= column) ? (int) Math.floor(Math.random() * 9) : 0;
	}
}
