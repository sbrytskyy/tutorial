package com.sb.klondike;

import com.sb.klondike.factory.Barn;
import com.sb.klondike.factory.Smithy;
import com.sb.klondike.product.Product;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}

	private void run() {
		printProduct(Barn.water());
		printProduct(Smithy.nails());
		printProduct(Smithy.pipes());
		printProduct(Smithy.chains());
	}

	private void printProduct(Product p) {
		System.out.println();
		Product.prettyPrintProduct(p);
		System.out.println("Basic ingredients: " + Product.getTotalIngredientCounts(p));
		System.out.println();
	}
}
