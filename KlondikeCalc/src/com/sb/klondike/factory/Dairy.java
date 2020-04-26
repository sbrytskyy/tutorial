package com.sb.klondike.factory;

import com.sb.klondike.ingredient.ChickenEggs;
import com.sb.klondike.ingredient.Fire;
import com.sb.klondike.ingredient.Milk;
import com.sb.klondike.ingredient.WildStrawberry;
import com.sb.klondike.product.Butter;
import com.sb.klondike.product.Cheese;
import com.sb.klondike.product.Cream;
import com.sb.klondike.product.CurdCheese;
import com.sb.klondike.product.GogleMogle;
import com.sb.klondike.product.Yoghurt;

public class Dairy {

	public static Cream cream() {
		return new Cream.Builder()
				.setProductionTime(5)
				.addIngredient(new Milk(), 6)
				.build();
	}

	public static Butter butter() {
		return new Butter.Builder()
				.setProductionTime(10)
				.addIngredient(cream(), 2)
				.build();
	}

	public static GogleMogle gogleMogle() {
		return new GogleMogle.Builder()
				.setProductionTime(20)
				.addIngredient(new ChickenEggs(), 9)
				.addIngredient(new Milk(), 5)
				.build();
	}

	public static CurdCheese curdCheese() {
		return new CurdCheese.Builder()
				.setProductionTime(30)
				.addIngredient(cream(), 1)
				.addIngredient(new Fire(), 3)
				.build();
	}

	public static Cheese cheese() {
		return new Cheese.Builder()
				.setProductionTime(60)
				.addIngredient(cream(), 2)
				.addIngredient(new ChickenEggs(), 9)
				.addIngredient(new Fire(), 3)
				.build();
	}

	public static Yoghurt yoghurt() {
		return new Yoghurt.Builder()
				.setProductionTime(90)
				.addIngredient(cream(), 3)
				.addIngredient(new WildStrawberry(), 9)
				.addIngredient(Glassblowers.jar(), 1)
				.build();
	}
}
