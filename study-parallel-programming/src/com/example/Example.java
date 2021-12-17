package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Example {
	public static void main(String[] args) {
		List<Integer> bigData = new ArrayList<>();
		
		Stream<Integer> stream = bigData.stream().sorted();
		if (bigData.size()>1_000_000)
			stream = stream.parallel();
		stream.findFirst();
	}
}
