package Java.tuan1;

import java.util.Scanner;

public class Bai2<T> {

    private T[] a;
    private int size; 

    @SuppressWarnings("unchecked")
    public Bai2(int capacity) {
        a = (T[]) new Object[capacity];
        size = 0;
    }

    public void add(T element) {
        a[size++] = element;
    }

    public T get(int index) {
        return a[index];
    }

    public int size() {
        return size;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("so can tim: ");
        int x = sc.nextInt();
        sc.close();

        print(arr);
        findX(x, arr);

        print(sort(arr));

        Bai2<String> stringArray = new Bai2<>(5);
        stringArray.add("khoa hoc");
        stringArray.add("du lieu");
        for (int i = 0; i < stringArray.size(); i++) {
            System.out.println(stringArray.get(i));
        }

        Bai2<Integer> intArray = new Bai2<>(3);
        intArray.add(1);
        intArray.add(2);
        for (int i = 0; i < intArray.size(); i++) {
            System.out.println(intArray.get(i));
        }

    }



    public static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void findX( int x, int[] array){
        boolean temp = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x){
                System.out.println(x + " co o trong mang");
                temp = false;
                break;

                }
        }
        if ( temp == true){
            System.out.println(x + " khong co o trong mang");
        }
    }
    public static int[] sort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] < arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

}