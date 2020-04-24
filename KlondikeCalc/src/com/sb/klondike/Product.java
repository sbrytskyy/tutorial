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
