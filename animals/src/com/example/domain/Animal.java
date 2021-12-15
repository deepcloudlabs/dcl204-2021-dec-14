package com.example.domain;

public abstract class Animal {
	protected int legs;

	public Animal(int legs) {
		this.legs = legs;
	}

	public int getLegs() {
		return legs;
	}
	
	public void walk() {
		System.out.println(String.format("Animal with %d legs is walking...",this.legs));
	}
	
	public abstract void eat(); 
	//c++: virtual void eat() =0; 
}
