package com.example.banking.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class AccountTest {

	@Test
	@DisplayName("create an account successfuly")
	void createAccountSuccess() {
		// 1. Test Setup/Fixture
		Account acc
		// 2. Call exercise method
				= new Account("tr1", 10_000);
		// 3. Verification
		assertAll(() -> {
			assertEquals(10_000, acc.getBalance());
		}, () -> {
			assertEquals("tr1", acc.getIban());
		});
		// 4. Tear-down
	}

	@Test
	@DisplayName("deposit with negative amount should fail")
	void deposit_negativeAmountShouldFail() throws Exception {
		Account acc = new Account("tr1", 10_000);
		assertThrows(IllegalArgumentException.class, () -> acc.deposit(-10));
		assertEquals(10_000, acc.getBalance());
	}

	@Test
	void withdraw_positiveAmountShouldSuccess() throws Exception {
		Account acc = new Account("tr1", 2);
	    acc.withdraw(1.1);
		assertEquals(0.9, acc.getBalance(), 0.001);
	}

	@Test
	void withdraw_overBalanceShouldFail() throws Exception {
		Account acc = new Account("tr1", 2_000);
		assertThrows(InsufficientBalanceException.class, () -> acc.withdraw(2001));
		assertEquals(2_000, acc.getBalance(), 0.001);
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "deposit.csv")
	@DisplayName("deposit with positive amount should success")
	void deposit_positiveAmountShouldSuccess(String iban, double balance, double amount, double newBalance)
			throws Exception {
		Account acc = new Account(iban, balance);
		acc.deposit(amount);
		assertEquals(newBalance, acc.getBalance());
	}
}
