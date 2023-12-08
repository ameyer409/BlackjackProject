package com.skilldistillery.blackjack.entities;

public enum Suit {
	HEART("Hearts"),
	SPADE("Spades"),
	CLUB("Clubs"),
	DIAMOND("Diamonds");
	
	Suit(String s) {
		name = s;
	}
	final private String name;
	
	@Override
	public String toString() {
		return name;
	}
}


