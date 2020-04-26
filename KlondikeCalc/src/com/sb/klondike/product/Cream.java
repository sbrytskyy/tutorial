package com.sb.klondike.product;

public final class Cream extends Product {

	Cream(Builder builder) {
		super("Cream", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Cream build() {
			return new Cream(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
