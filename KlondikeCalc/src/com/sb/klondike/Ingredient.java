package com.sb.klondike;

public abstract class Ingredient {
	
	private final String name;

	public Ingredient(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
