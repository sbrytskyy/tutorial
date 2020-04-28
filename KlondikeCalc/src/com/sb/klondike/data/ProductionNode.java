package com.sb.klondike.data;

import java.util.Map;
import java.util.Optional;

public interface ProductionNode {

	public String getName();

	public boolean hasIngredients();

	public Optional<Map<ProductionNode, Integer>> getProductionNodeCounts();

	public int getProductionTime();
}
