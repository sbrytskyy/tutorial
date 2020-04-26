package com.sb.klondike.product;

public class WoodVeneer extends Product {

	private WoodVeneer(Builder builder) {
		super("Wood Veneer", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public WoodVeneer build() {
			return new WoodVeneer(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
