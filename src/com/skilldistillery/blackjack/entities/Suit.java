package com.skilldistillery.blackjack.entities;

public enum Suit {
	HEART("Heart"),
	SPADE("Spade"),
	CLUB("Club"),
	DIAMOND("Diamond");
	
	Suit(String s) {
		name = s;
	}
	final private String name;
	
	@Override
	public String toString() {
		return name;
	}
}


