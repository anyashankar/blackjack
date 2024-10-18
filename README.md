## Blackjack 

This Java program implements a simple console-based Blackjack game.

## Features

- Single player vs. dealer gameplay
- Betting system with an initial balance of 1000 dollars
- Standard deck of 52 cards
- Hit or stand options for the player
- Dealer plays according to standard rules (must hit on 16 or below, stand on 17 or above)
- Blackjack (natural 21) detection
- Game continues until the player runs out of money or chooses to quit

## How to Play

1. Run the program.
2. Enter your bet amount when prompted.
3. You'll be dealt two cards, and the dealer will show one card.
4. Choose to "hit" or "stand" based on your hand.
5. After your turn, the dealer plays according to the rules.
6. The winner is determined, and your balance is updated.
7. Choose to play again or quit.

## Code Structure

- **Main class**: Contains the game logic and main method.
- **draw method**: Draws a random card from the deck.
- **total method**: Calculates the total value of a hand.
- **arrayHelpers class** (not shown): Assumed to contain helper methods for array operations.

## Usage

Compile and run the `Main.java` file. Follow the on-screen prompts to play the game.

- The game uses a simplified deck representation.
- Ace can count as 1 or 11, automatically choosing the best option.
- Blackjack pays 3:2.
- The game continues until the player runs out of money or chooses to quit.

Enjoy playing Blackjack!
