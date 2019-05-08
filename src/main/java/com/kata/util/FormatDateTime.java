package com.kata.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatDateTime {
	private static final String DATE_FORMATTER = "yyyy-MM-dd HH:mm:ss";

	private static DateTimeFormatter formatter = DateTimeFormatter
			.ofPattern(DATE_FORMATTER);

	public static String convertFormatDateTime(LocalDateTime date) {

		return date.format(formatter);
	}
}
