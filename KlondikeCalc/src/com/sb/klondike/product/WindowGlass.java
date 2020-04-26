package com.sb.klondike.product;

public final class WindowGlass extends Product {

	WindowGlass(Builder builder) {
		super("Window Glass", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public WindowGlass build() {
			return new WindowGlass(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
