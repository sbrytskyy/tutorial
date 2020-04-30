package com.sb.klondike.product;

public final class Feeder extends Product {

	Feeder(Builder builder) {
		super("Feeder", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Feeder build() {
			return new Feeder(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
