package com.sb.klondike.product;

public final class Yoghurt extends Product {

	Yoghurt(Builder builder) {
		super("Yoghurt", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Yoghurt build() {
			return new Yoghurt(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
