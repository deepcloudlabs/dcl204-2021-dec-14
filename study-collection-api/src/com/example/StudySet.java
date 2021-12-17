package com.example;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class StudySet {

	public static void main(String[] args) {
		// 1. Unique
		// 2. Unordered -> cannot sort
		Comparator<Integer> ascendingOrder= Integer::compare;
		var decendingOrder = ascendingOrder.reversed();
		// 1. HashSet		: Chaotic
		// 2. LinkedHashSet : Insertion order
		// 3. TreeSet       : Comparable
		Set<Integer> numbers = new TreeSet<>(decendingOrder);
		numbers.add(4);
		numbers.add(4);
		numbers.add(4);
		numbers.add(4);
		numbers.add(23);
		numbers.add(4);
		numbers.add(42);
		numbers.add(16);
		numbers.add(8);
		numbers.add(15);
		System.err.println(numbers);
		// numbers.sort()
		// System.err.println(numbers.get(3));
		numbers.contains(108);
	}

}
