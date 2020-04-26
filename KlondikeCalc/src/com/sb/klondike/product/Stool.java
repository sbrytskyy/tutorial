package com.sb.klondike.product;

public final class Stool extends Product {

	Stool(Builder builder) {
		super("Stool", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Stool build() {
			return new Stool(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
