package com.example.banking.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class Customer {
	private final String identity;
	private String fullname;
	private Map<String, Account> accounts = new HashMap<>();

	public Customer(String identity, String fullname) {
		this.identity = identity;
		this.fullname = fullname;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getIdentity() {
		return identity;
	}

	public Collection<Account> getAccounts() {
		return accounts.values();
	}

	public void addAccount(Account account) {
		accounts.put(account.getIban(), account);
	}

	public Optional<Account> getAccount(String iban) {
		return Optional.ofNullable(accounts.get(iban));
	}
}
