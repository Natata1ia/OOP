package lab3;

public class OR implements IOperation {
	@Override
	public String getSign() {
		return "OR";
	}
	
	@Override
	public String getName() {
		return "ИЛИ";
	}
	
	@Override
	public int estimate(int a, int b) {
		return a | b;
	}
}
