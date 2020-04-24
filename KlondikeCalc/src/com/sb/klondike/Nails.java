package com.sb.klondike;

import java.util.HashMap;
import java.util.Map;

public final class Nails extends Product {

	private Nails(String name, int productionTime, Map<Ingredient, Integer> ingredientCounts) {
		super(name, productionTime, ingredientCounts);
	}

	public static class NailsBuilder extends ProductBuilder<Nails> {

		@Override
		public Nails internalBuild() {
			Map<Ingredient, Integer> ingredientCounts = new HashMap<>();
			ingredientCounts.put(new IronBar(), 3);
			ingredientCounts.put(BarnFactory.water(), 1);
			ingredientCounts.put(new Hammer(), 1);
			return new Nails("Nails", 15, ingredientCounts);
		}
	}
}
