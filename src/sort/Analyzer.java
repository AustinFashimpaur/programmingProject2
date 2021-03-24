/*
 * ADOBE CONFIDENTIAL
 * ___________________
 *
 * Copyright 2021 Adobe
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains
 * the property of Adobe and its suppliers, if any. The intellectual
 * and technical concepts contained herein are proprietary to Adobe
 * and its suppliers and are protected by all applicable intellectual
 * property laws, including trade secret and copyright laws.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Adobe.
 *
 */

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
