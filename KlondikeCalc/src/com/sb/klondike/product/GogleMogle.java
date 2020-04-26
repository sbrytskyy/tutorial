package com.sb.klondike.product;

public class GogleMogle extends Product {

	private GogleMogle(Builder builder) {
		super("Gogle Mogle", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public GogleMogle build() {
			return new GogleMogle(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
