package Hw4_21002145;

import java.util.Iterator;

public class LinkedListQueue<E> implements QueueInterface<E> {

    private Node<E> front;
    private Node<E> rear;
    private int size;

    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    public LinkedListQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element, null);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Empty");
        }
        E data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public E first() {
        if (isEmpty()) {
            throw new RuntimeException("Empty");
        }
        return front.data;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListQueueIterator();
    }

    private class LinkedListQueueIterator implements Iterator<E> {
        private Node<E> current = front;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new RuntimeException("No more elements");
            }
            E data = current.data;
            current = current.next;
            return data;
        }
    }

}