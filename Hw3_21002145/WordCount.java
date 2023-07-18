package Hw3_21002145;

import java.util.Scanner;

public class WordCount {
    private String word;
    private int count;

    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void incrementCount() {
        count++;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WordCount other = (WordCount) o;
        return this.word.equals(other.word);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = scanner.nextLine();

        SimpleLinkedList<WordCount> list = new SimpleLinkedList<WordCount>();

        String[] words = text.split("\\s+");
        // using SimpleLinkedList
        for (String word : words) {
            WordCount wc = new WordCount(word, 1);
            if (list.isContain(wc)) {
                int index = list.indexOf(wc);
                WordCount wcInList = list.get(index);
                wcInList.incrementCount();
            } else {
                list.add(wc);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            WordCount wc = list.get(i);
            System.out.println(wc.getWord() + ": " + wc.getCount());
        }

        // using SimpleArrayList

        // SimpleArrayList<WordCount> array = new SimpleArrayList<WordCount>();
        // for (String word : words) {
        // WordCount wordCount = new WordCount(word, 1);
        // int index = array.indexOf(wordCount);
        // if (index == -1) {
        // array.add(wordCount);
        // } else {
        // WordCount existingWordCount = array.get(index);
        // existingWordCount.setCount(existingWordCount.getCount() + 1);
        // }
        // }

        // for (int i = 0; i < array.size(); i++) {
        // WordCount wordCount = array.get(i);
        // System.out.println(wordCount.getWord() + ": " + wordCount.getCount());
        // }
        scanner.close();
    }

}
