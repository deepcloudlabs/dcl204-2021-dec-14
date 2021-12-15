package com.example.domain;

public class Spider extends Animal {

	public Spider() {
		super(8);
	}

	@Override
	public void eat() {
		System.err.println("Spider is eating now...");
	}

}
