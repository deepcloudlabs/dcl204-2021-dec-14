package com.example;

public class StudyChangesInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

interface Fun { // 1.3 -> 2.0
	void haveFun();
	void haveGun();
	// 1. default method
	default void haveSun1() {
		test1();
	};
	default void haveSun2() {
		test1();
	};
	// 2. static method -> FP -> Utility Method 
	static void haveRun() {
		test2();
	}
	// Java 9
	private void test1() {}
	private static void test2() {}
}

class MyAppClass implements Fun {

	@Override
	public void haveFun() {
	}

	@Override
	public void haveGun() {
	}
	
}

interface I1 {
	default void fun(int x) {}
}

interface I2 {
	default void fun() {}
}

class ABC implements I1, I2 {

	
}