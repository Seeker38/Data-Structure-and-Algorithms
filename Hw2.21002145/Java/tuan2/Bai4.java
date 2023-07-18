package Java.tuan2;
// chay 3 vi du n=10, n= 20, n = 50 

import java.util.Arrays;

/* nop file txt ve:
    ex1: n = 
    * Thuat toan:
        + so lan so sanh:
        + so lan da doi cho:
        + thoi gian chay (nanoS):

    ex2:
    ex3:
*/ 




public class Bai4 {
    public static void main(String[] args) {
        // int[] sortedArr = input(10);
        // int[] sortedArr = input(20);
         int[] sortedArr = input(50);
        System.out.println("n = " + sortedArr.length );
        System.out.println("Day ban dau: " + Arrays.toString(sortedArr));

        Bai1 bubbleSort = new Bai1();
        bubbleSort.sortedArr(sortedArr.clone());
        System.out.println("Thuat toan Bubble Sort");
        System.out.println("    so lan so sanh: " + bubbleSort.getComparisons());
        System.out.println("    so lan da doi cho: " + bubbleSort.getSwaps());
        System.out.println("    thoi gian chay (nanoS): " + bubbleSort.getRunTime(sortedArr));

        Bai2 selectionSort = new Bai2();
        selectionSort.sortedArr(sortedArr.clone());
        System.out.println("Thuat toan selection Sort");
        System.out.println("    so lan so sanh: " + selectionSort.getComparisons());
        System.out.println("    so lan da doi cho: " + selectionSort.getSwaps());
        System.out.println("    thoi gian chay (nanoS): " + selectionSort.getRunTime(sortedArr));

        Bai3 insertionSort = new Bai3();
        insertionSort.sortedArr(sortedArr.clone());
        System.out.println("Thuat toan insertion Sort");
        System.out.println("    so lan so sanh: " + insertionSort.getComparisons());
        System.out.println("    so lan da doi cho: " + insertionSort.getSwaps());
        System.out.println("    thoi gian chay (nanoS): " + insertionSort.getRunTime(sortedArr));


        if (bubbleSort.getComparisons() < selectionSort.getComparisons()
                && bubbleSort.getComparisons() < insertionSort.getComparisons()) {
            System.out.println("Bubble Sort thuc hien tot nhat o phan so sanh.");
        } else if (selectionSort.getComparisons() < bubbleSort.getComparisons()
                && selectionSort.getComparisons() < insertionSort.getComparisons()) {
            System.out.println("Selection Sort thuc hien tot nhat o phan so sanh.");
        } else {
            System.out.println("Insertion Sort thuc hien tot nhat o phan so sanh.");
        }

        if (bubbleSort.getSwaps() < selectionSort.getSwaps() && bubbleSort.getSwaps() < insertionSort.getSwaps()) {
            System.out.println("Bubble Sort thuc hien tot nhat o phan doi cho.");
        } else if (selectionSort.getSwaps() < bubbleSort.getSwaps() && selectionSort.getSwaps() < insertionSort.getSwaps()) {
            System.out.println("Selection Sort thuc hien tot nhat o phan doi cho.");
        } else {
            System.out.println("Insertion Sort thuc hien tot nhat o phan doi cho.");
        }



    }
    public static int[] input(int n){
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() *100);
         }
         return arr;
    }
    
    // public static void printResult(Bai1 bubbleSort, Bai2 selectionSort, Bai3 insertionSort){
    //     System.out.println("Thuat toan Bubble Sort:");
    //     System.out.println("    Bubble Sort Comparisons: " + bubbleSort.getComparisons());
    //     System.out.println("    Bubble Sort Swaps: " + bubbleSort.getSwaps());
    //     System.out.println("    thoi gian chay (nanoS): " + bubbleSort.getRunTime());

    // }
}
