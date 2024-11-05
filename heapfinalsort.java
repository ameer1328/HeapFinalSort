package heapfinalsort;

import java.util.Arrays;

public class heapfinalsort {

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        System.out.println("Original array: " + Arrays.toString(array));

        heapSort(array);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    public static void heapSort(int[] array) {
        int n = array.length;

        // Build the max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
            printHeap(array, n, "Heap after building: "); // Visualization step
        }

        // Extract elements from the heap one by one
        for (int i = n - 1; i >= 0; i--) {
            // Swap current root with the end element
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Print array after each extraction step
            printHeap(array, i, "Heap after removing element: ");

            // Call heapify on the reduced heap
            heapify(array, i, 0);
        }
    }

    public static void heapify(int[] array, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // Left child index
        int right = 2 * i + 2; // Right child index

        // If left child is larger than root
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        // If right child is larger than the largest so far
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        // If largest is not the root, swap and continue heapifying
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(array, n, largest);
        }
    }

    public static void printHeap(int[] array, int size, String message) {
        System.out.println(message + Arrays.toString(Arrays.copyOfRange(array, 0, size)));
    }
}
