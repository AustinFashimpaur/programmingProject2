package sort;

import java.util.*;

/**
 * Represents a class that calculates the number of comparisons that merge sort uses for n number of elements. The worst case number of
 * comparisons is given by the formula, { n log(n) - n + 1 }, where the log is base 2. For example, if we have 8 number of elements to sort,
 * then we should expect a worse case of 17 comparisons. Another example, if we have 6 elements to sort, then we should expect a worse case of
 * 11 elements to sort (rounding up). Additionally, merge sort has a worst-case time complexity of O(n log n). This means we should expect
 * Merge sort to have the best performance compared to Quick Sort, Heap Sort or Shaker Sort.
 * 
 * Reference: Reference: https://howtodoinjava.com/algorithm/merge-sort-java-example/
 * 
 * @author me
 *
 *         This code functions properly.
 */
public class MergeSort2<T extends Comparable<T>> {
	private T[] output;
	private static int comparisons = 0;

	/**
	 * Test client to ensure the number of comparisons stays within the expected parameters.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		Random randNum = new Random();
		int numArrayElements = 8;
		int numTrials = 4000;
		int count = 0;
		Integer[] testArray = new Integer[numArrayElements];
		MergeSort2<Integer> ms = new MergeSort2<Integer>();
		while (count < numTrials) {
			for (int i = 0; i < numArrayElements; i++) {
				testArray[i] = randNum.nextInt(100);
			}
			System.out.println(ms.sort(testArray));
			count++;			
			resetComparisons();
		}

		// Integer[] a = { 8, 7, 6, 5, 4, 3, 2, 1 };
		// MergeSort2<Integer> ms = new MergeSort2<Integer>();
		// System.out.println(ms.sort(a));
	}

	/**
	 * Resets the number of comparisons to zero. This method is for testing purposes in order to run a large number of trials in the test
	 * client.
	 */
	public static void resetComparisons() {
		comparisons = 0;
	}

	public SortResult<T> sort(T[] input) {
		T[] initialInput = Arrays.copyOf(input, input.length);
		this.output = mergeSort(input);
		return new SortResult<T>(comparisons, initialInput, output);
	}

	private T[] mergeSort(T[] list) {
		// If list is empty; no need to do anything
		if (list.length <= 1) {
			return list;
		}

		// Split the array in half in two parts
		@SuppressWarnings("unchecked")
		T[] first = (T[]) new Integer[list.length / 2];
		@SuppressWarnings("unchecked")
		T[] second = (T[]) new Integer[list.length - first.length];
		System.arraycopy(list, 0, first, 0, first.length);
		System.arraycopy(list, first.length, second, 0, second.length);
		// Sort each half recursively
		mergeSort((T[]) first);
		mergeSort((T[]) second);
		// Merge both halves together, overwriting to original array
		merge(first, second, list);
		return list;
	}

	private void merge(T[] first, T[] second, T[] result) {
		// Index Position in first array - starting with first element
		int iFirst = 0;
		// Index Position in second array - starting with first element
		int iSecond = 0;
		// Index Position in merged array - starting with first position
		int iMerged = 0;
		// Compare elements at iFirst and iSecond, and move smaller element at iMerged
		while (iFirst < first.length && iSecond < second.length) {
			if (first[iFirst].compareTo(second[iSecond]) < 0) {
				comparisons++;
				result[iMerged] = first[iFirst];
				iFirst++;
			} else {
				result[iMerged] = second[iSecond];
				iSecond++;
				comparisons++;
			}
			iMerged++;
		}
		// copy remaining elements from both halves - each half will have already sorted elements
		System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
		System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
	}
}