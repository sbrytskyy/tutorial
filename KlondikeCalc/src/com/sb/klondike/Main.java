package com.sb.klondike;

import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}

	private void run() {
		Water p1 = BarnFactory.water();
		System.out.println(p1);

//		System.out.println(String.format("%s -> %d min", p1.getName(), p1.getProductionTime()));
//
//		Map<Ingredient, Integer> ingredientCounts1 = p1.getIngredientCounts();
//		System.out.println("\t" + ingredientCounts1);

		Nails p2 = SmithyFactory.nails();
		System.out.println(p2);

		//		System.out.println(String.format("%s -> %d min", p2.getName(), p2.getProductionTime()));
//
//		Map<Ingredient, Integer> ingredientCounts2 = p2.getIngredientCounts();
//		System.out.println("\t" + ingredientCounts2);
	}
}
