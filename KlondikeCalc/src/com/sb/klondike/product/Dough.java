package com.sb.klondike.product;

public final class Dough extends Product {

	Dough(Builder builder) {
		super("Dough", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Dough build() {
			return new Dough(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
