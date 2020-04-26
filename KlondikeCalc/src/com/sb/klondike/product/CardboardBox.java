package com.sb.klondike.product;

public final class CardboardBox extends Product {

	CardboardBox(Builder builder) {
		super("Cardboard Box", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public CardboardBox build() {
			return new CardboardBox(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
