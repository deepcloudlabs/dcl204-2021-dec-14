package com.example;

public class StudyChar {

	public static void main(String[] args) {
		char c = 'x'; // 2-byte, unicode,unsigned int
		System.out.println((char)(c+1));
		c = '\u20ba';
		System.out.println(c);
	}

}
