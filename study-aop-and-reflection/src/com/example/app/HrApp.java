package com.example.app;

import java.lang.reflect.Field;

public class HrApp {

	public static void main(String[] args) throws Exception {
		Employee jack = new Employee("1", "tr1", 4_000);
		Class<?> clazz = Employee.class;
		Field iban = clazz.getDeclaredField("iban");
		System.err.println(jack);
		iban.setAccessible(true);
		iban.set(jack, "tr2"); // jack.iban = "tr2";
		iban.setAccessible(false);
		System.err.println(jack);
	}

}
