package lab3;

public class NAND implements IOperation {
	@Override
	public String getSign() {
		return "NAND";
	}
	
	@Override
	public String getName() {
		return "Штрих Шеффера";
	}
	
	@Override
	public int estimate(int a, int b) {
		return ~(a & b);
	}
}