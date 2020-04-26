package com.sb.klondike.product;

public final class Jar extends Product {

	Jar(Builder builder) {
		super("Jar", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Jar build() {
			return new Jar(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
