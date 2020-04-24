package com.sb.klondike;

import com.sb.klondike.Water.WaterBuilder;

public class BarnFactory {

	public static Water water() {
		return new WaterBuilder().build();
	}
}
