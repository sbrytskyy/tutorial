package com.sb.klondike;

import com.sb.klondike.factory.Barn;
import com.sb.klondike.factory.Factory;
import com.sb.klondike.factory.Smithy;
import com.sb.klondike.product.Product;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}

	private void printProduct(Product p) {
		printProduct(p, 1);
	}

	private void printProduct(Product p, int quantity) {
		System.out.println();
		System.out.println("----------------------------------------------------------");
		Product.prettyPrintProduct(p);
		System.out.println(String.format("Basic ingredients for %d %ss are: %s", quantity, p.getName(),
				Product.getTotalIngredientCounts(p, quantity)));
		System.out.println("----------------------------------------------------------");
		System.out.println();
	}

	private void run() {
		printProduct(Barn.water(), 2);
//		printProduct(Smithy.nails(), 2);
//		printProduct(Smithy.pipes());
		printProduct(Smithy.chains());

		printProduct(Factory.window(), 2);
		printProduct(Factory.bed());

//		printProduct(Bakery.pancakes());
	}
}
