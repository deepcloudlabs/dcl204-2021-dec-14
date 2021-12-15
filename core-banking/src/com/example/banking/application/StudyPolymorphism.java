package com.example.banking.application;

import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;

import com.example.banking.domain.Account;
import com.example.banking.domain.CheckingAccount;

@SuppressWarnings("unused")
public class StudyPolymorphism {

	public static void main(String[] args) {
		Account acc;
		if (ThreadLocalRandom.current().nextBoolean()) {
			acc = new Account("tr1", 100_000);
		} else {
			acc = new CheckingAccount("tr1", 100_000,5_000);
		}
		System.err.println(acc.getClass().getName());
		acc.withdraw(10_000); 
		Account []accounts = {
				new Account("tr1", 100_000),
				new CheckingAccount("tr1", 100_000,5_000),
				new Account("tr3", 300_000)
		};
		var sum = 0.0;
		for (var account : accounts)
			sum += account.getBalance();
		Object o;
		o=42;
		o="Jack";
		o=true;
		o=BigInteger.valueOf(1);
		o='x';
		o=3.14;
		o= new Account("tr5");
		o.toString();
		o.equals(42);
		o.hashCode();
		o.getClass();
	}

}
