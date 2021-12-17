package com.example;

import java.util.ArrayList;
import java.util.List;

public class StudyList {

	public static void main(String[] args) {
		// 1. Allows duplicates
		// 2. Ordered -> Sortable
		List<String> cities = new ArrayList<>(1_000_000); // 2. LinkedList
		cities.add("istanbul");
		cities.add("ankara");
		cities.add(0,"izmir");
		cities.add("istanbul");
		cities.add("ankara");
		System.out.println(cities);
		System.out.println(cities.get(3));
		cities.sort(String::compareTo);
		System.out.println(cities.contains("antalya"));
		
	}

}
