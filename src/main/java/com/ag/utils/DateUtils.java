package com.ag.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

	public static LocalDate getDateFromString(String date) {
		LocalDate finalDate = LocalDate.parse(date);
		return finalDate;
	}
	
	public static String convertDateFormatInDBRedableFormat(String date) {
		DateTimeFormatter dateTimeFormatterDestination = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter dateTimeFormatterSource = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate parse = LocalDate.parse(date.trim(), dateTimeFormatterSource);
		String formattedDate = parse.format(dateTimeFormatterDestination);
		return formattedDate;
	}
	
}
