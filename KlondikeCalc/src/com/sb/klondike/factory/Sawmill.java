package com.sb.klondike.factory;

import com.sb.klondike.ingredient.DryTwigs;
import com.sb.klondike.ingredient.SequoiaLogs;
import com.sb.klondike.product.WoodVeneer;

public class Sawmill {

	public static WoodVeneer woodVeneer() {
		return new WoodVeneer.Builder()
				.setProductionTime(3)
				.addIngredient(new SequoiaLogs(), 5)
				.addIngredient(new DryTwigs(), 10)
				.build();
	}
}
