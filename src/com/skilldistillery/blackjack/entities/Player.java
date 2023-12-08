package com.skilldistillery.blackjack.entities;

public class Player {
	BlackjackHand hand = new BlackjackHand();
	
	public Player() {
		hand = new BlackjackHand();
	}
	
	public BlackjackHand getHand() {
		return hand;
	}
	
	public int getHandValue() {
		return hand.getHandValue();
	}

	public void hit(Dealer d) {
		d.deal(hand);
	}
	
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Your hand:");
		builder.append(hand);
		builder.append(", hand value: ");
		builder.append(hand.getHandValue());
		return builder.toString();
	}
	
	public boolean checkBlackjack() {
		return hand.isBlackjack();
	}
	
	public boolean checkBust() {
		return hand.isBust();
	}
}
