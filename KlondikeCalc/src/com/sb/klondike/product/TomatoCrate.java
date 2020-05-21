package com.sb.klondike.product;

public final class TomatoCrate extends Product {

	TomatoCrate(Builder builder) {
		super("Tomato Crate", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public TomatoCrate build() {
			return new TomatoCrate(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
