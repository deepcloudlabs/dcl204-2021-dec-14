package com.example.banking.application;

import com.example.banking.domain.Account;
import com.example.banking.domain.CheckingAccount;
import com.example.banking.domain.Customer;
import com.example.banking.domain.InsufficientBalanceException;

// Ctrl + Shift + O : Organize Import
// main -> Ctrl + Space
public class BankingApp {
	public static void main(String[] args) {
		Customer jack = new Customer("1", "jack bauer");
		jack.addAccount(new Account("tr1",100_000));
		jack.addAccount(new CheckingAccount("tr2",100_000,1_000));
		jack.getAccount("tr3").ifPresent(account -> account.deposit(1_000));
		
		{
			{
			   String tr1 = "tr1"; 
			   CheckingAccount acc = new CheckingAccount(tr1, 100_000,10); // Stack/Automatic,Reference variable
			   System.out.println(acc);
			   System.out.println(tr1);
			   try {
				acc.withdraw(50_000);
			} catch (InsufficientBalanceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Account::withdraw
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
