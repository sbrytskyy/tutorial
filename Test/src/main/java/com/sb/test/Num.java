package com.sb.test;

public class Num {

	public static void main(String[] args) {
		String s = "42";
		s.concat(".5");
		double d = Double.parseDouble(s);
		s = Double.toString(d);
		int x = (int) Math.ceil(Double.valueOf(s).doubleValue());
		System.out.println(x);
	}

}
