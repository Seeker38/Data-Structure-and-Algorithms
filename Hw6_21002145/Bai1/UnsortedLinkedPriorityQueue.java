package Hw6_21002145.Bai1;

@SuppressWarnings("unchecked")
public class UnsortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {

    protected class NodeEntry<K, E> implements Entry<K, E> {
        private K key;
        private E element;
        private NodeEntry<K, E> next;

        public NodeEntry(K k, E e) {
            this.key = k;
            this.element = e;
            this.next = null;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public E getValue() {
            return this.element;
        }
    }

    private NodeEntry<K, E> head;
    private NodeEntry<K, E> tail;
    private int n;

    public UnsortedLinkedPriorityQueue() {
        this.head = null;
        this.tail = null;
        this.n = 0;
    }

    @Override
    public int size() {
        return this.n;
    }

    @Override
    public boolean isEmpty() {
        return this.n == 0;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        NodeEntry<K, E> newNode = new NodeEntry<K, E>(entry.getKey(), entry.getValue());
        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            if (newNode.getKey().compareTo(this.head.getKey()) < 0) {
                newNode.next = this.head;
                this.head = newNode;
            } else {
                NodeEntry<K, E> current = this.head;
                while (current.next != null && current.next.getKey().compareTo(newNode.getKey()) < 0) {
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
                if (newNode.next == null) {
                    this.tail = newNode;
                }
            }
        }
        this.n++;
    }

    @Override
    public void insert(K k, E e) {
        Entry<K, E> entry = new NodeEntry<K, E>(k, e);
        insert(entry);
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            return null;
        }
        if (this.head == null) {
            return null;
        }
        NodeEntry<K, E> min = this.head;
        NodeEntry<K, E> pre = null;
        NodeEntry<K, E> current = this.head.next;
        NodeEntry<K, E> preMin = null;
        while (current != null) {
            if (current.getKey().compareTo(min.getKey()) < 0) {
                min = current;
                preMin = pre;
            }
            pre = current;
            current = current.next;
        }
        if (preMin == null) {
            this.head = min.next;
        } else {
            preMin.next = min.next;
        }
        if (min == this.tail) {
            this.tail = preMin;
        }
        this.n--;
        return min;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            return null;
        }
        NodeEntry<K, E> min = this.head;
        NodeEntry<K, E> current = this.head.next;
        while (current != null) {
            if (current.getKey().compareTo(min.getKey()) < 0) {
                min = current;
            }
            current = current.next;
        }
        return min;
    }

}
