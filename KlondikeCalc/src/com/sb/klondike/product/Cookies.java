package com.sb.klondike.product;

public class Cookies extends Product {

	private Cookies(Builder builder) {
		super("Cookies", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Cookies build() {
			return new Cookies(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
