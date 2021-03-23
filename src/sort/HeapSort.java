package sort;

public class HeapSort<T extends Comparable<T>> implements Sort<T>
{
    private T[] output;
    private int comparisons = 0;
    
//    public SortResult<T> sort(T[] input)
//    {
//        output = Arrays.copyOf(input, input.length);
//        return new SortResult<>(comparisons, input, output);
//    }
    
    public void sort(T[] input)
    {
        int n = input.length;
 
        for (int i = n/2 - 1; i >= 0; i--)
        {
            heapify(input, n, i);
            comparisons++;
        }

        for (int i = n - 1; i > 0; i--) 
        {
            swap(0, i);
            heapify(input, i, 0);
            comparisons++;
        }
    }
    
    public void heapify(T[] input, int k, int l)
    {
        int largest = l;
        int v = 2 * l + 1;
        int r = 2 * l + 2;
 
        if (v < k && input[v].compareTo(input[largest]) < 0)
        {
            largest = v;
        }

        if (r < k && input[r].compareTo(input[largest]) > 0)
        {
            largest = r;
        }

        if (largest != l) 
        {
            swap(l, largest);
        }
    }
    
    private void swap(int nf, int ns) 
    {
        T temp = output[nf];
        output[nf] = output[ns];
        output[ns] = temp;
    }
    
}
