package sort;

import java.util.ArrayList;
import java.util.List;

public class TestDriver {
    public static void main(String[] args) {
//        HeapSort<Integer> heapSorter = new HeapSort<>();
        MergeSort2<Integer> mergeSorter = new MergeSort2<>();
        QuickSort<Integer> quickSorter = new QuickSort<>();
        ShakerSort<Integer> shakerSorter = new ShakerSort<>();
        List<Sort<Integer>> sorters = new ArrayList<>();
//        sorters.add(heapSorter);
        sorters.add(mergeSorter);
        sorters.add(quickSorter);
        sorters.add(shakerSorter);

        Permutation permuter = new Permutation();

        int[] ns = {4, 6, 8};
        for (Sort<Integer> sorter : sorters) {
            System.out.println("****** " + sorter.getClass().getName() + " *****");
            for (int n : ns) {
                System.out.println("--- " + "n=" + n + " ---");
                Analyzer<Integer> analyzer = new Analyzer<>();
                for (List<Integer> permutation: permuter.createPermutations(n)) {
                    Integer[] permutationsArr = permutation.toArray(Integer[]::new);
                    analyzer.addResult(sorter.sort(permutationsArr));
                }
                System.out.println("10 best cases: " + analyzer.bestCases(10));
                System.out.println("Average case: " + (int) Math.ceil(analyzer.averageCase()));
                System.out.println("10 worst cases: " + analyzer.worstCases(10));
            }
            System.out.println("\n\n\n");
        }
    }
}
