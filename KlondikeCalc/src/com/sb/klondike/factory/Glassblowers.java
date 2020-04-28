package com.sb.klondike.factory;

import com.sb.klondike.ingredient.Ingedients;
import com.sb.klondike.product.Glass;
import com.sb.klondike.product.Jar;
import com.sb.klondike.product.WindowGlass;

public class Glassblowers {

	public static Glass glass() {
		return new Glass.Builder()
				.setProductionTime(20)
				.addIngredient(Quarry.quartzSand(), 1)
				.addIngredient(Ingedients.fire(), 2)
				.build();
	}

	public static WindowGlass windowGlass() {
		return new WindowGlass.Builder()
				.setProductionTime(30)
				.addIngredient(glass(), 3)
				.addIngredient(Smithy.pipes(), 1)
				.build();
	}

	public static Jar jar() {
		return new Jar.Builder()
				.setProductionTime(60)
				.addIngredient(glass(), 2)
				.addIngredient(Smithy.pipes(), 1)
				.build();
	}
}
