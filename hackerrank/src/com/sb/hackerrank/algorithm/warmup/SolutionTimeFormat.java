package com.sb.hackerrank.algorithm.warmup;

import java.io.IOException;

public class SolutionTimeFormat {

	/*
	 * Complete the timeConversion function below.
	 */
	static String timeConversion(String s) {
		String ampm = s.substring(s.length() - 2);
		String sHour = s.substring(0, 2);
		int hour = Integer.valueOf(sHour);
		;
		if ("PM".equalsIgnoreCase(ampm)) {
			if (hour == 12) {
				hour = 0;
			}
			hour += 12;
		} else {
			if (hour == 12) {
				hour = 0;
			}
		}
		return String.format("%02d", hour) + s.substring(2, s.length() - 2);
	}

	public static void main(String[] args) throws IOException {
		String s;
		String result;

		s = "12:00:00AM";
		result = timeConversion(s);
		System.out.println(result);
	}
}
