package lab3;

public class AND implements IOperation {
	@Override
	public String getSign() {
		return "AND";
	}
	
	@Override
	public String getName() {
		return "И";
	}
	
	@Override
	public int estimate(int a, int b) {
		return a & b;
	}
}
