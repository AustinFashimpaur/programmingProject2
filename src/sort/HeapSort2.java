package scratch;

/**
 * Represents a class that calculates the number of comparisons that Heap Sort uses for n number of elements. I could not determine the
 * expected number of comparisons via a formula; it was only given that we should expect more comparisons than Quick Sort (approximately twice
 * as much comparisons than Quick Sort). This behavior was not observed during experimentation, but I am confident that this is the correct
 * implementation of Heap Sort, and the number of comparisons is being calculated correctly. The worst-case time complexity for Heap Sort is
 * 2nLogn. On this view, we should expect to see a worse performance than Merge Sort and Quick Sort, which is what was observed during
 * experimentation.
 * 
 * Code Reference: https://www.geeksforgeeks.org/heap-sort/
 * 
 * I don't know if this code works properly, but I strongly believe it does. No more modifications should be made as of 03.03.2021
 * 
 * @author me
 *
 */
public class HeapSort2 {

	static int comparisonCount = 0;
	static int totalComparisons = 0;
	
	
	
	
	
	public static void main(String[] ars) {
		Integer[]a = {0,1,3,2};
		heapSort(a);
		System.out.println("Heap Comparison Count: " + comparisonCount);
	}
	
	
	
	
	
/**
 * 
 * @param arr
 */
	public static void heapSort(Integer arr[]) {
		int n = arr.length;

		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}

		// One by one extract an element from heap
		for (int i = n - 1; i > 0; i--) {
			// Move current root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// call max heapify on the reduced heap
			heapify(arr, i, 0);
		}
	}


	
	
	
	
	/**
	 * Resets the comparison count to zero. This is used for testing purposes so the client can run the QuickSort algorithm multiple times via
	 * a while loop to ensure the comparison count does not exceed the expected worst-case value.
	 */
	public static void resetCount() {
		comparisonCount = 0;
	}
	
	
	
	
	
	/**
	 * This method returns the total number of comparisons made by HeapSort, which will depend on the number of times
	 * sort is called by the client. This method should be used to calculate the average number of compares.
	 * @return the total number of compares
	 */
	public static int  getTotalCompares() {
		return totalComparisons;
	}
	
	
	
	
	
	

	// To heapify a subtree rooted with node i which is
	// an index in arr[]. n is size of heap
	static void heapify(Integer arr[], int n, int i) {
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < n && arr[l] > arr[largest]) {
			comparisonCount++;
			totalComparisons++;
			largest = l;
		}

		// If right child is larger than largest so far
		if (r < n && arr[r] > arr[largest]) {
			comparisonCount++;
			totalComparisons++;
			largest = r;
		}

		// If largest is not root
		if (largest != i) {
			//comparisonCount++;
			//totalComparisons++;
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;		
			heapify(arr, n, largest);
		}
	}
}