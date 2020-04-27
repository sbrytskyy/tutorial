package com.sb.klondike;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.sb.klondike.factory.Factory;
import com.sb.klondike.ingredient.Ingredient;
import com.sb.klondike.product.Product;
import com.sb.klondike.product.ProductUtil;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}

	public void printProduct(Product p) {
		printProduct(p, 1);
	}

	public void printProduct(Product p, int quantity) {
		System.out.println();
		System.out.println("----------------------------------------------------------");
		ProductUtil.prettyPrintProduct(p, quantity);
		Map<Ingredient, Integer> ingredientCounts = ProductUtil.getTotalIngredientCounts(p, quantity);
		List<String> ingredients = ingredientCounts.entrySet().stream()
				.map(entry -> String.format("%s => %d", entry.getKey().getName(), entry.getValue()))
				.collect(Collectors.toList());
		System.out.println(String.format("Basic ingredients for %d %ss are:\t%s", quantity, p.getName(),
				String.join("\t", ingredients)));

		Map<Ingredient, Integer> subProductsCounts = ProductUtil.getTotalSubProductsCounts(p, quantity);
		List<String> subproducts = subProductsCounts.entrySet().stream()
				.map(entry -> String.format("%s => %d", entry.getKey().getName(), entry.getValue()))
				.collect(Collectors.toList());
		System.out.println(String.format("Subproducts for %d %ss are:\t%s", quantity, p.getName(),
				String.join("\t", subproducts)));

		System.out.println("----------------------------------------------------------");
		System.out.println();
	}

	public void run() {
//		printProduct(Barn.water(), 2);
//		printProduct(Smithy.nails(), 2);
//		printProduct(Smithy.pipes());
//		printProduct(Smithy.chains());

//		printProduct(Factory.window(), 2);
//		printProduct(Factory.bed());

//		printProduct(Bakery.pancakes());

		printProduct(Factory.stool(), 3);

	}
}
