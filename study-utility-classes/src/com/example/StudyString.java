package com.example;

import java.util.Locale;

public class StudyString {

	public static void main(String[] args) {
		Locale tr = new Locale("tr","TR");
		String city = "izmir";
		System.out.println(city.toUpperCase(tr));

	}

}
