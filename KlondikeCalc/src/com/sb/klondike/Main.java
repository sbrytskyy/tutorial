package com.sb.klondike;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}

	private void run() {
		Water p1 = BarnFactory.water();
		System.out.println(p1);
		Product.prettyPrintProduct(p1);

		Nails p2 = SmithyFactory.nails();
		System.out.println(p2);
		Product.prettyPrintProduct(p2);
	}
}
