package com.sb.klondike.product;

public final class Flour extends Product {

	Flour(Builder builder) {
		super("Flour", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Flour build() {
			return new Flour(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
