package com.sb.klondike.factory;

import com.sb.klondike.ingredient.Clay;
import com.sb.klondike.ingredient.Quartz;
import com.sb.klondike.ingredient.Stones;
import com.sb.klondike.product.Cement;
import com.sb.klondike.product.Gravel;
import com.sb.klondike.product.QuartzSand;

public class Quarry {

	public static Gravel gravel() {
		return new Gravel.Builder()
				.setProductionTime(3)
				.addIngredient(new Stones(), 5)
				.build();
	}

	public static QuartzSand quartzSand() {
		return new QuartzSand.Builder()
				.setProductionTime(10)
				.addIngredient(new Quartz(), 5)
				.build();
	}

	public static Cement cement() {
		return new Cement.Builder()
				.setProductionTime(10)
				.addIngredient(new Clay(), 5)
				.addIngredient(gravel(), 1)
				.build();
	}
}
