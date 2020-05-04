package com.sb.klondike.product;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Queue;

import com.sb.klondike.data.FactoryType;
import com.sb.klondike.data.ProductionNode;

public class ProductUtil {

	public static Map<ProductionNode, Integer> getTotalIngredientCounts(Product p) {
		return getTotalIngredientCounts(p, 1);
	}

	public static Map<ProductionNode, Integer> getTotalIngredientCounts(Product p, int quantity) {
		Map<ProductionNode, Integer> totalIngredientCounts = new HashMap<>();

		Queue<Map.Entry<ProductionNode, Integer>> q = new LinkedList<>();
		Optional<Map<ProductionNode, Integer>> optionalMap = p.getProductionNodeCounts();
		if (optionalMap.isPresent()) {

			for (Map.Entry<ProductionNode, Integer> entry : optionalMap.get().entrySet()) {
				q.offer(entry);
			}

			while (!q.isEmpty()) {
				Entry<ProductionNode, Integer> entry = q.poll();
				ProductionNode ingredient = entry.getKey();
				Integer count = entry.getValue();
				if (ingredient.hasIngredients()) {
					optionalMap = ingredient.getProductionNodeCounts();
					if (optionalMap.isPresent()) {
						for (Map.Entry<ProductionNode, Integer> subEntry : optionalMap.get().entrySet()) {
							Map.Entry<ProductionNode, Integer> newSubEntry = Map.entry(subEntry.getKey(),
									subEntry.getValue() * count);
							q.offer(newSubEntry);
						}
					}
				} else {
					Integer currentCount = totalIngredientCounts.getOrDefault(ingredient, 0);
					totalIngredientCounts.put(ingredient, currentCount + count);
				}
			}

			for (Map.Entry<ProductionNode, Integer> e : totalIngredientCounts.entrySet()) {
				e.setValue(e.getValue() * quantity);
			}
		}

		return Collections.unmodifiableMap(totalIngredientCounts);
	}

	public static Map<ProductionNode, Integer> getTotalSubProductsCounts(Product p) {
		return getTotalSubProductsCounts(p, 1);
	}

	public static Map<ProductionNode, Integer> getTotalSubProductsCounts(Product p, int quantity) {
		Map<ProductionNode, Integer> totalIngredientCounts = new HashMap<>();

		Queue<Map.Entry<ProductionNode, Integer>> q = new LinkedList<>();
		Optional<Map<ProductionNode, Integer>> optionalMap = p.getProductionNodeCounts();
		if (optionalMap.isPresent()) {
			for (Map.Entry<ProductionNode, Integer> entry : optionalMap.get().entrySet()) {
				q.offer(entry);
			}

			while (!q.isEmpty()) {
				Entry<ProductionNode, Integer> entry = q.poll();
				ProductionNode ingredient = entry.getKey();
				Integer count = entry.getValue();
				if (ingredient instanceof Product) {
					Integer currentCount = totalIngredientCounts.getOrDefault(ingredient, 0);
					totalIngredientCounts.put(ingredient, currentCount + count);

					Product subProduct = (Product) ingredient;
					optionalMap = subProduct.getProductionNodeCounts();
					if (optionalMap.isPresent()) {
						for (Map.Entry<ProductionNode, Integer> subEntry : optionalMap.get().entrySet()) {
							Map.Entry<ProductionNode, Integer> newSubEntry = Map.entry(subEntry.getKey(),
									subEntry.getValue() * count);
							q.offer(newSubEntry);
						}
					}
				}
			}

			for (Map.Entry<ProductionNode, Integer> e : totalIngredientCounts.entrySet()) {
				e.setValue(e.getValue() * quantity);
			}
		}

		return Collections.unmodifiableMap(totalIngredientCounts);
	}

	public static Map<FactoryType, Integer> getProductionTime(Product p) {
		return getProductionTime(p, 1);
	}

	public static Map<FactoryType, Integer> getProductionTime(Product p, int quantity) {
		Map<FactoryType, Integer> totalTime = new HashMap<>();

		totalTime.put(p.getFactoryType(), p.getProductionTime() * quantity);

		Map<ProductionNode, Integer> map = getTotalSubProductsCounts(p, quantity);
		for (Map.Entry<ProductionNode, Integer> entry : map.entrySet()) {
			ProductionNode ingredient = entry.getKey();
			Integer count = entry.getValue();
			if (ingredient instanceof Product) {
				Product product = (Product) ingredient;
				Integer currentTime = totalTime.getOrDefault(product.getFactoryType(), 0);
				totalTime.put(product.getFactoryType(), currentTime + product.getProductionTime() * count);
			}
		}

		return Collections.unmodifiableMap(totalTime);
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

		Optional<Map<ProductionNode, Integer>> optionalMap = p.getProductionNodeCounts();
		if (optionalMap.isPresent()) {
			for (Map.Entry<ProductionNode, Integer> entry : optionalMap.get().entrySet()) {
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
