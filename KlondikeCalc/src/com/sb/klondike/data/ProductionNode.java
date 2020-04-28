package com.sb.klondike.data;

import java.util.Map;
import java.util.Optional;

import com.sb.klondike.ingredient.Ingredient;

public interface ProductionNode {

	public String getName();

	public boolean hasIngredients();

	public Optional<Map<Ingredient, Integer>> getIngredientCounts();

	public int getProductionTime();
}
