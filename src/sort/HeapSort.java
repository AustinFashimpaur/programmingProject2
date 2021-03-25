package sort;

import java.util.Arrays;

/**
 * Represents the comparison-based sorting algorithm Heapsort. Created for
 * project 2 of CSIS 2430 at Salt Lake Community College.
 * 
 * @author CSIS 2430 Programming Team 2
 */
public class HeapSort<T extends Comparable<T>> implements Sort<T> {
	private T[] output;
	private int comparisons; // represents number of comparisons made during sorting.

	/**
	 * Sorts the passed generic array according to the Heapsort algorithm.
	 * 
	 * @return SortResult object comprised of number of comparison(s), the input(s),
	 *         and output(s).
	 */
	public SortResult<T> sort(T[] input) {
		comparisons = 0;
		output = Arrays.copyOf(input, input.length);

		int n = input.length;

		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(input, n, i);
			comparisons++;
		}

		for (int i = n - 1; i > 0; i--) {
			swap(0, i);
			heapify(input, i, 0);
			comparisons++;
		}

		return new SortResult<>(comparisons, input, output);
	}

	private void heapify(T[] input, int k, int l) {
		int largest = l;
		int v = 2 * l + 1;
		int r = 2 * l + 2;

		if (v < k && input[v].compareTo(input[largest]) < 0) {
			largest = v;
		} else if (r < k && input[r].compareTo(input[largest]) > 0) {
			largest = r;
		}else if (largest != l) {
			swap(l, largest);
		}
	}

	private void swap(int nf, int ns) {
		T temp = output[nf];
		output[nf] = output[ns];
		output[ns] = temp;
	}

}
