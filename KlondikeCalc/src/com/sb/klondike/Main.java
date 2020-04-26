package com.sb.klondike;

import com.sb.klondike.factory.Bakery;
import com.sb.klondike.factory.Factory;
import com.sb.klondike.product.Product;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}

	private void printProduct(Product p) {
		System.out.println();
		System.out.println("----------------------------------------------------------");
		Product.prettyPrintProduct(p);
		System.out.println("Basic ingredients: " + Product.getTotalIngredientCounts(p));
		System.out.println("----------------------------------------------------------");
		System.out.println();
	}

	private void run() {
//		printProduct(Barn.water());
//		printProduct(Smithy.nails());
//		printProduct(Smithy.pipes());
//		printProduct(Smithy.chains());

		printProduct(Factory.window());
		printProduct(Factory.bed());

		printProduct(Bakery.pancakes());
	}
}
