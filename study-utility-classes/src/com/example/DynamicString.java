package com.example;

public class DynamicString {

	public static void main(String[] args) {
		StringBuilder s = new StringBuilder("");
		long start = System.currentTimeMillis();
		for (int i=0;i<1_000_000;++i)
			s.append(i);
		long stop = System.currentTimeMillis();
		System.out.println("Duration: "+(stop-start));
	}

}
