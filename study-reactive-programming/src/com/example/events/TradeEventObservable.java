package com.example.events;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class TradeEventObservable extends Observable {

	@Override
	public void notifyObservers(Object event) {
		setChanged();
		super.notifyObservers(event);
	}

}
