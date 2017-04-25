
public class Calculator {

	interface IntegerMath {
		int operation(int a, int b);
	}
	
	public int operate(int a, int b, IntegerMath op) {
		return op.operation(a, b);
	}
	
	public static void main(String[] args) {
		IntegerMath add = (a, b) -> a + b;
		IntegerMath sub = (a, b) -> a - b;
		
		Calculator calc = new Calculator();
		
		System.out.println(calc.operate(3, 2, add));
		System.out.println(calc.operate(7, 4, sub));
	}
}
