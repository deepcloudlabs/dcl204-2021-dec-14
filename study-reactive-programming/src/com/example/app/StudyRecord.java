package com.example.app;

import com.example.domain.TradeEvent;

public class StudyRecord {

	public static void main(String[] args) {
		var event = new TradeEvent("orcl",100,200);
		System.out.println(event.symbol());
	}

}
