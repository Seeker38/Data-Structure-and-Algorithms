package Hw5_21002145;

public class ArrayBinaryTree<E> implements BinaryTreeInterface<E> {
    private E[] array;
    private int n = 0;
    private int defaultsize = 100;

    public ArrayBinaryTree() {
        array = (E[]) new Object[defaultsize];
    }

    // update methods
    public void setRoot(E element) {
        // Set element to root of an empty tree
        if (n == 0) {
            array[0] = element;
            n = 1;
        } else {
            array[0] = element;
        }
    }

    public void setLeft(int p, E element) {
        // Set left child of p
        if (p >= n) {
            throw new IndexOutOfBoundsException();
        }

        int leftIndex = 2 * p + 1;
        if (leftIndex >= array.length) {
            expandCapacity();
        }

        array[leftIndex] = element;
        n = Math.max(n, leftIndex + 1);
    }

    public void setRight(int p, E element) {
        // Set right child of p
        if (p >= n) {
            throw new IndexOutOfBoundsException();
        }

        int rightIndex = 2 * p + 2;
        if (rightIndex >= array.length) {
            expandCapacity();
        }

        array[rightIndex] = element;
        n = Math.max(n, rightIndex + 1);
    }

    @Override
    public E root() {
        // TODO Auto-generated method stub
        if (isEmpty()) {
            return null;
        }

        return array[0];

    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return n;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return n == 0;
    }

    @Override
    public int numChildren(E p) {
        int index = indexOf(p);
        int count = 0;
        if (hasLeftChild(index)) {
            count++;
        }
        if (hasRightChild(index)) {
            count++;
        }
        return count;
    }

    @Override
    public E parent(E p) {
        // TODO Auto-generated method stub
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].equals(p)) {
                index = i;
                break;
            }
        }

        if (index == -1 || index == 0) {
            return null;
        }

        int parentIndex = (index - 1) / 2;
        return array[parentIndex];
    }

    @Override
    public E left(E p) {
        // TODO Auto-generated method stub
        int index = indexOf(p);
        return array[leftChildIndex(index)];
    }

    @Override
    public E right(E p) {
        // TODO Auto-generated method stub
        int index = indexOf(p);
        return array[rightChildIndex(index)];
    }

    @Override
    public E sibling(E p) {
        // TODO Auto-generated method stub
        int index = indexOf(p);
        if (isLeftChild(index)) {
            return array[rightChildIndex(parentIndex(index))];
        } else {
            return array[leftChildIndex(parentIndex(index))];
        }
    }

    private void expandCapacity() {
        E[] newArray = (E[]) new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    private int indexOf(E p) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].equals(p)) {
                return i;
            }
        }
        return -1;
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    private int leftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int rightChildIndex(int index) {
        return 2 * index + 2;
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) < n;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) < n;
    }

    private boolean isLeftChild(int index) {
        return index % 2 != 0;
    }

}