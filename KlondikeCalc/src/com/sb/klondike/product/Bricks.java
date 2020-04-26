package com.sb.klondike.product;

public final class Bricks extends Product {

	Bricks(Builder builder) {
		super("Bricks", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Bricks build() {
			return new Bricks(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
