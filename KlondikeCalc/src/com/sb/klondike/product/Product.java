package com.sb.klondike.product;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

import com.sb.klondike.ingredient.Ingredient;

public abstract class Product extends Ingredient {

	private final int productionTime;
	private final Map<Ingredient, Integer> ingredientCounts;

	protected Product() {
		throw new UnsupportedOperationException();
	}

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

	public static Map<Ingredient, Integer> getTotalIngredientCounts(Product p) {
		return getTotalIngredientCounts(p, 1);
	}

	public static Map<Ingredient, Integer> getTotalIngredientCounts(Product p, int quantity) {
		Map<Ingredient, Integer> totalIngredientCounts = new HashMap<>();

		Queue<Map.Entry<Ingredient, Integer>> q = new LinkedList<>();
		for (Map.Entry<Ingredient, Integer> entry : p.ingredientCounts.entrySet()) {
			q.offer(entry);
		}

		while (!q.isEmpty()) {
			Entry<Ingredient, Integer> entry = q.poll();
			Ingredient ingredient = entry.getKey();
			Integer count = entry.getValue();
			if (ingredient instanceof Product) {
				Product subProduct = (Product) ingredient;
				for (Map.Entry<Ingredient, Integer> subEntry : subProduct.getIngredientCounts().entrySet()) {
//					subEntry.setValue(value)
					Map.Entry<Ingredient, Integer> newSubEntry = Map.entry(subEntry.getKey(),
							subEntry.getValue() * count);
					q.offer(newSubEntry);
				}
			} else {
				Integer currentCount = totalIngredientCounts.getOrDefault(ingredient, 0);
				totalIngredientCounts.put(ingredient, currentCount + count);
			}
		}

		for (Map.Entry<Ingredient, Integer> e : totalIngredientCounts.entrySet()) {
			e.setValue(e.getValue() * quantity);
		}

		return Collections.unmodifiableMap(totalIngredientCounts);
	}

	public static void prettyPrintProduct(Product p) {
		prettyPrintProduct(p, 1);
	}

	public static void prettyPrintProduct(Product p, int quantity) {
		System.out.println("-*** " + p.getName() + " ***-");
		prettyPrintProduct(p, "", quantity);
		System.out.println("-***************************-");
	}

	private static void prettyPrintProduct(Product p, String prefix, int quantity) {
		System.out.print(prefix + String.format("%s => %d min; ", p.getName(), p.productionTime));
		System.out.println(p.ingredientCounts);

		for (Map.Entry<Ingredient, Integer> entry : p.ingredientCounts.entrySet()) {
			if (entry.getKey() instanceof Product) {
				prettyPrintProduct((Product) entry.getKey(), prefix + "\t", quantity);
				System.out.println(prefix + "\t" + "* " + entry.getValue() * quantity);
			} else {
				System.out
						.println(prefix + "\t" + String.format("%s * %d", entry.getKey(), entry.getValue() * quantity));
			}
		}
	}

	abstract static class Builder<T extends Builder<T>> {

		protected final Map<Ingredient, Integer> ingredientCounts = new HashMap<>();;
		protected int productionTime;

		public T setProductionTime(int productionTime) {
			this.productionTime = productionTime;
			return getThis();
		}

		public T addIngredient(Ingredient ingredient, int count) {
			ingredientCounts.put(ingredient, count);
			return getThis();
		}

		protected abstract T getThis();

		public abstract Product build();
	}
}
