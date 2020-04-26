package com.sb.klondike.product;

public class Glue extends Product {

	private Glue(Builder builder) {
		super("Glue", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Glue build() {
			return new Glue(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
