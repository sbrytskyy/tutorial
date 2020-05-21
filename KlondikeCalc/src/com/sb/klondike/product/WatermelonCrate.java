package com.sb.klondike.product;

public final class WatermelonCrate extends Product {

	WatermelonCrate(Builder builder) {
		super("Watermelon Crate", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public WatermelonCrate build() {
			return new WatermelonCrate(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
