package com.sb.klondike.product;

public final class BerryCake extends Product {

	BerryCake(Builder builder) {
		super("Berry Cake", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public BerryCake build() {
			return new BerryCake(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
