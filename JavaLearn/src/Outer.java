
public class Outer {
	
	private static int si = 1000;
	private int i = 5000;
	
	class NestedDemo {
		
		public NestedDemo() {
			System.out.println("NestedDemo: CTOR");
		}
		
		public void my_method() {
			System.out.println("This is my nested class: " + i);
		}
	}
	
	protected static class NestedStaticDemo {
		
		public NestedStaticDemo() {
			System.out.println("NestedStaticDemo: CTOR");
		}
		
		public void my_method() {
			System.out.println("This is my static nested class: " + si);
		}
	}
	
	public Outer() {
		NestedDemo nestedDemo = new NestedDemo();
	}
}