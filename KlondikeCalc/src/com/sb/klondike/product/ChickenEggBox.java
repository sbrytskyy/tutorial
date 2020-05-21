package com.sb.klondike.product;

public final class ChickenEggBox extends Product {

	ChickenEggBox(Builder builder) {
		super("Chicken Egg Box", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public ChickenEggBox build() {
			return new ChickenEggBox(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
