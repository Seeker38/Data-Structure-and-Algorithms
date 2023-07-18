package Java.tuan2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Bai7 {
    public static void main(String[] args) {
        int N = 10;
        int M = N + (int)(Math.random() * ((100 - N) + 1));

        // Generate N random integers between 1 and M with no duplicates
        ArrayList<Integer> randomIntegers = new ArrayList<>();
        Random rand = new Random();
        while (randomIntegers.size() < N) {
            int num = rand.nextInt(M) + 1;
            if (!randomIntegers.contains(num)) {
                randomIntegers.add(num);
            }
        }
        System.out.println("m = " + M);
        System.out.println("Random Integers: " + randomIntegers);

        // Create and shuffle a deck of 52 cards
        ArrayList<String> deck = new ArrayList<>();
        String[] suits = {"Spades", "Clubs", "Diamonds", "Hearts"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + " of " + suit);
            }
        }
        System.out.println("\nUnshuffled Deck:");
        for (String card : deck) {
            System.out.println(card);
        }
        Collections.shuffle(deck);
        System.out.println("\nShuffled Deck:");
        for (String card : deck) {
            System.out.println(card);
        }
    }
    // public static int getRandomInt(int max) {
    //     Random random = new Random();
    //     return random.nextInt(max) + 1;
    // }
}
