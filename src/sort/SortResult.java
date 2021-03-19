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

import java.util.Arrays;

public class SortResult<T extends Comparable<T>> {
    private int comparisons;
    private T[] input;
    private T[] output;

    public SortResult(int comparisons, T[] input, T[] output) {
        this.comparisons = comparisons;
        this.input = input;
        this.output = output;
    }

    public SortResult(int comparisons, T[] input) {
        this.comparisons = comparisons;
        this.input = input;
    }

    public int getComparisons() {
        return comparisons;
    }

    public T[] getInput() {
        return input;
    }

    public T[] getOutput() {
        return output;
    }

    @Override
    public String toString() {
        return "SortResult{" +
                "comparisons=" + comparisons +
                ", input=" + Arrays.toString(input) +
                ", output=" + Arrays.toString(output) +
                '}';
    }
}
