package com.example.banking.domain;

public class StudyEnum {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		AccountStatus as = AccountStatus.BLOCKED;
		System.out.println(as.name());
		System.out.println(as.ordinal());
		for (var accountStatus: AccountStatus.values()) {
			System.out.println(accountStatus.name()+": "+accountStatus.ordinal());			
		}
		var blockedStatus = AccountStatus.valueOf("BLOCKED");
	}

}
