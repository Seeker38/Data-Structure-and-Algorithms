package Hw6_21002145.Bai3;

import java.util.Arrays;
import java.util.Random;

public class CompareSortingAlgorithm {
    private static final int ARRAY_SIZE = 10000;

    public static void main(String[] args) {
        int[] arr = generateRandomArray();

        long startTime = System.currentTimeMillis();
        SelectionSort.sort(arr.clone());
        long endTime = System.currentTimeMillis();
        System.out.println("SelectionSort: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        HeapSort.sort(arr.clone());
        endTime = System.currentTimeMillis();
        System.out.println("HeapSort: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        QuickSort.sort(arr.clone());
        endTime = System.currentTimeMillis();
        System.out.println("QuickSort: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        MergeSort.sort(arr.clone());
        endTime = System.currentTimeMillis();
        System.out.println("MergeSort: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        BubbleSort.sort(arr.clone());
        endTime = System.currentTimeMillis();
        System.out.println("BubbleSort: " + (endTime - startTime) + "ms");
    }

    private static int[] generateRandomArray() {
        Random random = new Random();
        int[] arr = new int[ARRAY_SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }
    // private static void print(int[] arr) {
    // for (int i = 0; i < arr.length; i += 1){
    // System.out.print(arr[i] + " ");
    // }
    // System.out.println();
    // }

}
