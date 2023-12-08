package com.skilldistillery.blackjack.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApp {

	private Player p;
	private Dealer d;
	private boolean isPlaying = true;
	private Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		app.run();
	}

	public void run() {
		p = new Player();
		d = new Dealer();
		kb = new Scanner(System.in);

		do {
			startGame();
			playerTurn(kb);
			dealerTurn();
		}
		while (isPlaying);

//		d.printDeck();
//		d.cardsLeftInDeck();
//		
//		p.hit(d);
//		printHands();

	}

	public void dealerTurn() {
		boolean stay = false;
		int handValue = d.getHandValue();
		while (!stay) {
			if (handValue >= 17) {
				return;
			}
			else {
				d.hit(d);
				printHands();
			}
		}
	}

	public void playerTurn(Scanner kb) {
		boolean stay = false;
		String option;
		while (!stay) {
			System.out.println("Hit or Stay?");
			try {
				option = kb.nextLine();
				switch (option) {
				case "Hit":
				case "hit":
					p.hit(d);
					printHands();
					break;
				case "Stay":
				case "stay":
					stay = true;
					printHands();
					break;
				default:
					throw new InputMismatchException();
				}
			}
			catch (InputMismatchException e) {
				System.out.println("Not a valid move");
			}

		}
	}

	public void startGame() {
		d.shuffleDeck();
		d.deal(p.getHand());
		d.deal(d.getHand());
		d.deal(p.getHand());
		d.deal(d.getHand());
		printHands();
		if (p.checkBlackjack() && d.checkBlackjack()) {
			System.out.println("Player & Dealer have BlackJack!");
			System.out.println("Draw!");
		}
		else if (p.checkBlackjack()) {
			System.out.println("You hit Blackjack!");
			System.out.println("You win!");
		}
		else if (d.checkBlackjack()) {
			System.out.println("Dealer hit Blackjack!");
			System.out.println("Dealer wins!");
		}
	}

	public void printHands() {
		System.out.println(p);
		System.out.println(d);
	}

}
