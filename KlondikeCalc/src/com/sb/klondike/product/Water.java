package com.sb.klondike.product;

public class Water extends Product {

	private Water(Builder builder) {
		super("Water", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Water build() {
			return new Water(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
