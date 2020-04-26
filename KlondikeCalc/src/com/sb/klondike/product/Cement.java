package com.sb.klondike.product;

public final class Cement extends Product {

	Cement(Builder builder) {
		super("Cement", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Cement build() {
			return new Cement(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
