package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	
	protected List<Card> cards;

	public Hand() {
		cards = new ArrayList<Card>();
	}
	
	public void addCard(Card c) {
		cards.add(c);
	}
	
	public void clear() {
		cards = null;
	}
	
	public abstract int getHandValue();
}
