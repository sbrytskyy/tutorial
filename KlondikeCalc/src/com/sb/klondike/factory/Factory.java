package com.sb.klondike.factory;

import com.sb.klondike.product.Bed;
import com.sb.klondike.product.CardboardBox;
import com.sb.klondike.product.Stool;
import com.sb.klondike.product.Table;
import com.sb.klondike.product.Window;
import com.sb.klondike.product.WoodenCrate;

public class Factory {

	public static Stool stool() {
		return new Stool.Builder()
				.setProductionTime(20)
				.addIngredient(Sawmill.woodVeneer(), 3)
				.addIngredient(Smithy.nails(), 1)
				.addIngredient(Sawmill.glue(), 2)
				.build();
	}

	public static Table table() {
		return new Table.Builder()
				.setProductionTime(30)
				.addIngredient(Sawmill.boards(), 3)
				.addIngredient(Smithy.nails(), 2)
				.addIngredient(Sawmill.glue(), 3)
				.build();
	}

	public static Window window() {
		return new Window.Builder()
				.setProductionTime(60)
				.addIngredient(Sawmill.beam(), 1)
				.addIngredient(Glassblowers.windowGlass(), 2)
				.addIngredient(Pottery.mortar(), 2)
				.build();
	}

	public static Bed bed() {
		return new Bed.Builder()
				.setProductionTime(90)
				.addIngredient(Sawmill.beam(), 2)
				.addIngredient(Smithy.nails(), 3)
				.addIngredient(Sawmill.glue(), 4)
				.build();
	}

	public static CardboardBox cardboardBox() {
		return new CardboardBox.Builder()
				.setProductionTime(10)
				.addIngredient(Sawmill.cardboard(), 2)
				.addIngredient(Sawmill.glue(), 1)
				.build();
	}

	public static WoodenCrate woodenCrate() {
		return new WoodenCrate.Builder()
				.setProductionTime(20)
				.addIngredient(Sawmill.woodVeneer(), 2)
				.addIngredient(Smithy.nails(), 1)
				.build();
	}

}
