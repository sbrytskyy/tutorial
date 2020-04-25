package com.sb.klondike;

public class BarnFactory {

	public static Water water() {
		return new Water.Builder()
				.setProductionTime(1)
				.addIngredient(new Ice(), 2)
				.addIngredient(new Fire(), 1)
				.build();
	}
}
