package com.example.banking.application;

import com.example.banking.domain.CheckingAccount;

// Ctrl + Shift + O : Organize Import
// main -> Ctrl + Space
public class BankingApp {
	public static void main(String[] args) {
		{
			{
			   String tr1 = "tr1"; 
			   CheckingAccount acc = new CheckingAccount(tr1, 100_000,10); // Stack/Automatic,Reference variable
			   System.out.println(acc);
			   System.out.println(tr1);
			   acc.withdraw(50_000); // Account::withdraw
			   acc.withdraw(25_000,100); // CheckingAccount::withdraw
			   acc.deposit(10_000);
			   System.out.println(String.format("%16s: %8.2f", acc.getIban(),acc.getBalance()));
			   System.out.println(acc.toString());
			}
			System.gc(); // Programmatically triggers GC
			// GC -> collects 'new Account("tr1", 100_000)'
		}
	}
}
