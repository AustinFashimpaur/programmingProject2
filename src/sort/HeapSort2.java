package sort;

import java.util.Arrays;

/**
 * Represents a class that calculates the number of comparisons that Heap Sort uses for n number of elements. I could not determine the
 * expected number of comparisons via a formula; it was only given that we should expect more comparisons than Quick Sort (approximately twice
 * as much comparisons than Quick Sort). This behavior was not observed during experimentation, but I am confident that this is the correct
 * implementation of Heap Sort, and the number of comparisons is being calculated correctly. The worst-case time complexity for Heap Sort is
 * 2nLogn. On this view, we should expect to see a worse performance than Merge Sort and Quick Sort, which is what was observed during
 * experimentation.
 * <p>
 * Code Reference: https://www.geeksforgeeks.org/heap-sort/
 * <p>
 * I don't know if this code works properly, but I strongly believe it does. No more modifications should be made as of 03.03.2021
 *
 * @author me
 */
public class HeapSort2<T extends Comparable<T>> implements Sort<T> {

    int comparisonCount = 0;

    /**
     * @param arr
     */
    public SortResult<T> sort(T arr[]) {
        resetComparisons();
        T[] copy = Arrays.copyOf(arr, arr.length);
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            T temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }

        return new SortResult<>(comparisonCount, copy, arr);
    }

    private void resetComparisons() {
        comparisonCount = 0;
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    private void heapify(T arr[], int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l].compareTo(arr[largest]) > 0) {
            largest = l;
        } else if (r < n && arr[r].compareTo(arr[largest]) > 0) {
            largest = r;
            comparisonCount++;
        }
        comparisonCount++;

        // If largest is not root
        if (largest != i) {
            T swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
}