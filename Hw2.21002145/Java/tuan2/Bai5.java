package Java.tuan2;

import java.util.Arrays;
import java.util.Scanner;

public class Bai5<T extends Comparable<T>> {
    private int countComp=0, countSwap=0;
	private T[] arr;

    public T[] bubbleSort() {
		T[] arr = this.getArr();
		int length = arr.length;
		this.setComparisons(0);
		this.setSwaps(0);	
		
		for (int i=0; i<length; i++) {
			for (int j=1; j<length-i; j++) {

					this.countComp += 1;
				if (arr[j-1].compareTo(arr[j]) == 1) {
					T temp = arr[j-1];

					arr[j-1] = arr[j];
					arr[j] = temp;
					
					this.countSwap += 1;
				}
			}
		}
		return arr;
	}
	

	public T[] selectionSort() {
		T[] arr = this.getArr();
		int length = arr.length;

		this.setComparisons(0);
		this.setSwaps(0);	
		

		for (int i=length-1; i>=1; i--) {
			int maxIndex = i;
			for (int j=0; j<i; j++) {
				if (arr[j].compareTo(arr[maxIndex]) == 1) {
					maxIndex = j;
				}
				this.countComp += 1;
			}		

			T temp = arr[maxIndex];
			arr[maxIndex] = arr[i];	
			arr[i] = temp;

			this.countSwap += 1;
		}
		return arr;
	}
	
	// Implement insertion sort
	public T[] insertionSort() {
		T[] arr = this.getArr();
		int length = arr.length;

		this.setComparisons(0);
		this.setSwaps(0);	

		for (int i=1; i<length; i++) {
			T next = arr[i];
			for (int j=i-1; j>=0; j--) {
				// Swap
				if (arr[j].compareTo(next) == 1) {
					arr[j+1] = arr[j];
					arr[j] = next;
					this.countSwap += 1;
				}
				this.countComp += 1;
			}
		}
		return arr;
	}

    // public static void main(String[] args) {
    //     Integer[] arr = {5, 2, 8, 3, 1};
    //     Bai5<Integer> sort = new Bai5<>();
    //     sort.bubbleSort(arr.clone());
    //     sort.selectionSort(arr.clone());
    //     sort.insertionSort(arr.clone());
    // }
    // public static Integer[] input(int n){
    //     Integer[] arr = new Integer[n];

    //     for (int i = 0; i < arr.length; i++) {
    //         arr[i] = (int)(Math.random() *100);
    //      }
    //      return arr;
    // }
    // public static Integer[] input(Scanner sc){
    //     int n = sc.nextInt();
    //     Integer[] array = new Integer[n];
    //     for (int i = 0; i < array.length; i++) {
    //         array[i] = sc.nextInt();
    //     }
    //     return array;
    // }
   
	
	public Bai5(T[] arr) { 
		this.arr = arr;
	}
	
	// Getter and Setter	
	public T[] getArr() {
		return arr;
	}

	public void setArray(T[] arr) {
		this.arr = arr;
	}
	
	public int getComparisons() {
		return countComp;
	}
	
	public void setComparisons(int count_compare) {
		this.countComp = countComp;
	}

	public int getSwaps() {
		return countSwap;
	}

	public void setSwaps(int count_swap) {
		this.countSwap = countSwap;
	}

  
    public String toString(T[] arr) {
		String content = "";
		for (T element: arr) {
			content += element.toString();
		}
		return content;
	}
    public static Integer[] input(int n){
        Integer[] arr = new Integer[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() *100);
         }
         return arr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = input(n);
        sc.close();
        Bai5<Integer> sort = new Bai5<>(arr.clone());
        
        // Bubble Sort
        System.out.println("Bubble Sort:");
        Integer[] sortedArr = sort.bubbleSort();
        System.out.println("Sorted array: " + Arrays.toString(sortedArr));
        System.out.println("Comparisons: " + sort.getComparisons());
        System.out.println("Swaps: " + sort.getSwaps());
        
        // Selection Sort
        System.out.println("\nSelection Sort:");
        sort.setArray(arr.clone());
        sortedArr = sort.selectionSort();
        System.out.println("Sorted array: " + Arrays.toString(sortedArr));
        System.out.println("Comparisons: " + sort.getComparisons());
        System.out.println("Swaps: " + sort.getSwaps());
        
        // Insertion Sort
        System.out.println("\nInsertion Sort:");
        sort.setArray(arr.clone());
        sortedArr = sort.insertionSort();
        System.out.println("Sorted array: " + Arrays.toString(sortedArr));
        System.out.println("Comparisons: " + sort.getComparisons());
        System.out.println("Swaps: " + sort.getSwaps());
        

		
	}
    
}
