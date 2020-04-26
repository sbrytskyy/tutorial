package com.sb.klondike.product;

public final class Window extends Product {

	Window(Builder builder) {
		super("Window", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Window build() {
			return new Window(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
