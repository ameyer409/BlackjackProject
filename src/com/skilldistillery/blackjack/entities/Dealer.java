package com.skilldistillery.blackjack.entities;

import java.util.List;

public class Dealer extends Player {
	private Deck deck = new Deck();
	
	public void deal(BlackjackHand hand) {
		deck.dealCard(hand);
	}
	
	public void determineWinner(Player p) {
		if(p.checkBust()) {
			System.out.println("Dealer wins!");
			return;
		}
		else if(this.checkBust()) {
			System.out.println("You win!");
			return;
		}
		if (p.getHandValue() > this.getHandValue()) {
			System.out.println("You win!");
		}
		else if (p.getHandValue() < this.getHandValue()) {
			System.out.println("Dealer wins!");
		}
		else {
			System.out.println("It's a draw!");
		}
	}
	
	public void shuffleDeck() {
		deck.shuffle();
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dealer hand:");
		builder.append(hand);
		builder.append(", hand value: ");
		builder.append(hand.getHandValue());
		return builder.toString();
	}
	
	public void printDeck() {
		System.out.println(deck);
	}
	
	public void cardsLeftInDeck() {
		System.out.println(deck.cardsLeftInDeck());
	}
}
