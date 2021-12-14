package com.example;

public class StudyFloatingPointTypes {

	public static void main(String[] args) {
		// FPU -> IEEE-754 v5
		float x = 3.141516171819F; // 4-byte
		double y = 2.0; // 8-byte
		y = y - 1.10;
		System.err.println(String.format("%16.16f", y));
		x = 1_000_000_000;
		x = x + 50;
		System.err.println(String.format("%16.16f", x));
		var isEqual = (0.1 + 0.2) + 0.3 == 0.1 + (0.2 + 0.3);
		System.err.println(isEqual);
		double one = 0/0.; 
		System.err.println(Double.isNaN(one));
		double two = 1/-0.; 
		System.err.println(two);
		double three = 1/0.; 
		System.err.println(three);
	}

}
