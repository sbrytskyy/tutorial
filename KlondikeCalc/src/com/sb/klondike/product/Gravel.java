package com.sb.klondike.product;

public class Gravel extends Product {

	private Gravel(Builder builder) {
		super("Gravel", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Gravel build() {
			return new Gravel(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
