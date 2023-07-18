package Hw6_21002145.Bai1;

import java.util.Arrays;

@SuppressWarnings("unchecked")

public class UnsortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {

    protected class ArrEntry<K, E> implements Entry<K, E> {
        K key;
        E element;

        public ArrEntry(K k, E e) {
            this.key = k;
            this.element = e;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public E getValue() {
            return element;
        }
    }

    ArrEntry<K, E>[] array;
    int n = 0;
    int defaultsize = 1000;

    public UnsortedArrayPriorityQueue() {
        array = (ArrEntry<K, E>[]) new ArrEntry[defaultsize];
    }

    public UnsortedArrayPriorityQueue(int capacity) {
        array = (ArrEntry<K, E>[]) new ArrEntry[capacity];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        if (n == array.length) {
            array = Arrays.copyOf(array, 2 * array.length);
        }
        array[n++] = (ArrEntry<K, E>) entry;
    }

    @Override
    public void insert(K k, E e) {
        insert(new ArrEntry<>(k, e));
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            return null;
        }
        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (array[i].getKey().compareTo(array[minIndex].getKey()) < 0) {
                minIndex = i;
            }
        }
        Entry<K, E> minElement = array[minIndex];
        array[minIndex] = array[n - 1];
        array[n - 1] = null;
        n--;
        return minElement;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            return null;
        }
        Entry<K, E> minElement = array[0];
        for (int i = 1; i < n; i++) {
            if (array[i].getKey().compareTo(minElement.getKey()) < 0) {
                minElement = array[i];
            }
        }
        return minElement;
    }

}