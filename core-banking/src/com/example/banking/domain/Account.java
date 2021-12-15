package com.example.banking.domain;

// Ctrl + Shift + + : Zoom in
// Ctrl + -         : Zoom out
// Ctrl + M
// Alt + Shift + S : Generate source code
// Ctrl + Shift + F : Format
// Ctrl + Alt + Down
public class Account extends Object {
	// permissions: private, public, protected, ***default***
	private final String iban; // reference, attribute/instance/heap/state, read-only variable
	// default permission/package-private
	double balance; // value, instance variable

	public Account(String iban /* reference, local */, final double balance /* value, local */) {
		super(); // No-arg Constructor
		this.iban = iban;
		this.balance = balance;
	}

	public Account(String iban)  {
		this(iban, 0.0);
	}
	
	public String getIban() {
		return iban;
	}

	public double getBalance() {
		return balance;
	}

	public boolean deposit(double amount) {
		// validation
		if (amount <= 0)
			return false;
		this.balance += amount;
		return true;
	}

	public boolean withdraw(double amount) {
		System.err.println("Account::withdraw");
		// validation
		if (amount <= 0)
			return false;
		// business rule
		if (amount > balance)
			return false;
		this.balance -= amount;
		return true;
	}

	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + "]";
	}


}