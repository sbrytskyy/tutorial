package com.sb.klondike.product;

public final class Pancakes extends Product {

	Pancakes(Builder builder) {
		super("Pancakes", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Pancakes build() {
			return new Pancakes(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
