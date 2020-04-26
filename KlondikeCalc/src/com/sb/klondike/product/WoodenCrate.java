package com.sb.klondike.product;

public final class WoodenCrate extends Product {

	WoodenCrate(Builder builder) {
		super("Wooden Crate", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public WoodenCrate build() {
			return new WoodenCrate(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
