package com.example.banking.domain;

public enum AccountStatus {
	ACTIVE(10), CLOSED(20), BLOCKED(30);

	private final int code;

	private AccountStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

}
