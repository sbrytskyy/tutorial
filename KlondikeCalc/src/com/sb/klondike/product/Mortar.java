package com.sb.klondike.product;

public final class Mortar extends Product {

	Mortar(Builder builder) {
		super("Mortar", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Mortar build() {
			return new Mortar(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
