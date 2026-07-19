package com.ds.algo.concepts.ask_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReverseAndSortStringList {
    /*
     * Input: "abcdefgh","abcdefghijkl","abcdef","abcdefghijklmnop","abcd"
     *
     * Output: "ponmlkjihgfedcba","lkjihgfedcba","hgfedcba","fedcba","dcba" -- desc order
     */
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("abcdefgh", "abcdefghijkl", "abcdef", "abcdefghijklmnop", "abcd");

        List<String> result = reverseAndSortStringListJava8(stringList);
        System.out.println("Reversed and Sorted List: " + result);
    }

    private static List<String> reverseAndSortStringListJava8(List<String> stringList) {

        List<String> result = new ArrayList<>(stringList.stream()
                .map(ReverseAndSortStringList::reverseString)
                .sorted(Comparator.reverseOrder())
                .toList());

        // Sort the output array in descending order
        result.sort(Comparator.reverseOrder());
        return result;
    }

    private static List<String> reverseAndSortStringList1(List<String> stringList) {

        List<String> result = new ArrayList<>();

        for (String element : stringList) {
            result.add(reverseString(element));
        }

        // Sort the output array in descending order
        result.sort(Comparator.reverseOrder());
        return result;
    }

    private static String reverseString(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }
}
