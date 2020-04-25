package com.sb.klondike;

public class Water extends Product {

	private Water(Builder builder) {
		super("Water", builder);
	}

	static class Builder extends Product.Builder<Builder> {

		@Override
		protected Water build() {
			return new Water(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
