package com.sb.klondike;

import java.util.HashMap;
import java.util.Map;

public class Water extends Product {

	private Water(String name, int productionTime, Map<Ingredient, Integer> ingredientCounts) {
		super(name, productionTime, ingredientCounts);
	}

	static class WaterBuilder extends ProductBuilder<Water> {

		@Override
		public Water internalBuild() {
			Map<Ingredient, Integer> ingredientCounts = new HashMap<>();
			ingredientCounts.put(new Ice(), 2);
			ingredientCounts.put(new Fire(), 1);
			return new Water("Water", 1, ingredientCounts);
		}
	}
}
