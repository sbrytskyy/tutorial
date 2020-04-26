package com.sb.klondike.product;

public final class Glass extends Product {

	Glass(Builder builder) {
		super("Glass", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Glass build() {
			return new Glass(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
