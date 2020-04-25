package com.sb.klondike;

public final class Chains extends Product {

	Chains(Builder builder) {
		super("Chains", builder);
	}

	static class Builder extends Product.Builder<Builder> {

		@Override
		protected Chains build() {
			return new Chains(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
