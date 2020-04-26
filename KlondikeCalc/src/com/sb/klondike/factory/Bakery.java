package com.sb.klondike.factory;

import com.sb.klondike.ingredient.ChickenEggs;
import com.sb.klondike.ingredient.Fire;
import com.sb.klondike.ingredient.Pumpkin;
import com.sb.klondike.ingredient.Rye;
import com.sb.klondike.ingredient.SugarCane;
import com.sb.klondike.ingredient.WildStrawberry;
import com.sb.klondike.product.BerryCake;
import com.sb.klondike.product.Cookies;
import com.sb.klondike.product.CurdBase;
import com.sb.klondike.product.Dough;
import com.sb.klondike.product.Flour;
import com.sb.klondike.product.Pancakes;
import com.sb.klondike.product.PumpkinCheesecake;
import com.sb.klondike.product.StrawberryPie;
import com.sb.klondike.product.Sugar;

public class Bakery {

	public static Flour flour() {
		return new Flour.Builder()
				.setProductionTime(3)
				.addIngredient(new Rye(), 5)
				.build();
	}

	public static Dough dough() {
		return new Dough.Builder()
				.setProductionTime(5)
				.addIngredient(flour(), 1)
				.addIngredient(Barn.water(), 1)
				.addIngredient(new ChickenEggs(), 6)
				.build();
	}

	public static Cookies cookies() {
		return new Cookies.Builder()
				.setProductionTime(10)
				.addIngredient(dough(), 1)
				.addIngredient(new Fire(), 5)
				.build();
	}

	public static Pancakes pancakes() {
		return new Pancakes.Builder()
				.setProductionTime(20)
				.addIngredient(dough(), 2)
				.addIngredient(Dairy.gogleMogle(), 1)
				.addIngredient(new Fire(), 10)
				.build();
	}

	public static StrawberryPie strawberryPie() {
		return new StrawberryPie.Builder()
				.setProductionTime(30)
				.addIngredient(dough(), 3)
				.addIngredient(Dairy.butter(), 1)
				.addIngredient(new WildStrawberry(), 9)
				.build();
	}

	public static Sugar sugar() {
		return new Sugar.Builder()
				.setProductionTime(5)
				.addIngredient(new SugarCane(), 5)
				.addIngredient(new Fire(), 1)
				.build();
	}

	public static CurdBase curdBase() {
		return new CurdBase.Builder()
				.setProductionTime(30)
				.addIngredient(dough(), 2)
				.addIngredient(Dairy.curdCheese(), 1)
				.addIngredient(sugar(), 2)
				.build();
	}

	public static PumpkinCheesecake pumpkinCheesecake() {
		return new PumpkinCheesecake.Builder()
				.setProductionTime(60)
				.addIngredient(curdBase(), 1)
				.addIngredient(Dairy.cheese(), 1)
				.addIngredient(new Pumpkin(), 9)
				.build();
	}

	public static BerryCake berryCake() {
		return new BerryCake.Builder()
				.setProductionTime(90)
				.addIngredient(curdBase(), 1)
				.addIngredient(Dairy.cheese(), 1)
				.addIngredient(Dairy.yoghurt(), 1)
				.build();
	}
}
