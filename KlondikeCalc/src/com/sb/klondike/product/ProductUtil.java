package com.sb.klondike.product;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Queue;

import com.sb.klondike.ingredient.Ingredient;

public class ProductUtil {

	public static Map<Ingredient, Integer> getTotalIngredientCounts(Product p) {
		return getTotalIngredientCounts(p, 1);
	}

	public static Map<Ingredient, Integer> getTotalIngredientCounts(Product p, int quantity) {
		Map<Ingredient, Integer> totalIngredientCounts = new HashMap<>();

		Queue<Map.Entry<Ingredient, Integer>> q = new LinkedList<>();
		Optional<Map<Ingredient, Integer>> optionalMap = p.getIngredientCounts();
		if (optionalMap.isPresent()) {

			for (Map.Entry<Ingredient, Integer> entry : optionalMap.get().entrySet()) {
				q.offer(entry);
			}

			while (!q.isEmpty()) {
				Entry<Ingredient, Integer> entry = q.poll();
				Ingredient ingredient = entry.getKey();
				Integer count = entry.getValue();
				if (ingredient.hasIngredients()) {
					optionalMap = ingredient.getIngredientCounts();
					if (optionalMap.isPresent()) {
						for (Map.Entry<Ingredient, Integer> subEntry : optionalMap.get().entrySet()) {
							Map.Entry<Ingredient, Integer> newSubEntry = Map.entry(subEntry.getKey(),
									subEntry.getValue() * count);
							q.offer(newSubEntry);
						}
					}
				} else {
					Integer currentCount = totalIngredientCounts.getOrDefault(ingredient, 0);
					totalIngredientCounts.put(ingredient, currentCount + count);
				}
			}

			for (Map.Entry<Ingredient, Integer> e : totalIngredientCounts.entrySet()) {
				e.setValue(e.getValue() * quantity);
			}
		}

		return Collections.unmodifiableMap(totalIngredientCounts);
	}

	public static Map<Ingredient, Integer> getTotalSubProductsCounts(Product p) {
		return getTotalSubProductsCounts(p, 1);
	}

	public static Map<Ingredient, Integer> getTotalSubProductsCounts(Product p, int quantity) {
		Map<Ingredient, Integer> totalIngredientCounts = new HashMap<>();

		Queue<Map.Entry<Ingredient, Integer>> q = new LinkedList<>();
		Optional<Map<Ingredient, Integer>> optionalMap = p.getIngredientCounts();
		if (optionalMap.isPresent()) {
			for (Map.Entry<Ingredient, Integer> entry : optionalMap.get().entrySet()) {
				q.offer(entry);
			}

			while (!q.isEmpty()) {
				Entry<Ingredient, Integer> entry = q.poll();
				Ingredient ingredient = entry.getKey();
				Integer count = entry.getValue();
				if (ingredient instanceof Product) {
					Integer currentCount = totalIngredientCounts.getOrDefault(ingredient, 0);
					totalIngredientCounts.put(ingredient, currentCount + count);

					Product subProduct = (Product) ingredient;
					optionalMap = subProduct.getIngredientCounts();
					if (optionalMap.isPresent()) {
						for (Map.Entry<Ingredient, Integer> subEntry : optionalMap.get().entrySet()) {
							Map.Entry<Ingredient, Integer> newSubEntry = Map.entry(subEntry.getKey(),
									subEntry.getValue() * count);
							q.offer(newSubEntry);
						}
					}
				}
			}

			for (Map.Entry<Ingredient, Integer> e : totalIngredientCounts.entrySet()) {
				e.setValue(e.getValue() * quantity);
			}
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
		System.out.print(prefix + String.format("%s => %d min; ", p.getName(), p.getProductionTime()));
//		System.out.println(p.ingredientCounts);
		System.out.println();

		Optional<Map<Ingredient, Integer>> optionalMap = p.getIngredientCounts();
		if (optionalMap.isPresent()) {
			for (Map.Entry<Ingredient, Integer> entry : optionalMap.get().entrySet()) {
				if (entry.getKey() instanceof Product) {
					prettyPrintProduct((Product) entry.getKey(), prefix + "\t", entry.getValue() * quantity);
					System.out.println(prefix + "\t" + "* " + entry.getValue() * quantity);
				} else {
					System.out
							.println(prefix + "\t"
									+ String.format("%s * %d", entry.getKey(), entry.getValue() * quantity));
				}
			}
		}
	}
}
