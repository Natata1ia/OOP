package MyPackage.Generators;

public class TriangleTopMatrix implements IMatrix {
	@Override
	public String getName() {
		return "Треугольная(сверху)";
	}

	@Override
	public int getElement(int row, int column) {
		return (row <= column) ? (int) Math.floor(Math.random() * 9) : 0;
	}
}
