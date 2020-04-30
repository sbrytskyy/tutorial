package com.sb.klondike.product;

public final class Porridge extends Product {

	Porridge(Builder builder) {
		super("Porridge", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Porridge build() {
			return new Porridge(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
