package com.sb.klondike.product;

public class Boards extends Product {

	private Boards(Builder builder) {
		super("Boards", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Boards build() {
			return new Boards(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
