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

public class TestDriver {
    public static void main(String[] args) throws FileNotFoundException {
//        HeapSort<Integer> heapSorter = new HeapSort<>();
        MergeSort2<Integer> mergeSorter = new MergeSort2<>();
        QuickSort<Integer> quickSorter = new QuickSort<>();
        ShakerSort<Integer> shakerSorter = new ShakerSort<>();
        List<Sort<Integer>> sorters = new ArrayList<>();
//        sorters.add(heapSorter);
        sorters.add(mergeSorter);
        sorters.add(quickSorter);
        sorters.add(shakerSorter);

        File nIs4 = new File("./files/n4.csv");
        File nIs6 = new File("./files/n6.csv");
        File nIs8 = new File("./files/n8.csv");
        List<File> files = new ArrayList<>();
        files.add(nIs4);
        files.add(nIs6);
        files.add(nIs8);

        for (Sort<Integer> sorter : sorters) {
            System.out.println("------ " + sorter.getClass().getName() + " ------");
            for (File file : files) {
                System.out.println("------ " + file.getName() + " -------");
                Scanner reader = new Scanner(file);
                while (reader.hasNextLine()) {
                    Integer[] nums = Arrays.stream(
                            reader.nextLine()
                                    .replaceAll("\\s", "")
                                    .split(","))
                            .mapToInt(Integer::parseInt)
                            .boxed()
                            .toArray(Integer[]::new);
                    System.out.println(sorter.sort(nums));
                }
                System.out.println("\n\n");
            }
            System.out.println("\n\n\n");
        }
    }
}
