package Hw6_21002145.Bai2;

import Hw6_21002145.Bai1.Entry;
import Hw6_21002145.Bai1.SortedArrayPriorityQueue;

public class MinHeapPriorityQueue<K extends Comparable<K>, E> extends SortedArrayPriorityQueue<K, E> {
    private ArrEntry<K, E>[] heapPQ;
    private int defaultSize = 10000000;
    int n;

    public MinHeapPriorityQueue() {
        heapPQ = (ArrEntry<K, E>[]) new ArrEntry[defaultSize];
        n = 0;
    }

    public MinHeapPriorityQueue(int capacity) {
        heapPQ = (ArrEntry<K, E>[]) new ArrEntry[capacity];
        n = 0;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        if (n == heapPQ.length) {
            throw new IllegalStateException("Priority queue is full");
        }
        ArrEntry<K, E> arrEntry = (ArrEntry<K, E>) entry;
        heapPQ[n] = arrEntry;
        upHeap(n);
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
        Entry<K, E> minEntry = heapPQ[0];
        heapPQ[0] = heapPQ[n - 1];
        heapPQ[n - 1] = null;
        n--;
        downHeap(0);
        return minEntry;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            return null;
        }
        return heapPQ[0];
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    protected void upHeap(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heapPQ[index].getKey().compareTo(heapPQ[parentIndex].getKey()) >= 0) {
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    protected void downHeap(int index) {
        while (true) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            if (leftChildIndex >= n) {
                break;
            }
            int smallerChildIndex = leftChildIndex;
            if (rightChildIndex < n
                    && heapPQ[rightChildIndex].getKey().compareTo(heapPQ[leftChildIndex].getKey()) < 0) {
                smallerChildIndex = rightChildIndex;
            }
            if (heapPQ[index].getKey().compareTo(heapPQ[smallerChildIndex].getKey()) <= 0) {
                break;
            }
            swap(index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }

    private void swap(int i, int j) {
        ArrEntry<K, E> temp = heapPQ[i];
        heapPQ[i] = heapPQ[j];
        heapPQ[j] = temp;
    }

}
