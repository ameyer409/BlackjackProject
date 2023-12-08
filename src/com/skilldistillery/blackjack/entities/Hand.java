package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	
	protected ArrayList<Card> cards;

	public Hand() {
		cards = new ArrayList<Card>();
	}
	
	@Override
	public String toString() {
		return " " + cards;
	}

	public void addCard(Card c) {
		cards.add(c);
	}
	
	public void clear() {
		cards = null;
	}
	
	public abstract int getHandValue();
}
