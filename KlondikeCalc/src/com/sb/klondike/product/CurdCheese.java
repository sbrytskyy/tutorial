package com.sb.klondike.product;

public final class CurdCheese extends Product {

	CurdCheese(Builder builder) {
		super("Curd Cheese", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public CurdCheese build() {
			return new CurdCheese(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
