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

public class ShakerSort<T extends Comparable<T>> {
    public SortResult<T> sort(T[] input) {
        T[] output = Arrays.copyOf(input, input.length);
        boolean swapped = true;
        int start = 0;
        int end = output.length;
        int comparisons = 0;

        while (swapped) {
            swapped = false;

            for (int i = start; i < end - 1; ++i) {
                if (output[i].compareTo(output[i + 1]) > 0) {
                    comparisons = comparisons + 1;
                    swap(output, i, i + 1);
                    swapped = true;
                }
            }

            // Nothing changed, can short-circuit
            if (!swapped) {
                break;
            }

            for (int j = end - 1; j > start; j--) {
                if (output[j].compareTo(output[j - 1]) < 0) {
                    comparisons = comparisons + 1;
                    swap(output, j, j - 1);
                    swapped = true;
                }
            }

            // the last step moved the smallest number into the current start, no need to look at it further
            start = start + 1;
        }
        return new SortResult<>(comparisons, input, output);
    }

    private void swap(T[] input, int i, int j) {
        T temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main(String[] args) {
        // Tests here
        ShakerSort<Integer> shakerSort = new ShakerSort<>();

        Integer[][] testArrays = {
                {1, 2, 3, 4, 5, 6, 7},
                {7, 6, 5, 4, 3, 2, 1},
                {1, 3, 2, 4, 5, 7},
                {1, 5, 2, 10, 10000, 6},
                {1, 5, 2, 5, 3, 5, 4, 6}
        };

        Arrays.stream(testArrays).sequential().forEach(array -> {
            System.out.println(shakerSort.sort(array));
        });
    }
}
