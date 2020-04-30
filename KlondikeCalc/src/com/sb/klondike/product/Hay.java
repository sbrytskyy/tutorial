package com.sb.klondike.product;

public class Hay extends Product {

	private Hay(Builder builder) {
		super("Hay", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Hay build() {
			return new Hay(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
