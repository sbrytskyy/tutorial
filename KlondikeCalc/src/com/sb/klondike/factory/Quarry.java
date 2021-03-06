package com.sb.klondike.factory;

import com.sb.klondike.data.FactoryType;
import com.sb.klondike.ingredient.Ingedients;
import com.sb.klondike.product.Cement;
import com.sb.klondike.product.Gravel;
import com.sb.klondike.product.QuartzSand;

public class Quarry {

	private static final FactoryType factoryType = FactoryType.QUARRY;

	public static Gravel gravel() {
		return new Gravel.Builder()
				.setProductionTime(3)
				.setFactoryType(factoryType)
				.addIngredient(Ingedients.stones(), 5)
				.build();
	}

	public static QuartzSand quartzSand() {
		return new QuartzSand.Builder()
				.setProductionTime(10)
				.setFactoryType(factoryType)
				.addIngredient(Ingedients.quartz(), 5)
				.build();
	}

	public static Cement cement() {
		return new Cement.Builder()
				.setProductionTime(10)
				.setFactoryType(factoryType)
				.addIngredient(Ingedients.clay(), 5)
				.addIngredient(gravel(), 1)
				.build();
	}
}
