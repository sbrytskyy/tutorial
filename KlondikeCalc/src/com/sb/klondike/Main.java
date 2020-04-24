package com.sb.klondike;

import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}

	private void run() {
		Water p = Water.water();

		System.out.println(String.format("%s -> %d min", p.getName(), p.getProductionTime()));

		Map<Ingredient, Integer> ingredientCounts = p.getIngredientCounts();
		System.out.println("\t" + ingredientCounts);
	}
}
