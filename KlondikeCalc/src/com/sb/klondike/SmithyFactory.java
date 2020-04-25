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

	public static Pipes pipes() {
		return new Pipes.Builder()
				.setProductionTime(30)
				.addIngredient(new IronBar(), 5)
				.addIngredient(BarnFactory.water(), 3)
				.addIngredient(new Hammer(), 1)
				.build();
	}

	public static Chains chains() {
		return new Chains.Builder()
				.setProductionTime(60)
				.addIngredient(new IronBar(), 3)
				.addIngredient(pipes(), 1)
//				.addIngredient(Wood Veneer(), 2)
				.build();
	}

}
