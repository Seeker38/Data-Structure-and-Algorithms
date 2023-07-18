package Hw4_21002145;

import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E> {
    class Node {
        E element;
        Node next;
    }

    Node stack = null;

    @Override
    public void push(E element) {
        // Thêm một phần tử vào stack
        Node newNode = new Node();
        newNode.element = element;
        newNode.next = stack;
        stack = newNode;

    }

    @Override
    public E pop() {
        // Lấy một phần tử khỏi stack
        if (isEmpty()) {
            return null;
        }
        E element = stack.element;
        stack = stack.next;
        return element;
    }

    @Override
    public boolean isEmpty() {
        // Kiểm tra stack rỗng
        return stack == null;
    }

    @Override
    public E top() {
        // Lấy giá trị phần tử đầu tiên của stack

        if (isEmpty()) {
            return null;
        }
        return stack.element;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return new StackIterator();
    }

    class StackIterator implements Iterator<E> {
        private Node currentNode = stack;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return currentNode != null;
        }

        @Override
        public E next() {
            // TODO Auto-generated method stub
            E data = currentNode.element;
            currentNode = currentNode.next;
            return data;
        }
    }
}
