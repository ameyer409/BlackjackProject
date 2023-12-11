# Blackjack Project

## How To Run
To run this program, start by pressing the play button. Then type 'hit' or 'stay' to input if you want more cards. After typing 'stay', the program will play for the dealer and complete.

## Project Overview
In the Blackjack game, the user plays a game of blackjack against the dealer(computer). The program will draw two cards from the deck for the player and dealer, one at a time. The player will be shown their hand, and one of the card sin the dealer's hand. The player will then be given the option to hit or stay. typing 'hit' draws another card from the deck and adds it to the player's hand. The player will continue to be prompted to hit or stay until they type 'stay' to end their turn, or bust (have a hand value of more than 21). 

Once the player's turn ends, the dealer's turn begins. The dealer plays by specific logic, and will continue to hit until they have a hand value of 17 or more. After the dealer plays, the program will compare the hand values and declare a winner.

Note: if either the player or dealer is dealt a hand with a value of 21 at the start of the game, this is considered a 'blackjack' and the game immediately ends in favor of the player who was dealt the hand. If both the player and dealer are dealt a blackjack, the round is a draw.

After the end of a round, the player is aske if they would like to play again. Typing 'y' reshuffles the deck, deals 2 new hands, and restarts the game. Typing 'n' ends the program. If the player types any other input, it will tell the user that the input is invalid and start a new game anyways (because this is Vegas and we want to take your money).

## Topics/Technologies Used
- APIE
- Enums
- Classes
- for loops
- if statements
- Scanner
- Superclass and Subclasses
- Arraylists
- toString methods
- @Override
- Abstract Classes and Methods
- getters and setters

## Lessons Learned
Something I learned while working on this was that the program can quickly grow complex when trying to follow the thread of actions through the various class structures present. I quickly realized that while not objectively necessary, it was helpful to my thought process to write a method in the player/dealer class that would just call a method from another class (such as the deck), which would in turn call another method. Even though it was extra typing, it helped me organize my thoughts and come up with solutions to the problems I was encountering. 