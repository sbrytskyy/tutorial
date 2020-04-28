package com.sb.klondike.factory;

import com.sb.klondike.ingredient.Ingedients;
import com.sb.klondike.product.Water;

public class Barn {

	public static Water water() {
		return new Water.Builder()
				.setProductionTime(1)
				.addIngredient(Ingedients.ice(), 2)
				.addIngredient(Ingedients.fire(), 1)
				.build();
	}
}
