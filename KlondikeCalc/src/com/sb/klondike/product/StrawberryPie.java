package com.sb.klondike.product;

public final class StrawberryPie extends Product {

	StrawberryPie(Builder builder) {
		super("Strawberry Pie", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public StrawberryPie build() {
			return new StrawberryPie(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
