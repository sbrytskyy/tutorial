package com.sb.klondike.factory;

import com.sb.klondike.data.FactoryType;
import com.sb.klondike.ingredient.Ingedients;
import com.sb.klondike.product.Butter;
import com.sb.klondike.product.Cheese;
import com.sb.klondike.product.Cream;
import com.sb.klondike.product.CurdCheese;
import com.sb.klondike.product.GogleMogle;
import com.sb.klondike.product.Yoghurt;

public class Dairy {

	private static final FactoryType factoryType = FactoryType.DAIRY;

	public static Cream cream() {
		return new Cream.Builder()
				.setProductionTime(5)
				.setFactoryType(factoryType)
				.addIngredient(Ingedients.milk(), 6)
				.build();
	}

	public static Butter butter() {
		return new Butter.Builder()
				.setProductionTime(10)
				.setFactoryType(factoryType)
				.addIngredient(cream(), 2)
				.build();
	}

	public static GogleMogle gogleMogle() {
		return new GogleMogle.Builder()
				.setProductionTime(20)
				.setFactoryType(factoryType)
				.addIngredient(Ingedients.chickenEggs(), 9)
				.addIngredient(Ingedients.milk(), 5)
				.build();
	}

	public static CurdCheese curdCheese() {
		return new CurdCheese.Builder()
				.setProductionTime(30)
				.setFactoryType(factoryType)
				.addIngredient(cream(), 1)
				.addIngredient(Ingedients.fire(), 3)
				.build();
	}

	public static Cheese cheese() {
		return new Cheese.Builder()
				.setProductionTime(60)
				.setFactoryType(factoryType)
				.addIngredient(cream(), 2)
				.addIngredient(Ingedients.chickenEggs(), 9)
				.addIngredient(Ingedients.fire(), 3)
				.build();
	}

	public static Yoghurt yoghurt() {
		return new Yoghurt.Builder()
				.setProductionTime(90)
				.setFactoryType(factoryType)
				.addIngredient(cream(), 3)
				.addIngredient(Ingedients.wildStrawberry(), 9)
				.addIngredient(Glassblowers.jar(), 1)
				.build();
	}
}
