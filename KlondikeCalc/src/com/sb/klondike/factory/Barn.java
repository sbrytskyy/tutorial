package com.sb.klondike.factory;

import com.sb.klondike.data.FactoryType;
import com.sb.klondike.ingredient.Ingedients;
import com.sb.klondike.product.Feeder;
import com.sb.klondike.product.Hay;
import com.sb.klondike.product.Matches;
import com.sb.klondike.product.Popcorn;
import com.sb.klondike.product.Porridge;
import com.sb.klondike.product.SheepFeed;
import com.sb.klondike.product.Water;

public class Barn {

	private static final FactoryType factoryType = FactoryType.BARN;

	public static Feeder feeder() {
		return new Feeder.Builder()
				.setProductionTime(1)
				.setFactoryType(factoryType)
				.addIngredient(Ingedients.beans(), 9)
				.build();
	}

	public static Hay hay() {
		return new Hay.Builder()
				.setProductionTime(3)
				.setFactoryType(factoryType)
				.addIngredient(Ingedients.rye(), 9)
				.addIngredient(Ingedients.freshGrass(), 5)
				.build();
	}

	public static Water water() {
		return new Water.Builder()
				.setProductionTime(1)
				.setFactoryType(factoryType)
				.addIngredient(Ingedients.ice(), 2)
				.addIngredient(Ingedients.fire(), 1)
				.build();
	}

	public static SheepFeed sheepFeed() {
		return new SheepFeed.Builder()
				.setProductionTime(5)
				.setFactoryType(factoryType)
				.addIngredient(Ingedients.freshGrass(), 9)
				.addIngredient(water(), 3)
				.build();
	}

	public static Matches matches() {
		return new Matches.Builder()
				.setProductionTime(10)
				.setFactoryType(factoryType)
				.addIngredient(Ingedients.ordinaryLogs(), 10)
				.addIngredient(Quarry.quartzSand(), 2)
				.build();
	}

	public static Popcorn popcorn() {
		return new Popcorn.Builder()
				.setProductionTime(30)
				.setFactoryType(factoryType)
				.addIngredient(Ingedients.fire(), 5)
				.addIngredient(Ingedients.corn(), 25)
				.build();
	}

	public static Porridge porridge() {
		return new Porridge.Builder()
				.setProductionTime(30)
				.setFactoryType(factoryType)
				.addIngredient(water(), 5)
				.addIngredient(Dairy.butter(), 1)
				.build();
	}
}
