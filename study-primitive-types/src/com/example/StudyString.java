package com.example;

public class StudyString {

	public static void main(String[] args) {
		// dynamic string -> new -> Heap
		String name1 = new String("Jack"); 
		// static string -> CP (Constant Pool -> Object Pool -> Object Cache) 
		String name2 = "Jack"; 
		String name3 = "Jack";
		name1 = name1.intern();
		System.out.println("name1==name2? "+(name1.equals(name3)));
		System.out.println("name3==name2? "+(name3.equals(name3)));
		name2 = name2.toLowerCase();
		System.out.println(name2);
	}

}
