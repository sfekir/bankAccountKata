package com.kata.util;

import java.text.DecimalFormat;

public class DecimaUtil {
	private static DecimalFormat convertToDecimal = new DecimalFormat("#.00");

	public static String formatDecimal(double val) {

		try {
			return convertToDecimal.format(val);

		} catch (NullPointerException e) {
			throw new NullPointerException("null value");

		}

	}
}
