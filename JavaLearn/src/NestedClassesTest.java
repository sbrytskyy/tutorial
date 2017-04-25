
public class NestedClassesTest {
	public static void main(String args[]) {
		Outer.NestedStaticDemo nested1 = new Outer.NestedStaticDemo();
		nested1.my_method();
		
		Outer.NestedStaticDemo nested2 = new Outer.NestedStaticDemo();

		System.out.println(nested1 == nested2);
		
		Outer o = new Outer();
	}
}
