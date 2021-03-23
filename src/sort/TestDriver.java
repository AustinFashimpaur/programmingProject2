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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TestDriver {

    private void callTestCase() {

    }

    public static void main(String[] args) throws FileNotFoundException {
        File nIs4 = new File("nIs4.txt");
        File nIs6 = new File("nIs6.txt");
        File nIs8 = new File("nIs8.txt");

        HeapSort<Integer> heapSorter = new HeapSort<>();
        MergeSort2<Integer> mergeSorter = new MergeSort2<>();
        QuickSort<Integer> quickSorter = new QuickSort<>();
        ShakerSort<Integer> shakerSorter = new ShakerSort<>();

        // permutation generator

        // create list of all permutations for n=4
        // call each sort for every permutation of n=4
        Scanner nIs4Reader = new Scanner(nIs4);
        while (nIs4Reader.hasNextLine()) {
            int[] nums = Arrays.stream(nIs4Reader.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            Integer[] nums2 = Arrays.stream(nums).boxed().toArray(Integer[]::new);
            heapSorter.sort(nums2);
            mergeSorter.sort(nums2);
            quickSorter.sort(nums2);
            shakerSorter.sort(nums2);

        }

        // create list of all permutations for n=6
        // call each sort for every permutation of n=6

        // create list of all permutations for n=8
        // call each sort for every permutation of n=8
    }
}
