package com.sb.klondike;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}

	private void run() {
		Water p1 = BarnFactory.water();
		Product.prettyPrintProduct(p1);
		System.out.println("Basic ingredients: " + Product.getTotalIngredientCounts(p1));

		System.out.println();

		Nails p2 = SmithyFactory.nails();
		Product.prettyPrintProduct(p2);
		System.out.println("Basic ingredients: " + Product.getTotalIngredientCounts(p2));

		System.out.println();

		Pipes p3 = SmithyFactory.pipes();
		Product.prettyPrintProduct(p3);
		System.out.println("Basic ingredients: " + Product.getTotalIngredientCounts(p3));

		System.out.println();

		Chains p4 = SmithyFactory.chains();
		Product.prettyPrintProduct(p4);
		System.out.println("Basic ingredients: " + Product.getTotalIngredientCounts(p4));
	}
}
