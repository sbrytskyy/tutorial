package com.sb.klondike.product;

public final class Nails extends Product {

	Nails(Builder builder) {
		super("Nails", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Nails build() {
			return new Nails(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
