package com.sb.klondike.product;

public final class Pipes extends Product {

	Pipes(Builder builder) {
		super("Pipes", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Pipes build() {
			return new Pipes(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
