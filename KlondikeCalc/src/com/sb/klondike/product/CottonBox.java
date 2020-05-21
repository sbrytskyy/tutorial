package com.sb.klondike.product;

public final class CottonBox extends Product {

	CottonBox(Builder builder) {
		super("Cotton Box", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public CottonBox build() {
			return new CottonBox(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
