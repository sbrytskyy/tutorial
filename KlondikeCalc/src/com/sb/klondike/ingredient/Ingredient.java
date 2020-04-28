package com.sb.klondike.ingredient;

import java.util.Map;
import java.util.Optional;

import com.sb.klondike.data.ProductionNode;

public class Ingredient implements ProductionNode {

	private final String name;

	protected Ingredient() {
		throw new UnsupportedOperationException();
	}

	public Ingredient(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean hasIngredients() {
		return false;
	}

	@Override
	public Optional<Map<ProductionNode, Integer>> getProductionNodeCounts() {
		return Optional.empty();
	}

	@Override
	public int getProductionTime() {
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingredient other = (Ingredient) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name;
	}
}
