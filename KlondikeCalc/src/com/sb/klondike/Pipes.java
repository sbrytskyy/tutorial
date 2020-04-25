package com.sb.klondike;

public final class Pipes extends Product {

	Pipes(Builder builder) {
		super("Pipes", builder);
	}

	static class Builder extends Product.Builder<Builder> {

		@Override
		protected Pipes build() {
			return new Pipes(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
