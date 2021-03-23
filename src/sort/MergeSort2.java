package sort;

import java.util.Arrays;

/**
 * Represents a class that calculates the number of comparisons Merge Sort uses for n number of elements. The worst-case number of
 * comparisons is given by the formula, { n log(n) - n + 1 }, where the log is base 2. For example, if we have 8 number of elements to sort,
 * then we should expect a worse case of 17 comparisons. Another example, if we have 6 elements to sort, then we should expect a worse case of
 * 11 elements to sort (rounding up). Additionally, merge sort has a worst-case time complexity of O(n log n). This means that theoretically
 * we should expect Merge sort to have the best performance compared to Quick Sort, Heap Sort or Shaker Sort.
 * 
 * Reference: Reference: https://howtodoinjava.com/algorithm/merge-sort-java-example/
 * 
 * @author me
 *
 *   
 */
public class MergeSort2<T extends Comparable<T>> implements Sort<T> {
	
	
	private T[] output;
	private static int comparisons = 0;
	
	
	
	

	/**
	 * Private helper method to set the number of comparisons to zero. This method is only useful for testing purposes in order to run a large
	 * number of trials in the test client. The unused warning is suppressed because the test code has been commented out. 
	 */
	@SuppressWarnings("unused")
	private static void resetComparisons() {
		comparisons = 0;
	}
	
	
	
	

	/**
	 * This method accepts a generic array as the input to be sorted. It then makes a copy of the input to be returned later. The input is then
	 * sorted using a recursive Merge Sort algorithm. A <code>SortResult</code> object is then returned with the number of comparisons required
	 * to sort the input, the initial input, as well as the sorted array.
	 * 
	 * @param input the array to be sorted
	 * @return SortResult object comprising the number of comparisons, the initial input and the sorted array.
	 */
	public SortResult<T> sort(T[] input) {
		int temp = comparisons;
		resetComparisons();
		T[] initialInput = Arrays.copyOf(input, input.length);
		this.output = mergeSort(input);
		return new SortResult<T>(temp, initialInput, output);
	}
	
	
	
	

	/**
	 * This method implements the Merge Sort functionality by repeatedly splitting the array into smaller and smaller halves until a single
	 * element is reached. The unchecked warning is triggered because of the unchecked cast from Integer[] to the generic T[]. This should
	 * be safe to do because the project has a very limited scope.
	 * 
	 * @param list an unsorted list
	 * @return a sorted list
	 */
	@SuppressWarnings("unchecked")
	private T[] mergeSort(T[] list) {
		// If list is empty; no need to do anything
		if (list.length <= 1) {	return list; }

		// Split the array in half in two parts
		T[] first = (T[]) new Integer[list.length / 2];
		T[] second = (T[]) new Integer[list.length - first.length];
		System.arraycopy(list, 0, first, 0, first.length);
		System.arraycopy(list, first.length, second, 0, second.length);

		// Sort each half recursively
		mergeSort((T[]) first);
		mergeSort((T[]) second);
		
		merge(first, second, list); // Merge both halves together, overwriting to original array
		return list;
	}
	
	
	
	

	/**
	 * Examine the individual values, compare the values, sort the values and merge them back into the final array. This method also counts the
	 * number of comparisons required to put the values in order.
	 * 
	 * @param first  the first array
	 * @param second the second array
	 * @param result the result array
	 */
	private void merge(T[] first, T[] second, T[] result) {		
		int iFirst = 0; // Index Position in first array - starting with first element		
		int iSecond = 0; // Index Position in second array - starting with first element		
		int iMerged = 0; // Index Position in merged array - starting with first position
		
		while (iFirst < first.length && iSecond < second.length) { // Compare elements at iFirst and iSecond, and move smaller element at iMerged
			if (first[iFirst].compareTo(second[iSecond]) < 0) {	comparisons++; result[iMerged] = first[iFirst];	iFirst++; } 
			else { result[iMerged] = second[iSecond];	iSecond++; comparisons++;}
			iMerged++;
		}
		
		// copy remaining elements from both halves - each half will have already sorted elements
		System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
		System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
	}
	
	
	
	

//..........................................................FOR TESTING.................................................................	
	/**
	 * Test client to ensure the number of comparisons stays within the expected parameters.
	 * 
	 * @param args
	 */
		  
	
	/*
	 * public static void main(String[] args) { Random randNum = new Random(); int numArrayElements = 8; int numTrials = 4000; int count = 0;
	 * Integer[] testArray = new Integer[numArrayElements]; MergeSort2<Integer> ms = new MergeSort2<Integer>(); while (count < numTrials) { for
	 * (int i = 0; i < numArrayElements; i++) { testArray[i] = randNum.nextInt(100); } System.out.println(ms.sort(testArray)); count++;
	 * resetComparisons(); } }
	 */
		 

// ..........................................................FOR TESTING.................................................................

}