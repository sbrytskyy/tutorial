package com.sb.klondike.factory;

import com.sb.klondike.ingredient.Ingedients;
import com.sb.klondike.product.Chains;
import com.sb.klondike.product.Nails;
import com.sb.klondike.product.Pipes;

public class Smithy {

	public static Nails nails() {
		return new Nails.Builder()
				.setProductionTime(15)
				.addIngredient(Ingedients.ironBar(), 3)
				.addIngredient(Barn.water(), 1)
				.addIngredient(Ingedients.hammer(), 1)
				.build();
	}

	public static Pipes pipes() {
		return new Pipes.Builder()
				.setProductionTime(30)
				.addIngredient(Ingedients.ironBar(), 5)
				.addIngredient(Barn.water(), 3)
				.addIngredient(Ingedients.hammer(), 1)
				.build();
	}

	public static Chains chains() {
		return new Chains.Builder()
				.setProductionTime(60)
				.addIngredient(Ingedients.ironBar(), 3)
				.addIngredient(pipes(), 1)
				.addIngredient(Sawmill.woodVeneer(), 2)
				.build();
	}

}
