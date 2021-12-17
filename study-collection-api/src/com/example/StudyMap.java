package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StudyMap {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Map<String,Integer> areaCodes = new HashMap<>();
		areaCodes.put("istanbul-avrupa", 212);
		areaCodes.put("istanbul-anadolu", 216);
		areaCodes.put("ankara", 312);
		// MultiMap -> Map<Set<String>,List<Integer>> 
		Map<Set<String>,List<Integer>> test = new HashMap<>();
		Set<String> key1 = Set.of("istanbul","ankara","antalya");
		Set<String> key2 = Set.of("istanbul","antalya","ankara");
		System.err.println(key1.hashCode());
		System.err.println(key2.hashCode());
		test.put(key1, List.of(1,2));		
		Map<String,Integer> alanKodu = Map.of(
			"istanbul-avrupa", 212,
			"istanbul-anadolu", 216,
			"ankara", 312
		);
		
		System.out.println(areaCodes.get("ankara"));
		// Loop #1: Key
		for (var city: areaCodes.keySet()) {
			System.out.println(String.format("%s -> %d", city,areaCodes.get(city)));
		}
		// Loop #2: Value
		for (var code: areaCodes.values()) {
			System.out.println(code);
		}
		// Loop #3: Entry (Key-Value)
		for (var entry: areaCodes.entrySet()) {
			System.out.println(String.format("%s -> %d", entry.getKey(),entry.getValue()));
		}
		
	}

}
