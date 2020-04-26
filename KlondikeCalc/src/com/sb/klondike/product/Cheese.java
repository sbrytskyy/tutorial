package com.sb.klondike.product;

public final class Cheese extends Product {

	Cheese(Builder builder) {
		super("Cheese", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Cheese build() {
			return new Cheese(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
