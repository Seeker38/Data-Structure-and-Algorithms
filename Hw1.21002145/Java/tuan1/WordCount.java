package Java.tuan1;

import Java.tuan1.Bai6.SimpleArrayList;

public class WordCount  {
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

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof WordCount)) {
            return false;
        }
        WordCount other = (WordCount) o;
        return this.word.equals(other.word);
    }

    public static void main(String[] args) {
        SimpleArrayList<WordCount> arrayList = new SimpleArrayList<>();
        SimpleLinkedList<WordCount> linkedList = new SimpleLinkedList<>();


        WordCount wordCount = new WordCount("apple", 2);
        WordCount wordCount1 = new WordCount("banana", 1);
        
        arrayList.add(wordCount);
        arrayList.add(wordCount1);
        linkedList.add(wordCount);
        linkedList.add(wordCount1);

        arrayList.isContain(wordCount);

        System.out.println(linkedList.isContain(wordCount));

        System.out.println(arrayList.isEmpty());

        arrayList.remove(wordCount1);
        arrayList.isContain(wordCount1);
        arrayList.remove(wordCount);
        System.out.println(arrayList.isEmpty());

        }
    
}
