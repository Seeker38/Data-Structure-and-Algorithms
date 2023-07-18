package Hw6_21002145.Bai1;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueueTest {

    public static void main(String[] args) {
        // Test with list of integers
        System.out.println("Testing UnsortedArrayPriorityQueue with list of integers:");
        PriorityQueueInterface<Integer, Integer> queue1 = new UnsortedArrayPriorityQueue<>();
        List<Integer> listInt1 = new ArrayList<>();
        listInt1.add(5);
        listInt1.add(2);
        listInt1.add(9);
        listInt1.add(1);
        listInt1.add(7);
        listInt1.forEach(num -> queue1.insert(num, num));
        while (!queue1.isEmpty()) {
            Entry<Integer, Integer> entry = queue1.removeMin();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        System.out.println("\nTesting SortedArrayPriorityQueue with list of integers:");
        PriorityQueueInterface<Integer, Integer> queue2 = new SortedArrayPriorityQueue<>();
        List<Integer> listInt2 = new ArrayList<>();
        listInt2.add(5);
        listInt2.add(3);
        listInt2.add(9);
        listInt2.add(0);
        listInt2.add(6);
        for (Integer i : listInt2) {
            queue2.insert(i, i);
        }
        while (!queue2.isEmpty()) {
            Entry<Integer, Integer> entry = queue2.removeMin();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // Test with list of objects
        System.out.println("\nTesting SortedLinkedPriorityQueue with list of objects:");
        PriorityQueueInterface<Double, String> queueObj1 = new SortedLinkedPriorityQueue<>();
        List<Good> listObj1 = new ArrayList<>();
        listObj1.add(new Good("Apple", 2.5));
        listObj1.add(new Good("Orange", 1.8));
        listObj1.add(new Good("Banana", 3.2));
        listObj1.add(new Good("Grapes", 2.9));
        listObj1.add(new Good("Watermelon", 5.5));
        listObj1.forEach(good -> queueObj1.insert(good.getPrice(), good.getName()));
        while (!queueObj1.isEmpty()) {
            Entry<Double, String> entry = queueObj1.removeMin();
            System.out.println("price: " + entry.getKey() + ", name of goods: " + entry.getValue());
        }

        System.out.println("\nTesting UnsortedLinkedPriorityQueue with list of objects:");
        PriorityQueueInterface<Double, String> queueObj2 = new UnsortedLinkedPriorityQueue<>();
        List<Good> listObj2 = new ArrayList<>();
        listObj2.add(new Good("Apple", 2.5));
        listObj2.add(new Good("Banana", 1.8));
        listObj2.add(new Good("Orange", 3.1));
        listObj2.add(new Good("Grapes", 4.2));
        listObj2.add(new Good("Watermelon", 5.5));
        for (Good g : listObj2) {
            queueObj2.insert(g.getPrice(), g.getName());
        }
        while (!queueObj2.isEmpty()) {
            if (queueObj2.min() != null) {
                Entry<Double, String> entry = queueObj2.removeMin();
                System.out.println("price: " + entry.getKey() + ", name of goods: " + entry.getValue());
            }
        }

    }

    static class Good {
        private String name;
        private double price;

        public Good(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }
}