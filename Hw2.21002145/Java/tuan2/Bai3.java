package Java.tuan2;

import java.util.Scanner;

public class Bai3 {
    static int count1 =0;
    static int count2 =0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = input(n);   // nhap random
        // int[] arr = input(sc);  // nhap tay
        sc.close();
        System.out.println("day ban dau:");
        print(arr);
        InsertionSort(arr);

        System.out.println("so lan so sanh= " + getComparisons());
        System.out.println("so lan doi cho= " + getSwaps());
          
    }
    public static void InsertionSort( int[] arr){

        int n = arr.length;

        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
 
            
            while (j >= 0 && arr[j] > key) {
                count1 ++;
                arr[j + 1] = arr[j];
                j = j - 1;
                

            }
            count2++;
            arr[j + 1] = key;
            System.out.println("sau lan " + i + ": ");
            print(arr);
        }
        System.out.println("Ket qua:");
        print(arr);
    
    }
    public static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static int[] input(Scanner sc){
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        return array;
    }
    public static int[] input(int n){
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() *100);
         }
         return arr;
    }
    public static int getComparisons(){
        return count1;
    }
    public static  int getSwaps(){
        return count2;
    } 


    // method for Bai4
    public static int[] sortedArr(int[] arr){
         int n = arr.length;

        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
             
            while (j >= 0 && arr[j] > key) {
                count1 ++;
                arr[j + 1] = arr[j];
                j = j - 1;
                

            }
            count2++;
            arr[j + 1] = key;
        }
        return arr;
    }

    public static long getRunTime(int[] arr){
        int n = arr.length;
        long startTime = System.nanoTime();

        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
                

            }
            arr[j + 1] = key;
        }   
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
