package com.sb.klondike.product;

public final class Chains extends Product {

	Chains(Builder builder) {
		super("Chains", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public Chains build() {
			return new Chains(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
