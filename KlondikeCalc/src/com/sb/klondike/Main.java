package com.sb.klondike;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}

	private void run() {
		Water p1 = BarnFactory.water();
		Product.prettyPrintProduct(p1);

		Nails p2 = SmithyFactory.nails();
		Product.prettyPrintProduct(p2);

		Chains p3 = SmithyFactory.chains();
		Product.prettyPrintProduct(p3);
	}
}
