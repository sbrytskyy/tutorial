package com.sb.klondike.product;

public final class Bed extends Product {

	Bed(Builder builder) {
		super("Bed", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Bed build() {
			return new Bed(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
