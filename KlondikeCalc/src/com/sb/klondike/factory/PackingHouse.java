package com.sb.klondike.factory;

import com.sb.klondike.data.FactoryType;
import com.sb.klondike.ingredient.Ingedients;
import com.sb.klondike.product.CannedPumpkins;
import com.sb.klondike.product.ChickenEggBox;
import com.sb.klondike.product.CottonBox;
import com.sb.klondike.product.SugarCaneBox;
import com.sb.klondike.product.TomatoCrate;

public class PackingHouse {

	private static final FactoryType factoryType = FactoryType.PACKING_HOUSE;

	public static ChickenEggBox chickenEggBox() {
		return new ChickenEggBox.Builder()
				.setProductionTime(10)
				.setFactoryType(factoryType)
				.addIngredient(Ingedients.chickenEggs(), 30)
				.addIngredient(Factory.cardboardBox(), 1)
				.build();
	}

	public static SugarCaneBox sugarCaneBox() {
		return new SugarCaneBox.Builder()
				.setProductionTime(20)
				.setFactoryType(factoryType)
				.addIngredient(Ingedients.sugarCane(), 20)
				.addIngredient(Factory.cardboardBox(), 1)
				.build();
	}

	public static CottonBox cottonBox() {
		return new CottonBox.Builder()
				.setProductionTime(20)
				.setFactoryType(factoryType)
				.addIngredient(Ingedients.cotton(), 20)
				.addIngredient(Factory.cardboardBox(), 1)
				.build();
	}

	public static CannedPumpkins cannedPumpkins() {
		return new CannedPumpkins.Builder()
				.setProductionTime(45)
				.setFactoryType(factoryType)
				.addIngredient(Ingedients.pumpkin(), 20)
				.addIngredient(Glassblowers.jar(), 1)
				.addIngredient(Bakery.sugar(), 3)
				.build();
	}

	public static TomatoCrate TomatoCrate() {
		return new TomatoCrate.Builder()
				.setProductionTime(60)
				.setFactoryType(factoryType)
				.addIngredient(Ingedients.tomatoes(), 20)
				.addIngredient(Factory.woodenCrate(), 1)
				.build();
	}
}
