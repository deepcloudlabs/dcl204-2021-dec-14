package com.example.app;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import com.example.domain.TradeEvent;

public class StudyReactiveProgramming {

	public static void main(String[] args) {
		var trades = List.of(
				new TradeEvent("orcl", 100.0, 1_000),
				new TradeEvent("msft", 100.0, 1_000),
				new TradeEvent("ibm", 100.0, 1_000),
				new TradeEvent("gogle", 100.0, 1_000),
				new TradeEvent("msft", 100.0, 1_000)
		);
		var publisher = new SubmissionPublisher<TradeEvent>();
		publisher.subscribe(new SlowObserver());
		publisher.subscribe(new FastObserver());
		trades.forEach(publisher::submit);
		try {TimeUnit.SECONDS.sleep(25);}catch (Exception e) { }
		System.err.println("Application is done!");
		publisher.close();
	}

}

class SlowObserver implements Subscriber<TradeEvent> {

	private Subscription subscription;

	@Override
	public void onSubscribe(Subscription subscription) {
		System.err.println("Slow observer has subscribed.");
		this.subscription = subscription;
		subscription.request(1);
	}

	@Override
	public void onNext(TradeEvent event) {
		try {TimeUnit.SECONDS.sleep(3);}catch (Exception e) { }
		System.err.println("Slow observer: "+event);
		this.subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
		System.err.println("Error in slowObserver: "+throwable.getMessage());
	}

	@Override
	public void onComplete() {
		System.err.println("Slow observer is done!");
	}
	
}

class FastObserver implements Subscriber<TradeEvent> {
	
	private Subscription subscription;

	@Override
	public void onSubscribe(Subscription subscription) {
		System.err.println("Fast observer has subscribed.");	
		this.subscription = subscription;
		subscription.request(1);
	}
	
	@Override
	public void onNext(TradeEvent event) {
		System.err.println("Fast observer: "+event);			
		this.subscription.request(1);
	}
	
	@Override
	public void onError(Throwable throwable) {
		System.err.println("Error in fastObserver: "+throwable.getMessage());
	}
	
	@Override
	public void onComplete() {
		System.err.println("Fast observer is done!");
	}
	
}
