package com.sb.klondike.product;

public final class Tile extends Product {

	Tile(Builder builder) {
		super("Tile", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Tile build() {
			return new Tile(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
