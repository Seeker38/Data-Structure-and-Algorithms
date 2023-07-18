package Java.tuan2;

import java.util.Scanner;

public class Bai2 {
    static int count1 =0;
    static int count2 =0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = input(n); // nhap random
        // int[] arr = input(sc);  // nhap tay
        sc.close();
        System.out.println("day ban dau:");
        print(arr);

        sort(arr);

        System.out.println("so lan so sanh= " + getComparisons());
        System.out.println("so lan doi cho= " + getSwaps() );
          
    }
    public static void sort( int[] arr){

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                count1++;
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                count2++;
            }
            System.out.println("sau lan " + (i + 1) + ": ");
            print(arr);
            
        }
        System.out.println("ket qua:");
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

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                count1++;
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                count2++;
            }
            
        }
        
        return arr;
    }

    public static long getRunTime(int[] arr){
        long startTime = System.nanoTime();

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }  
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
