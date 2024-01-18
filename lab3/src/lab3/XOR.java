package lab3;

public class XOR implements IOperation {
	@Override
	public String getSign() {
		return "XOR";
	}
	
	@Override
	public String getName() {
		return "Исключающее ИЛИ";
	}
	
	@Override
	public int estimate(int a, int b) {
		return a ^ b;
	}
}