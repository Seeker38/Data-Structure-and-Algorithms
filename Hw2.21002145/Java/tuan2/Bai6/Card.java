package Java.tuan2.Bai6;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import Java.tuan2.Bai5;


// spade , club, diamond, heart

enum Suit {
	SPADE, CLUB, DIAMOND, HEART
}


public class Card implements Comparable<Card> {
	
	private int rank;
	private Suit suit;
	
	public Card(int r, Suit s) {
		rank = r;
		suit = s;
	}
	
	public int getRank() {
		return rank;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public String rankToString(int rank) {
		switch (rank) {
		case 1: return "A";
		case 2: return "2";
		case 3: return "3";
		case 4: return "4";
		case 5: return "5";
		case 6: return "6";
		case 7: return "7";
		case 8: return "8";
		case 9: return "9";
		case 10: return "10";
		case 11: return "J";
		case 12: return "Q";
		case 13: return "K";
		default: return "Invalid card";
	}
}
	public String toString() {
		return rankToString(rank) + " ­of " + suit;
	}
	
	public void showCard() {
		System.out.println(toString());
	}
		
	public int getIndex() {
		switch (this.suit) {
		case SPADE: return 0;
		case CLUB: return 1;
		case DIAMOND: return 2;
		case HEART: return 3;
		default:
			throw new IllegalArgumentException("Unexpected value: " + this.suit);
		}
	}
	@Override
	public int compareTo(Card otherCard) {
		if (this.getRank()>otherCard.getRank())
			return 1;
		else if(this.getRank()<otherCard.getRank())
			return -1;
		else {
			if (this.getIndex()>otherCard.getIndex())
				return 1;
			if (this.getIndex()<otherCard.getIndex())
				return -1;
		}
		return 0;
	
	}
	
	// Generate 52 cards in deck
	public static Card[] generate() {
		Card[] cards = new Card[52];
		int index = 0;
		for(int i=1;i<14;i++) { 
			for(Suit suit: Suit.values()) {
				Card card = new Card(i, suit);
				cards[index] = card;
				index += 1;
			}
		}
		return cards;
	}
	
	// Function for printing elements of array
	public static void printOut(Card[] cards) {
		for (int i=0; i<cards.length; i++) {
			System.out.print(cards[i].toString() + ", ");
		}
		System.out.println();
	}
	
	// Function for shuffling cards
	public static Card[] shuffle(Card[] cards) {
		System.out.println("Shuffle your cards:");
		Random rand = new Random();
		int length = cards.length;
		for (int i=0; i<length; i++) {
			int randInt = rand.nextInt(length);
			// Swap random two element in array
			Card temp = cards[i];
			cards[i] = cards[randInt];
			cards[randInt] = temp;
		}
		return cards;
	}
	
	public static void main(String args[]) {
		
		// Generate deck and print
		Card[] deck = generate();
		System.out.println("Generate deck: ");
		printOut(deck);
		
		// shuffle cards and print
		shuffle(deck);
		printOut(deck);
		
		// SORTING CARD USING COMPARATOR
		System.out.println("Sort cards using Comparator:");
		Arrays.sort(deck, new compareCard());
		printOut(deck);
		
		/* SORTING CARDS USING METHOD IN EXERCISE 5 (COMPARABLE) */
		System.out.println("USING METHOD IN EXERCISE 5");
		Bai5<Card> sort = new Bai5<>(deck);
		
		// Bubble sort
		shuffle(deck);
		printOut(deck);
		System.out.println("BUBBLE SORT");
		sort.bubbleSort();
        for (Card card : deck) {
            System.out.print(card + " ");
         }
         System.out.println();
		
		
		// Selection sort
		shuffle(deck);
		printOut(deck);
		System.out.println("SELECTION SORT");
		sort.selectionSort();
		for (Card card : deck) {
            System.out.print(card + " ");
         }
         System.out.println();
		
		// Insertion sort
		shuffle(deck);
		printOut(deck);
		System.out.println("INSERTION SORT");
		sort.insertionSort();
		for (Card card : deck) {
            System.out.print(card + " ");
         }
         System.out.println();
		
	}
	
}