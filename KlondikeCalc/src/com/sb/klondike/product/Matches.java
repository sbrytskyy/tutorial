package com.sb.klondike.product;

public final class Matches extends Product {

	Matches(Builder builder) {
		super("Matches", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Matches build() {
			return new Matches(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
