package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Analyzer<T extends Comparable<T>> {
    private List<Integer> comparisons;

    public Analyzer() {
        comparisons = new ArrayList<>();
    }

    public void addResult(SortResult<T> result) {
       comparisons.add(result.getComparisons());
    }

    public List<Integer> bestCases(int n) {
        Collections.sort(comparisons);
        return comparisons.subList(0, n);
    }

    public Double averageCase() {
       return comparisons.stream().mapToDouble(a -> a).average().getAsDouble();
    }

    public List<Integer> worstCases(int n) {
        Collections.sort(comparisons);
        return comparisons.subList(comparisons.size() - n, comparisons.size());
    }
}
