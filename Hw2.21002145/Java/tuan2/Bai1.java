package Java.tuan2;

import java.util.Scanner;

public class Bai1 {
    static int count1 =0;
    static int count2 =0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        input.close();
        System.out.println("day ban dau:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        
        System.out.println();
        
        sort(arr);

        System.out.println("ket qua:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.println("so lan so sanh= " + getComparisons());
        System.out.println("so lan doi cho= " + getSwaps());

    }

    public static int getComparisons(){
        return count1;
    }
    public static  int getSwaps(){
        return count2;
    }

    public static void sort( int[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    count2++;
                }
                count1++;
            }
            System.out.println("sau lan " + (i + 1) + ": ");
            for (int k = 0; k < n; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();
        }
    }
    // method for Bai4
    public static int[] sortedArr(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    count2++;
                }
                count1++;
            }
        }
        return arr;
    }
    
    public static long getRunTime(int[] arr){
        int n = arr.length;
        long startTime = System.nanoTime();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }    
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}