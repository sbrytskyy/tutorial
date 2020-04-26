package com.sb.klondike.product;

public class QuartzSand extends Product {

	private QuartzSand(Builder builder) {
		super("Quartz Sand", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public QuartzSand build() {
			return new QuartzSand(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
