package com.sb.klondike;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class Product extends Ingredient {

	private final int productionTime;
	private final Map<Ingredient, Integer> ingredientCounts;

	Product(String name, Builder<?> builder) {
		super(name);
		this.productionTime = builder.productionTime;
		this.ingredientCounts = Collections.unmodifiableMap(builder.ingredientCounts);
	}

	public int getProductionTime() {
		return productionTime;
	}

	public Map<Ingredient, Integer> getIngredientCounts() {
		return ingredientCounts;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%s => %d min, ", getName(), productionTime));
		sb.append(ingredientCounts);
		return sb.toString();
	}

	public static void prettyPrintProduct(Product p) {
		System.out.println("-*** PrettyPrintProduct ***-");
		prettyPrintProduct(p, "");
		System.out.println("-*** PrettyPrintProduct ***-");
	}

	private static void prettyPrintProduct(Product p, String prefix) {
		System.out.print(prefix + String.format("%s => %d min; ", p.getName(), p.productionTime));
		System.out.println(p.ingredientCounts);

		for (Map.Entry<Ingredient, Integer> entry : p.ingredientCounts.entrySet()) {
			if (entry.getKey() instanceof Product) {
				prettyPrintProduct((Product) entry.getKey(), prefix + "\t");
			} else {
				System.out.println(prefix + "\t" + String.format("%s => %d", entry.getKey(), entry.getValue()));
			}
		}
	}

	abstract static class Builder<T extends Builder<T>> {

		protected final Map<Ingredient, Integer> ingredientCounts = new HashMap<>();;
		protected int productionTime;

		T setProductionTime(int productionTime) {
			this.productionTime = productionTime;
			return getThis();
		}

		T addIngredient(Ingredient ingredient, int count) {
			ingredientCounts.put(ingredient, count);
			return getThis();
		}

		protected abstract T getThis();

		abstract Product build();
	}
}
