package com.sb.klondike.product;

public final class Butter extends Product {

	Butter(Builder builder) {
		super("Butter", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Butter build() {
			return new Butter(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
