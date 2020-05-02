package com.sb.klondike.factory;

import com.sb.klondike.data.FactoryType;
import com.sb.klondike.ingredient.Ingedients;
import com.sb.klondike.product.Beam;
import com.sb.klondike.product.Boards;
import com.sb.klondike.product.Cardboard;
import com.sb.klondike.product.Glue;
import com.sb.klondike.product.WoodVeneer;

public class Sawmill {

	private static final FactoryType factoryType = FactoryType.SAWMILL;

	public static WoodVeneer woodVeneer() {
		return new WoodVeneer.Builder()
				.setProductionTime(3)
				.setFactoryType(factoryType)
				.addIngredient(Ingedients.sequoiaLogs(), 5)
				.addIngredient(Ingedients.dryTwigs(), 10)
				.build();
	}

	public static Boards boards() {
		return new Boards.Builder()
				.setProductionTime(10)
				.setFactoryType(factoryType)
				.addIngredient(Ingedients.firTreeLogs(), 5)
				.addIngredient(Ingedients.saw(), 1)
				.build();
	}

	public static Glue glue() {
		return new Glue.Builder()
				.setProductionTime(20)
				.setFactoryType(factoryType)
				.addIngredient(Ingedients.corn(), 10)
				.addIngredient(Bakery.flour(), 2)
				.addIngredient(Barn.water(), 2)
				.build();
	}

	public static Beam beam() {
		return new Beam.Builder()
				.setProductionTime(20)
				.setFactoryType(factoryType)
				.addIngredient(Ingedients.ordinaryLogs(), 6)
				.addIngredient(boards(), 2)
				.addIngredient(glue(), 1)
				.build();
	}

	public static Cardboard cardboard() {
		return new Cardboard.Builder()
				.setProductionTime(10)
				.setFactoryType(factoryType)
				.addIngredient(Quarry.gravel(), 2)
				.addIngredient(Ingedients.ordinaryLogs(), 6)
				.build();
	}
}
