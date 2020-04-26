package com.sb.klondike;

import com.sb.klondike.factory.Barn;
import com.sb.klondike.factory.Smithy;
import com.sb.klondike.product.Chains;
import com.sb.klondike.product.Nails;
import com.sb.klondike.product.Pipes;
import com.sb.klondike.product.Product;
import com.sb.klondike.product.Water;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}

	private void run() {
		Water p1 = Barn.water();
		Product.prettyPrintProduct(p1);
		System.out.println("Basic ingredients: " + Product.getTotalIngredientCounts(p1));

		System.out.println();

		Nails p2 = Smithy.nails();
		Product.prettyPrintProduct(p2);
		System.out.println("Basic ingredients: " + Product.getTotalIngredientCounts(p2));

		System.out.println();

		Pipes p3 = Smithy.pipes();
		Product.prettyPrintProduct(p3);
		System.out.println("Basic ingredients: " + Product.getTotalIngredientCounts(p3));

		System.out.println();

		Chains p4 = Smithy.chains();
		Product.prettyPrintProduct(p4);
		System.out.println("Basic ingredients: " + Product.getTotalIngredientCounts(p4));
	}
}
