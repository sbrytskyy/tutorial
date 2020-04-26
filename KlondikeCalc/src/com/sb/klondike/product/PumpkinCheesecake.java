package com.sb.klondike.product;

public final class PumpkinCheesecake extends Product {

	PumpkinCheesecake(Builder builder) {
		super("Pumpkin Cheesecake", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public PumpkinCheesecake build() {
			return new PumpkinCheesecake(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
