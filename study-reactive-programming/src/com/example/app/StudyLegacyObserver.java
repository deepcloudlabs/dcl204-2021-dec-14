package com.example.app;

import java.util.List;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

import com.example.domain.TradeEvent;
import com.example.events.TradeEventObservable;

@SuppressWarnings("deprecation")
public class StudyLegacyObserver {

	public static void main(String[] args) {
		var trades = List.of(
				new TradeEvent("orcl", 100.0, 1_000),
				new TradeEvent("msft", 100.0, 1_000),
				new TradeEvent("ibm", 100.0, 1_000),
				new TradeEvent("gogle", 100.0, 1_000),
				new TradeEvent("msft", 100.0, 1_000)
		);
		Observer slowObserver = (o,event) -> {
			try {TimeUnit.SECONDS.sleep(3);}catch (Exception e) { }
			System.err.println("Slow observer: "+event);
		};
		Observer fastObserver = (o,event) -> {
			System.err.println("Fast observer: "+event);
		};
		var observable = new TradeEventObservable();
		observable.addObserver(slowObserver);
		observable.addObserver(fastObserver);
		trades.forEach(observable::notifyObservers);
		System.err.println("Application is done.");
	}

}
