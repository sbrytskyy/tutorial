package com.sb.klondike.product;

public class SheepFeed extends Product {

	private SheepFeed(Builder builder) {
		super("Sheep Feed", builder);
	}

	public static class Builder extends Product.Builder<Builder> {

		@Override
		public SheepFeed build() {
			return new SheepFeed(this);
		}

		@Override
		protected Builder getThis() {
			return this;
		}
	}
}
