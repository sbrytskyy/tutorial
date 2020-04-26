package com.sb.klondike.factory;

import com.sb.klondike.ingredient.Fire;
import com.sb.klondike.ingredient.Trowel;
import com.sb.klondike.product.Bricks;
import com.sb.klondike.product.Mortar;
import com.sb.klondike.product.Tile;

public class Pottery {

	public static Mortar mortar() {
		return new Mortar.Builder()
				.setProductionTime(20)
				.addIngredient(Quarry.cement(), 1)
				.addIngredient(new Trowel(), 1)
				.build();
	}

	public static Bricks bricks() {
		return new Bricks.Builder()
				.setProductionTime(30)
				.addIngredient(mortar(), 1)
				.addIngredient(new Fire(), 3)
				.addIngredient(Quarry.quartzSand(), 1)
				.build();
	}

	public static Tile tile() {
		return new Tile.Builder()
				.setProductionTime(60)
				.addIngredient(mortar(), 2)
				.addIngredient(new Fire(), 4)
				.addIngredient(Quarry.quartzSand(), 2)
				.build();
	}
}
