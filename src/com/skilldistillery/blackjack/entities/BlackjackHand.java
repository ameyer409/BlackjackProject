package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand{

	public BlackjackHand() {
		super();
	}
	
	@Override
	public int getHandValue() {
		int handValue = 0;
		for(Card c : cards) {
			handValue += c.getValue();
		}
		return handValue;
	}
	
	public boolean isBlackjack() {
		if(getHandValue() == 21) {
			return true;
		}
		return false;
	}
	
	public boolean isBust() {
		return false;
	}
	
//	public boolean isHard() {
//		return true;
//	}
//	
//	public boolean isSoft() {
//		return true;
//	}

}
