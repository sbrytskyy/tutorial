package com.sb.klondike;

public class SmithyFactory {

	public static Nails nails() {
		return new Nails.Builder()
				.setProductionTime(15)
				.addIngredient(new IronBar(), 3)
				.addIngredient(BarnFactory.water(), 1)
				.addIngredient(new Hammer(), 1)
				.build();
	}

}
