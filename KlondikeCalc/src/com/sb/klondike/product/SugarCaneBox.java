package com.sb.klondike.product;

public final class SugarCaneBox extends Product {

	SugarCaneBox(Builder builder) {
		super("Sugar Cane Box", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public SugarCaneBox build() {
			return new SugarCaneBox(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
