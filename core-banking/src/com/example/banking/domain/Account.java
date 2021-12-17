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
	private AccountStatus status;
	
	public Account(String iban /* reference, local */, final double balance /* value, local */) {
		super(); // No-arg Constructor
		this.iban = iban;
		this.balance = balance;
	}

	public Account(String iban)  {
		this(iban, 0.0);
	}
	

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	public String getIban() {
		return iban;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		// validation
		if (amount <= 0)
			throw new IllegalArgumentException("Amount should be a positive value");
		this.balance += amount;
	}

	// Exception: i) Runtime Exception (Unchecked) ii) Business Exception (Checked)
	public void withdraw(double amount) throws InsufficientBalanceException {
		System.err.println("Account::withdraw");
		// validation
		if (amount <= 0)
			throw new IllegalArgumentException("Amount should be a positive value");
		// business rule
		if (amount > balance)
			throw new InsufficientBalanceException("Your balance does not cover your expenses", amount-balance);
		this.balance -= amount;
	}

	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + "]";
	}


}