package tutorials;

import java.util.*;



/**
 * Represents a class that calculates the number of comparisons that merge sort uses for n number of elements. The worst case number of
 * comparisons is given by the formula, { n log(n) - n + 1 }, where the log is base 2. For example, if we have 8 number of elements to sort,
 * then we should expect a worse case of 17 comparisons. Another example, if we have 6 elements to sort, then we should expect a worse case of
 * 11 elements to sort (rounding up). Additionally, merge sort has a worst-case time complexity of O(n log n). This means we should expect Merge
 * sort to have the best performance compared to Quick Sort, Heap Sort or Shaker Sort.
 * 
 * Reference: Reference: https://howtodoinjava.com/algorithm/merge-sort-java-example/
 * 
 * @author me
 *
 *This code functions properly.
 */
public class MergeSort {
	static int comparisonCount = 0;
	static int totalComparisons = 0;

	public static void main(String[] args) {

		// Create a an Integer array and initialize it with n number of random integers.
		/*
		 * int numElements = 8; Integer[] a = new Integer[numElements]; Random randNum = new Random(); for (int i = 0; i < numElements; i++) {
		 * a[i] = randNum.nextInt(100); }
		 */

		
		// Call merge sort
		
		Integer[] a = {2,5,1};
		mergeSort(a);

		// Check to see if the array is sorted and print the number of comparisons required to sort the array
		System.out.println(Arrays.toString(a));
		System.out.println("Comparison Count: " + MergeSort.comparisonCount);

	}
	
	
	
	
	/**
	 * Resets the comparison count to zero. This is used for testing purposes so the client can run
	 * the QuickSort algorithm multiple times via a while loop to ensure the comparison count does not
	 * exceed the expected worst-case value.
	 */
	public static void resetCount() {
		comparisonCount = 0;
	}
	
	/**
	 * This method returns the total number of comparisons made by MergeSort, which will depend on the number of times
	 * sort is called by the client. This method should be used to calculate the average number of compares.
	 * @return the total number of compares
	 */
	public static int  getTotalCompares() {
		return totalComparisons;
	}
	


	public static Integer[] mergeSort(Integer[] list) {
		// If list is empty; no need to do anything
		if (list.length <= 1) {
			return list;
		}

		// Split the array in half in two parts
		Integer[] first = new Integer[list.length / 2];
		Integer[] second = new Integer[list.length - first.length];
		System.arraycopy(list, 0, first, 0, first.length);
		System.arraycopy(list, first.length, second, 0, second.length);

		// Sort each half recursively
		mergeSort(first);
		mergeSort(second);

		// Merge both halves together, overwriting to original array
		merge(first, second, list);
		
		return list;
	}


	private static void merge(Integer[] first, Integer[] second, Integer[] result) {

		// Index Position in first array - starting with first element
		int iFirst = 0;

		// Index Position in second array - starting with first element
		int iSecond = 0;

		// Index Position in merged array - starting with first position
		int iMerged = 0;

		// Compare elements at iFirst and iSecond, and move smaller element at iMerged
		while (iFirst < first.length && iSecond < second.length) {
			if (first[iFirst].compareTo(second[iSecond]) < 0) {
				comparisonCount++;
				totalComparisons++;
				result[iMerged] = first[iFirst];
				iFirst++;

			} else {
				result[iMerged] = second[iSecond];
				iSecond++;
				comparisonCount++;
				totalComparisons++;
			}
			iMerged++;
		}
		// copy remaining elements from both halves - each half will have already sorted elements
		System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
		System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
	}
}