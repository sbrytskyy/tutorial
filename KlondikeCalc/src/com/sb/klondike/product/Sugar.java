package com.sb.klondike.product;

public final class Sugar extends Product {

	Sugar(Builder builder) {
		super("Sugar", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Sugar build() {
			return new Sugar(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
