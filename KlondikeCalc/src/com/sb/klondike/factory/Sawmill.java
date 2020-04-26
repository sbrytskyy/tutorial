package com.sb.klondike.factory;

import com.sb.klondike.ingredient.Corn;
import com.sb.klondike.ingredient.DryTwigs;
import com.sb.klondike.ingredient.FirTreeLogs;
import com.sb.klondike.ingredient.OrdinaryLogs;
import com.sb.klondike.ingredient.Saw;
import com.sb.klondike.ingredient.SequoiaLogs;
import com.sb.klondike.product.Beam;
import com.sb.klondike.product.Boards;
import com.sb.klondike.product.Cardboard;
import com.sb.klondike.product.Glue;
import com.sb.klondike.product.WoodVeneer;

public class Sawmill {

	public static WoodVeneer woodVeneer() {
		return new WoodVeneer.Builder()
				.setProductionTime(3)
				.addIngredient(new SequoiaLogs(), 5)
				.addIngredient(new DryTwigs(), 10)
				.build();
	}

	public static Boards boards() {
		return new Boards.Builder()
				.setProductionTime(10)
				.addIngredient(new FirTreeLogs(), 5)
				.addIngredient(new Saw(), 1)
				.build();
	}

	public static Glue glue() {
		return new Glue.Builder()
				.setProductionTime(20)
				.addIngredient(new Corn(), 10)
				.addIngredient(Bakery.flour(), 2)
				.addIngredient(Barn.water(), 2)
				.build();
	}

	public static Beam beam() {
		return new Beam.Builder()
				.setProductionTime(20)
				.addIngredient(new OrdinaryLogs(), 6)
				.addIngredient(boards(), 2)
				.addIngredient(glue(), 1)
				.build();
	}

	public static Cardboard cardboard() {
		return new Cardboard.Builder()
				.setProductionTime(10)
				.addIngredient(Quarry.gravel(), 2)
				.addIngredient(new OrdinaryLogs(), 6)
				.build();
	}
}
