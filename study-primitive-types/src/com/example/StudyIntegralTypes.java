package com.example;

import java.math.BigInteger;

public class StudyIntegralTypes {

	public static void main(String[] args) {
		byte b = 42 ; // 1-byte, [-128..127]
		b = 127;
		b++;
		System.out.println("b: "+b);
//		for (byte i=0;i<=127;++i)
//			System.out.println("i: "+i);
		short s = 100; // 2-byte, [-32768..32767]
		s = Short.MAX_VALUE;
		System.out.println("s: "+s);
		s++;
		System.out.println("s: "+s);
		byte p = 127, q = 1 , r;
		r = (byte)(p + q); // JLS: + --> int
		int i = 108; // 4-byte, [-2147483648,2147483647]
		i = Integer.MAX_VALUE;
		System.out.println("i: "+i);
		i++;
		System.out.println("i: "+i);
		long l = Long.MAX_VALUE; // 8-byte, [-9223372036854775808,9223372036854775807]
		System.out.println("l: "+l);
		l++;
		System.out.println("l: "+l);
		// Immutable Class 
		BigInteger bi = BigInteger.valueOf(Long.MAX_VALUE);
		System.out.println("bi: "+bi.toString());
		bi = bi.add(BigInteger.ONE);
		System.out.println("bi: "+bi.toString());
		int d = Integer.MAX_VALUE;
		long veryLong = d + 1L;
		System.out.println(veryLong);
		long m = 12345 + 5432L;
		System.out.println(m);
		var infinity = 1/0; // ALU
		System.out.println(infinity);
	}

}
