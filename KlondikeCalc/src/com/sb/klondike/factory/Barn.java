package com.sb.klondike.factory;

import com.sb.klondike.ingredient.Fire;
import com.sb.klondike.ingredient.Ice;
import com.sb.klondike.product.Water;

public class Barn {

	public static Water water() {
		return new Water.Builder()
				.setProductionTime(1)
				.addIngredient(new Ice(), 2)
				.addIngredient(new Fire(), 1)
				.build();
	}
}
