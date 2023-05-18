// Jackson Allaway jackson.allaway@oneidaihla.org
// for CTE software development 1
// instructor Mr Gross

package CardGame;

import java.util.ArrayList;

public class CardGame {
    public static void main(String[] args) {
        // Create an arraylist of cards to store in the deck
        // Loops through all the suits and adds cards A-K
        ArrayList<Card> cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }

        // Create a deck with contents cards and then shuffle it
        Deck deck = new Deck(cards);
        deck.shuffle(7);

        // Create an arraylist of hands
        ArrayList<Hand> hands = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            hands.add(new Hand(new ArrayList<Card>()));
        }

        // Deal cards to the hands
        for (int i = 0; i < 7; i++) {
            for (Hand hand : hands) {
                hand.addCard(deck.deal());
            }
        }

        // Print out the hands
        for (int i = 0; i < hands.size(); i++) {
            System.out.println("\nHand " + String.valueOf(i + 1));
            hands.get(i).printHand();
        }
    }
}

class Card {
    Rank rank;
    Suit suit;

    /**
     * A card with a rank and suit (e.g. ace of spades)
     * 
     * @param rank
     * @param suit
     */
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Get the information about the card in the format "rank of name"
     * 
     * @return the information in string format
     */
    public String getInfoString() {
        return rank.name() + " of " + suit.name();
    }
}

/**
 * An abstract class providing a basis for anything that holds Card objects
 */
abstract class CardSet {
    protected ArrayList<Card> cards = new ArrayList<>();

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }
}

class Deck extends CardSet {
    public Deck(ArrayList<Card> cards) {
        setCards(cards);
    }

    /**
     * Shuffles the deck by repeatedly iterating through and adding each card to
     * either the top or bottom of the deck
     * 
     * @param shuffles the number of times to repeat the shuffle
     */
    public void shuffle(int shuffles) {

        // Repeat for the number of shuffles to perform
        for (int i = 0; i < shuffles; i++) {
            // Create a temporary list to store the shuffled list
            ArrayList<Card> temp = new ArrayList<>();
            /*
             * For every card add it to the bottom of the temp list if
             * A random number is greater than 0.5 and otherwise
             * add it to the top
             */
            for (Card card : cards) {
                if (Math.random() > 0.5) {
                    temp.add(card);
                } else {
                    temp.add(0, card);
                }
            }

            // Replace the original list with the shuffled one
            cards = temp;
        }
    }

    /**
     * Remove and return the first item in the deck
     * 
     * @return the first card in the deck
     */
    public Card deal() {
        if (cards.size() > 0) {
            return cards.remove(0);
        } else {
            return null;
        }
    }
}

class Hand extends CardSet {

    /**
     * A class to store cards in a hand like format
     * 
     * @param cards an arraylist of cards contained in the hand
     */
    public Hand(ArrayList<Card> cards) {
        setCards(cards);
    }

    /**
     * Print out all of the cards in the hand in the format:
     * "This hand contains:
     *      rank of suit
     *      rank of suit..."
     */
    public void printHand() {
        System.out.println("This hand contains:");
        for (Card card : cards) {
            System.out.println("\t" + card.getInfoString());
        }
    }
}

/**
 * An enum of possible suits in a 52 card deck
 */
enum Suit {
    Hearts,
    Diamonds,
    Clubs,
    Spades,
}

/**
 * An enum of possible ranks a playing card can be of
 * cards 2-10 are prefixed with 'R'
 * 
 */
enum Rank {
    Ace,
    Two,
    Three,
    Four,
    Five,
    Six,
    Seven,
    Eight,
    Nine,
    Ten,
    Jack,
    Queen,
    King
}