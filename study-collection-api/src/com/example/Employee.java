package com.example;

import java.util.Objects;

public class Employee extends Object {
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

	@Override
	public int hashCode() {
		return Objects.hash(identity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(identity, other.identity);
	}



	
}
