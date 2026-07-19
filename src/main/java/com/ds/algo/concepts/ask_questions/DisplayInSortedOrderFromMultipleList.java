package com.ds.algo.concepts.ask_questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class DisplayInSortedOrderFromMultipleList {
    static void main() {
        List<Integer> list1 = Arrays.asList(1, 4, 7, 10);
        List<Integer> list2 = Arrays.asList(2, 5, 8, 11);
        List<Integer> list3 = Arrays.asList(3, 6, 9, 12);

        List<Integer> sortedList = Stream.of(list1, list2, list3)
                .flatMap(List::stream)
                .sorted()
                .toList();
        System.out.println("Sorted List: " + sortedList);
    }
}
