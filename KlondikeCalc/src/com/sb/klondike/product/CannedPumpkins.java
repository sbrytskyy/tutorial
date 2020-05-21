package com.sb.klondike.product;

public final class CannedPumpkins extends Product {

	CannedPumpkins(Builder builder) {
		super("Canned Pumpkins", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public CannedPumpkins build() {
			return new CannedPumpkins(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
