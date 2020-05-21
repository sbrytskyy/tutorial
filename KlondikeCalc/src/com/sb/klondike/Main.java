package com.sb.klondike;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.sb.klondike.data.FactoryType;
import com.sb.klondike.data.ProductionNode;
import com.sb.klondike.factory.PackingHouse;
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
		Map<ProductionNode, Integer> ingredientCounts = ProductUtil.getTotalIngredientCounts(p, quantity);
		List<String> ingredients = ingredientCounts.entrySet().stream()
				.map(entry -> String.format("%s => %d", entry.getKey().getName(), entry.getValue()))
				.collect(Collectors.toList());
		System.out.println(String.format("Basic ingredients for %d %ss are:\t%s", quantity, p.getName(),
				String.join("\t", ingredients)));

		Map<ProductionNode, Integer> subProductsCounts = ProductUtil.getTotalSubProductsCounts(p, quantity);
		List<String> subproducts = subProductsCounts.entrySet().stream()
				.map(entry -> String.format("%s => %d", entry.getKey().getName(), entry.getValue()))
				.collect(Collectors.toList());
		System.out.println(String.format("Subproducts for %d %ss are:\t%s", quantity, p.getName(),
				String.join("\t", subproducts)));

		Map<FactoryType, Integer> productionTime = ProductUtil.getProductionTime(p, quantity);
		List<String> times = productionTime.entrySet().stream()
				.map(entry -> String.format("%s => '%d hrs %d min'", entry.getKey(), entry.getValue() / 60,
						entry.getValue() % 60))
				.collect(Collectors.toList());
		System.out.println(String.format("Production Time for %d %ss are:\t%s", quantity, p.getName(),
				String.join("\t", times)));

		System.out.println("----------------------------------------------------------");
		System.out.println();
	}

	public void run() {
//		printProduct(Barn.water(), 2);

//		printProduct(Sawmill.beam(), 3);

//		printProduct(Smithy.nails(), 2);
//		printProduct(Smithy.chains());
//		printProduct(Smithy.pipes(), 3);

//		printProduct(Dairy.cheese(), 3);
//		printProduct(Dairy.curdCheese(), 2);
//		printProduct(Dairy.yoghurt(), 3);

//		printProduct(Bakery.berryCake(), 2);
//		printProduct(Bakery.pancakes());
//		printProduct(Bakery.pumpkinCheesecake(), 3);

//		printProduct(Pottery.bricks(), 3);
//		printProduct(Pottery.tile());

//		printProduct(Factory.stool());
//		printProduct(Factory.bed());
//		printProduct(Factory.window(), 5);

		printProduct(PackingHouse.cannedPumpkins(), 3);
	}
}
