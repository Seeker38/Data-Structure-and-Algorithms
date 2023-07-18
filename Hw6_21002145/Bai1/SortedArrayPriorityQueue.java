package Hw6_21002145.Bai1;

@SuppressWarnings("unchecked")

public class SortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {
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

    private ArrEntry<K, E>[] array;
    private int n = 0;
    private int defaultSize = 1000;

    public SortedArrayPriorityQueue() {
        array = (ArrEntry<K, E>[]) new ArrEntry[defaultSize];
    }

    public SortedArrayPriorityQueue(int capacity) {
        array = (ArrEntry<K, E>[]) new ArrEntry[capacity];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        if (n == array.length) {
            throw new IllegalStateException("Priority queue is full");
        }
        ArrEntry<K, E> arrEntry = (ArrEntry<K, E>) entry;
        int i = n - 1;
        while (i >= 0 && array[i].getKey().compareTo(arrEntry.getKey()) > 0) {
            array[i + 1] = array[i];
            i--;
        }
        array[i + 1] = arrEntry;
        n++;
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
        Entry<K, E> minEntry = array[0];
        for (int i = 1; i < n; i++) {
            array[i - 1] = array[i];
        }
        array[n - 1] = null;
        n--;
        return minEntry;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            return null;
        }
        return array[0];
    }

}