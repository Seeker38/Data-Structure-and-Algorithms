package Hw6_21002145.Bai1;

@SuppressWarnings("unchecked")

public class SortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {

    protected class NodeEntry<K, E> implements Entry<K, E> {
        private K key;
        private E element;
        private NodeEntry<K, E> next;

        public NodeEntry(K k, E e) {
            this.key = k;
            this.element = e;
            this.next = null;
        }

        public K getKey() {
            return this.key;
        }

        public E getValue() {
            return this.element;
        }

        public NodeEntry<K, E> getNext() {
            return this.next;
        }

        public void setNext(NodeEntry<K, E> next) {
            this.next = next;
        }
    }

    private NodeEntry<K, E> head;
    private int n;

    public SortedLinkedPriorityQueue() {
        this.head = null;
        this.n = 0;
    }

    public int size() {
        return this.n;
    }

    public boolean isEmpty() {
        return this.n == 0;
    }

    public void insert(Entry<K, E> entry) {
        K key = entry.getKey();
        E element = entry.getValue();
        NodeEntry<K, E> newNode = new NodeEntry<>(key, element);

        if (this.head == null) {
            this.head = newNode;
        } else {
            NodeEntry<K, E> current = this.head;
            NodeEntry<K, E> prev = null;

            while (current != null && key.compareTo(current.getKey()) > 0) {
                prev = current;
                current = current.getNext();
            }

            if (prev == null) {
                newNode.setNext(this.head);
                this.head = newNode;
            } else {
                prev.setNext(newNode);
                newNode.setNext(current);
            }
        }

        this.n++;
    }

    public void insert(K key, E element) {
        NodeEntry<K, E> newNode = new NodeEntry<>(key, element);
        insert(newNode);
    }

    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            return null;
        }

        NodeEntry<K, E> minNode = this.head;
        this.head = this.head.getNext();
        minNode.setNext(null);

        this.n--;

        return minNode;
    }

    public Entry<K, E> min() {
        if (isEmpty()) {
            return null;
        }

        return this.head;
    }
}