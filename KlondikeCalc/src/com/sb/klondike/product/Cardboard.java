package com.sb.klondike.product;

public class Cardboard extends Product {

	private Cardboard(Builder builder) {
		super("Cardboard", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Cardboard build() {
			return new Cardboard(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
