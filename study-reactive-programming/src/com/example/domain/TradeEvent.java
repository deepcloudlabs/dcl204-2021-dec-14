package com.example.domain;

// Immutable
// getter -> .symbol(), .price(), .quantity()
// toString()
// equals()
// hashCode()
public record TradeEvent(String symbol,double price,long quantity) { }
