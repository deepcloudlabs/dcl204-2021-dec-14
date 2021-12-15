package com.example.banking.domain;

// Super-class/Base-class: Account
// Sub-class/Derived-class: CheckingAccount
public class CheckingAccount extends Account {
	private double overdraftAmount;

	public CheckingAccount(String iban, double balance, double overdraftAmount) {
		super(iban, balance);
		this.overdraftAmount = overdraftAmount;
	}

	public double getOverdraftAmount() {
		return overdraftAmount;
	}

	// overloading: 
	// overriding
	//@Override
	public boolean withdraw(double amount,double test) {
		System.err.println("CheckingAccount::withdraw");
		if (amount<=0) return false;
		if (amount > (balance+overdraftAmount)) return false;
		balance -= amount;
		return true;
	}

}
