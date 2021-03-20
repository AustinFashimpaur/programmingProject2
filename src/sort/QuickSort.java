package sort;

import java.util.Arrays;

public class QuickSort<T extends Comparable<T>> {
    private T[] output;
    private int comparisons;

    public SortResult<T> sort(T[] input) {
        comparisons = 0;
        output = Arrays.copyOf(input, input.length);
        branchDown(output, 0, output.length - 1);
        return new SortResult<>(comparisons, input, output);
    }

    private void branchDown(T[] a, int lo, int hi) {
        if (lo < hi) {
            int p = partition(a, lo, hi);
            branchDown(a, lo, p - 1);
            branchDown(a, p + 1, hi);
        }
    }
    private int partition(T[] a, int lo, int hi) {
        T pivot = a[hi];
        int i = lo;
        for (int j = lo; j <= hi; j++) {
            if (a[j].compareTo(pivot) < 0) {
                swap(j, i);
                i++;
            }
            comparisons++;
        }
        swap(i, hi);
        return i;
    }

    private void swap(int in1, int in2) {
        T temp = output[in1];
        output[in1] = output[in2];
        output[in2] = temp;
    }
}
