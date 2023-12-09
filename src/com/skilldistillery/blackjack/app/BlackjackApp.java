package com.skilldistillery.blackjack.app;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApp {

	private Player p;
	private Dealer d;
	private boolean isPlaying = true;
	private boolean pBust;
	private Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		app.run();
	}

	public void run() {
		kb = new Scanner(System.in);

		do {
			p = new Player();
			d = new Dealer();
			pBust = false;

			startGame();
			if (!d.checkBlackjack() && !p.checkBlackjack()) {
				playerTurn(kb);
				d.showHand();
				if (!pBust) {
					printHands();
					dealerTurn();
				}
				printHands();
				d.determineWinner(p);
			}
			keepPlaying(kb);
		}
		while (isPlaying);

	}

	public void keepPlaying(Scanner kb) {
		String answer;
		System.out.println("Would you like to play again?");
		System.out.println("Enter 'y' to play again or 'n' to stop");
		try {
			answer = kb.nextLine();
			if (answer.equals("y")) {
				return;
			}
			else if (answer.equals("n")) {
				System.out.println("Ending program, goodbye!");
				isPlaying = false;
				return;
			}
			else {
				throw new InputMismatchException();
			}
		}
		catch (InputMismatchException e) {
			System.out.println("invalid input, playing again");
		}

	}

	public void dealerTurn() {
		boolean stay = false;
		int handValue = d.getHandValue();
		while (!stay) {
			if (handValue >= 17) {
				System.out.println("Dealer stays!");
				stay = true;
			}
			else {
				System.out.println("Dealer hits!");
				d.hit(d);
				handValue = d.getHandValue();
				printDealerHand();
				if (d.checkBust()) {
					System.out.println("Dealer busts!");
					return;
				}

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
					if (p.checkBust()) {
						System.out.println("you bust!");
						pBust = true;
						return;
					}
					printPlayerHand(p);
					break;
				case "Stay":
				case "stay":
					stay = true;
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

		if (!p.checkBlackjack() && !d.checkBlackjack()) {
			printHands();
			return;
		}
		if (p.checkBlackjack()) {
			System.out.println("You hit Blackjack!");
		}
		if (d.checkBlackjack()) {
			System.out.println("Dealer hit Blackjack!");
		}
		d.showHand();
		printHands();
		d.determineWinner(p);
	}

	public void printHands() {
		printPlayerHand(p);
		printDealerHand();
	}

	public void printPlayerHand(Player p) {
		System.out.println(p);
	}

	public void printDealerHand() {
		System.out.println(d);
	}

}
