package Hw6_21002145.Bai3;

import Hw6_21002145.Bai2.MinHeapPriorityQueue;

public class HeapSort {
    public static void sort(int[] nums) {
        MinHeapPriorityQueue<Integer, Integer> pq = new MinHeapPriorityQueue<>();

        // Build a min heap from the array
        for (int num : nums) {
            pq.insert(num, num);
        }

        // Extract the elements from the heap in sorted order
        for (int i = 0; i < nums.length; i++) {
            nums[i] = pq.removeMin().getValue();
        }
    }

    public static void sortWithHeapify(int[] nums) {
        // Build a max heap from the array using heapify
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            heapify(nums, nums.length, i);
        }

        // Extract the elements from the heap in sorted order
        for (int i = nums.length - 1; i >= 0; i--) {
            // Swap the root with the last element
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            // Restore the max heap property
            heapify(nums, i, 0);
        }
    }

    private static void heapify(int[] nums, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && nums[left] > nums[largest]) {
            largest = left;
        }

        if (right < n && nums[right] > nums[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = nums[i];
            nums[i] = nums[largest];
            nums[largest] = temp;

            heapify(nums, n, largest);
        }
    }
}