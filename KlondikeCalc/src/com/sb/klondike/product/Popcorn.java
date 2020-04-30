package com.sb.klondike.product;

public final class Popcorn extends Product {

	Popcorn(Builder builder) {
		super("Popcorn", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Popcorn build() {
			return new Popcorn(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
