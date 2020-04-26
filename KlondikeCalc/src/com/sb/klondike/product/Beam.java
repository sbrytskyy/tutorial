package com.sb.klondike.product;

public class Beam extends Product {

	private Beam(Builder builder) {
		super("Beam", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Beam build() {
			return new Beam(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
