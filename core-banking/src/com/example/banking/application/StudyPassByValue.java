package com.example.banking.application;

public class StudyPassByValue {

	public static void main(String[] args) {
		String name1[]= {"Jack"};
		String name2[]= {"Kate"};
		System.out.println(name1[0]+","+name2[0]);
		swap(name1, name2);
		System.out.println(name1[0]+","+name2[0]);
	}
	
	public static void swap(String[] s1, String[] s2) {
		var tmp = s1[0];
		s1[0] = s2[0];
		s2[0] = tmp;
	} 

}
