package com.sb.klondike.product;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.sb.klondike.data.FactoryType;
import com.sb.klondike.data.ProductionNode;
import com.sb.klondike.ingredient.Ingredient;

public abstract class Product extends Ingredient {

	private final int productionTime;
	private final Map<ProductionNode, Integer> ingredientCounts;
	private final FactoryType factoryType;

	protected Product() {
		this.factoryType = null;
		throw new UnsupportedOperationException();
	}

	Product(String name, Builder<?> builder) {
		super(name);
		this.productionTime = builder.productionTime;
		this.ingredientCounts = Collections.unmodifiableMap(builder.ingredientCounts);
		this.factoryType = builder.factoryType;
	}

	@Override
	public int getProductionTime() {
		return productionTime;
	}

	@Override
	public boolean hasIngredients() {
		return true;
	}

	@Override
	public Optional<Map<ProductionNode, Integer>> getProductionNodeCounts() {
		return Optional.of(ingredientCounts);
	}

	public FactoryType getFactoryType() {
		return factoryType;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%s => %d min, ", getName(), productionTime));
		sb.append(ingredientCounts);
		return sb.toString();
	}

	abstract static class Builder<T extends Builder<T>> {

		protected final Map<Ingredient, Integer> ingredientCounts = new HashMap<>();;
		protected int productionTime;
		protected FactoryType factoryType;

		public T setProductionTime(int productionTime) {
			this.productionTime = productionTime;
			return getThis();
		}

		public T addIngredient(Ingredient ingredient, int count) {
			ingredientCounts.put(ingredient, count);
			return getThis();
		}

		public T setFactoryType(FactoryType factoryType) {
			this.factoryType = factoryType;
			return getThis();
		}

		protected abstract T getThis();

		public abstract Product build();
	}
}
