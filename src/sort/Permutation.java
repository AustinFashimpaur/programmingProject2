package sort;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public List<List<Integer>> createPermutations(int n){
        List<List<Integer>> array3d = new ArrayList();
        List<Integer> item = new ArrayList();
        for (int i = 1; i <= n; i++) {
            item.add(i);
        }
        int intervals = 1;
        for (int i = 1; i <= n; i++) {
            intervals *= i;
        }
        System.out.println(intervals);
        array3d.add(item);
        for(int i = 1; i < intervals; i++) {
            item = nextPermutation(item);
            array3d.add(item);
        }
        return array3d;
    }
    private List<Integer> nextPermutation(List<Integer> arr0){
        List<Integer> arr = new ArrayList<>(arr0);
        int j = arr.size() - 2;
        while (arr.get(j) > arr.get(j+1)) {
            j--;
        }
        int k = arr.size() - 1;
        while (arr.get(j) > arr.get(k)) {
            k--;
        }
        int temp = arr.get(j);
        arr.set(j, arr.get(k));
        arr.set(k, temp);
        int r = arr.size() - 1;
        int s = j + 1;
        while (r > s)
        {
            temp = arr.get(r);
            arr.set(r, arr.get(s));
            arr.set(s, temp);
            r--;
            s++;
        }
        return arr;
    }
}