package sort;

import java.util.*;

public class Permutations<T extends Comparable<T>> 
{  
    private T[] output;
    private int comparisons;
    
    public SortResult<T> sort(T[] input)
    {
        comparisons = 0;
        output = Arrays.copyOf(input, input.length);
        return new SortResult<>(comparisons, input, output);
    }

    public void heapPermutation(int T[], int size, int n)
    { 
        for (int i = 0; i < size; i++) 
        {
            heapPermutation(T, size - 1, n);
            
            if (size % 2 == 1) 
            {
                swap(i, size - 1);
            }
            else 
            {
                swap(i, size - 1);
            }
            comparisons++;
        }
    }
    
    private void swap(int nfi, int nse) 
    {
        T temp = output[nfi];
        output[nfi] = output[nse];
        output[nse] = temp;
    }
}
