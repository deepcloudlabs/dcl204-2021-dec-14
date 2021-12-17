package com.example;

import java.text.DecimalFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

@SuppressWarnings("unused")
public class StudyFormatCurrency {

	public static void main(String[] args) {
		Locale tr = new Locale("tr", "TR");
		double money = 1_234_567.89;
		DecimalFormat df = (DecimalFormat) DecimalFormat.getCurrencyInstance(Locale.FRANCE);
		System.out.println(df.format(money));

		ZonedDateTime now = ZonedDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
				.withLocale(Locale.SIMPLIFIED_CHINESE);
		System.out.println(dtf.format(now));
	}

}
