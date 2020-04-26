package com.sb.klondike.product;

public final class Table extends Product {

	Table(Builder builder) {
		super("Table", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Table build() {
			return new Table(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
