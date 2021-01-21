package com.sb.test.regex;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

	private static final java.util.regex.Pattern PATTERN = java.util.regex.Pattern
			.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

	public List<String> restoreIpAddresses(String s) {
		Set<String> r = new HashSet<>();

		explore(r, s, "", 0, 0);

		return new ArrayList<>(r);
	}

	private void explore(Set<String> r, String s, String address, int step, int pos) {
//		System.out.println(address + ", " + step + ":" + pos);

		if (step == 4 && pos == s.length()) {
			String ip = address.endsWith(".") ? address.substring(0, address.length() - 1) : address;
			if (PATTERN.matcher(ip).matches()) {
				r.add(ip);
			}
		}

		if (step >= 4) {
			return;
		}

		for (int i = 1; i <= 3 && pos + i <= s.length(); i++) {
			String t = s.substring(pos, pos + i);
			Integer num = -1;
			try {
				num = Integer.valueOf(t);
			} catch (NumberFormatException e) {
			}
			if (num >= 0 && num < 256 && (num.toString().equals(t))) {
				String tmp = address + t + ".";
				explore(r, s, tmp, step + 1, pos + t.length());
			}
		}
	}

	public static void testRegexSample() {
		// String to be scanned to find the pattern.
		String line = "This order was placed for QT3000! OK?";
		String pattern = "(.*)(\\d+)(.*)";

		// Create a Pattern object
		Pattern r = Pattern.compile(pattern);

		// Now create matcher object.
		Matcher m = r.matcher(line);
		if (m.find()) {
			System.out.println("Found value: " + m.group(0));
			System.out.println("Found value: " + m.group(1));
			System.out.println("Found value: " + m.group(2));
		} else {
			System.out.println("NO MATCH");
		}
	}

	public static void testRegex(String line) {
		System.out.println("---------------------------------------");
		System.out.println("Line to test: " + line);
		// String to be scanned to find the pattern.
//		String pattern = "^(collaborator-rule|rule)-(\\d+)-(\\d{19}+)$";
//		String pattern = "^(.+)$";

//		(rpcreplay.processing).set_regex_to_value.regex = "#[0-9]*",
//		(rpcreplay.processing).set_regex_to_value.value = "#0"

		String pattern = "\\d";
		String replacement = "0";

		// Create a Pattern object
		Pattern r = Pattern.compile(pattern);

		// Now create matcher object.
		Matcher m = r.matcher(line);
		if (m.find()) {
			for (int g = 0; g < m.groupCount() + 1; g++) {
				String group = m.group(g);
//				System.out.println(g + " : " + group + " : " + group.length());
			}

			String newS = line.replaceAll(pattern, replacement);
			System.out.println("new string: " + newS);
		} else {
			System.out.println("NO MATCH");
		}
	}

	public static void main(String[] args) {

		testRegexSample();
//		testPatterns();

		String line;

		line = "rule-0-1606339321908000000";
		testRegex(line);
		line = "rule-12-1606336569831000000";
		testRegex(line);
		line = "collaborator-rule-23-1606336569831000000";
		testRegex(line);
		line = "collaborator-rule-1-1606956618370000000";
		testRegex(line);
	}

	private static void testPatterns() {
		Solution sol = new Solution();

		String s;
		List<String> r;

		s = "25525511135";
		r = sol.restoreIpAddresses(s);
		System.out.println(r);

		s = "0000";
		r = sol.restoreIpAddresses(s);
		System.out.println(r);

		s = "010010";
		r = sol.restoreIpAddresses(s);
		System.out.println(r);
	}
}
