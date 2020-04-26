package com.sb.klondike.product;

public final class CurdBase extends Product {

	CurdBase(Builder builder) {
		super("Curd Base", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public CurdBase build() {
			return new CurdBase(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
