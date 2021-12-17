package com.example.app;

public class Employee {
	private String identity;
	private String iban;
	private double salary;

	public Employee(String identity, String iban, double salary) {
		this.identity = identity;
		this.iban = iban;
		this.salary = salary;
	}

	public String getIdentity() {
		return identity;
	}

	public String getIban() {
		return iban;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Employee [identity=" + identity + ", iban=" + iban + ", salary=" + salary + "]";
	}

	
}
