package Hw4_21002145;

import java.util.Iterator;

public class ArrayStack<E> implements StackInterface<E> {

    private E[] stack;
    private int top;

    public ArrayStack(int capacity) {
        stack = (E[]) new Object[capacity];
        top = -1;
    }

    @Override
    public void push(E element) {
        if (top == stack.length - 1) {
            throw new IllegalStateException("Stack is    full");
        }
        top++;
        stack[top] = element;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E element = stack[top];
        stack[top] = null;
        top--;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        }
        return stack[top];
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<E> {

        private int current = top;

        @Override
        public boolean hasNext() {
            return current >= 0;
        }

        @Override
        public E next() {
            E element = stack[current];
            current--;
            return element;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // for hanoi tower
    public E get(int i) {
        return stack[i];
    }
}