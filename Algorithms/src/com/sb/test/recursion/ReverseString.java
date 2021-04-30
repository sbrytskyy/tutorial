package com.sb.test.recursion;

public class ReverseString {

	private String reverseStringR(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}

		int half = s.length() / 2;
		String s1 = s.substring(0, half);
		String s2 = s.substring(half, s.length());

		return reverseStringR(s2) + reverseStringR(s1);
	}

	private String reverseString(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}

		char[] cs = s.toCharArray();
		int start = 0;
		int end = cs.length - 1;

		while (start < end) {

			char tmp = cs[start];
			cs[start] = cs[end];
			cs[end] = tmp;

			start++;
			end--;
		}
		return String.valueOf(cs);
	}

	public static void main(String[] args) {
		ReverseString sol = new ReverseString();

		String s;
		String rev;

		s = "hello";
		rev = sol.reverseStringR(s);
		assert sol.reverseString(s).equals(rev) : String.format("Actual result: %s", rev);

		s = "sgfddasf gsdfgdsdsgdsfgsdfge rgdg dfdsf dfg c";
		rev = sol.reverseStringR(s);
		assert sol.reverseString(s).equals(rev) : String.format("Actual result: %s", rev);
	}
}
