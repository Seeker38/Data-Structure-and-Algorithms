package Java.tuan1.Bai6;

import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int n = 0;
    private int defaultSize = 100;


    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    public SimpleArrayList(int capacity) {
    // Hàm dựng với kích thước mảng là capacity
        array = (T[]) new Object[capacity];
        
    }
    public void add(T data) {
        if (n == array.length) {
            T[] newArray = (T[]) new Object[2 * array.length];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[n++] = data;
    }
    public T get(int i) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException();
        }
        return array[i];
    }
    public void set(int i, T data) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException();
        }
        array[i] = data;
    }
    public void remove(T data) {
        int i = 0;
        while (i < n && !array[i].equals(data)) {
            i++;
        }
        if (i < n) {
            // shift elements to the left to fill the gap
            System.arraycopy(array, i + 1, array, i, n - i - 1);
            n--;
            // null out the last element to prevent memory leak
            array[n] = null;
        }
    }
    public void isContain(T data) {
        int temp =0;
        for (int i = 0; i < n; i++) {
            if (array[i].equals(data)) {
                
                temp =1;
                break;

            }
        }
        if (temp == 0){
            System.out.println("FALSE");
        }else{
            System.out.println("TRUE");
        }
    }
    public int size() {
        return n;
    }
    public boolean isEmpty() {
        if (n ==0){
            return true;
        }
        return false;
    }
    public Iterator<T> iterator() {
        return new SimpleArrayListIterator();
    }


    private class SimpleArrayListIterator implements Iterator<T> {
        private int i = 0;
    
        public boolean hasNext() {
            return i < n;
        }
    
        public T next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return array[i++];
        }
    
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}