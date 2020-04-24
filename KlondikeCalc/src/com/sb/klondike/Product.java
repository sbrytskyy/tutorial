package com.sb.klondike;

import java.util.Collections;
import java.util.Map;

public abstract class Product extends Ingredient {

	private final int productionTime;
	private final Map<Ingredient, Integer> ingredientCounts;

	public Product(String name, int productionTime, Map<Ingredient, Integer> ingredientCounts) {
		super(name);
		this.productionTime = productionTime;
		this.ingredientCounts = ingredientCounts;
	}

	public int getProductionTime() {
		return productionTime;
	}

	public Map<Ingredient, Integer> getIngredientCounts() {
		return Collections.unmodifiableMap(ingredientCounts);
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

	public static void prettyPrintProduct(Product p) {
		System.out.println("-*** PrettyPrintProduct ***-");
		prettyPrintProduct(p, "");
		System.out.println("-*** PrettyPrintProduct ***-");
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%s => %d min, ", getName(), productionTime));
		sb.append(ingredientCounts);
		return sb.toString();
	}

	public abstract static class ProductBuilder<T extends Product> {

		protected String name;
		protected Map<Ingredient, Integer> ingredientCounts;
		protected int productionTime;

		public ProductBuilder<T> setName(String name) {
			this.name = name;
			return this;
		}

		public ProductBuilder<T> setProductionTime(int productionTime) {
			this.productionTime = productionTime;
			return this;
		}

		public ProductBuilder<T> addIngredients(Map<Ingredient, Integer> ingredientCounts) {
			this.ingredientCounts = ingredientCounts;
			return this;
		}

		public T build() {
			return internalBuild();
		}

		protected abstract T internalBuild();
	}
}
