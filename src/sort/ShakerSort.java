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

public class ShakerSort<T extends Comparable<T>> {
    public SortResult<T> sort(T[] input) {
        boolean swapped = true;
        int start = 0;
        int end = input.length;
        int comparisons = 0;

        while (swapped) {
            swapped = false;

            for (int i = start; i < end - 1; ++i) {
                if (input[i].compareTo(input[i + 1]) > 0) {
                    comparisons = comparisons + 1;
                    swap(input, i, i + 1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }

            for (int j = end - 1; j >= start; j--) {
                if (input[j].compareTo(input[j - 1]) < 0) {
                    comparisons = comparisons + 1;
                    swap(input, j, j - 1);
                    swapped = true;
                }
            }

            // the last step moved the smallest number into the current start, no need to look at it further
            start = start + 1;
        }
        return new SortResult<>(comparisons, input);
    }

    private void swap(T[] input, int i, int j) {
        T temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
