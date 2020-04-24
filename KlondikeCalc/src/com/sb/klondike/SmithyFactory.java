package com.sb.klondike;

import com.sb.klondike.Nails.NailsBuilder;

public class SmithyFactory {

	public static Nails nails() {
		return new NailsBuilder().build();
	}

}
