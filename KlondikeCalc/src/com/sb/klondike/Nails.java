package com.sb.klondike;

public final class Nails extends Product {

	Nails(Builder builder) {
		super("Nails", builder);
	}

	static class Builder extends Product.Builder<Builder> {

		@Override
		protected Nails build() {
			return new Nails(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
