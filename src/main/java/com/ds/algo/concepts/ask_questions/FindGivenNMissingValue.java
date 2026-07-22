package com.ds.algo.concepts.ask_questions;

import java.util.*;
import java.util.stream.Collectors;

public class FindGivenNMissingValue {
    static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2, 3, 7, 8};
        int[] result = findMissingNumber1(arr.length, arr);
        for (int j : result) {
            System.out.println(j);
        }
    }

    static int[] findMissingNumber1(int N, int[] ids) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(ids[i]);
        }

        List<Integer> missingNumbers = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (!set.contains(i)) {
                missingNumbers.add(i);
            }
        }

        int[] result = new int[missingNumbers.size()];
        for (int i = 0; i < missingNumbers.size(); i++) {
            result[i] = missingNumbers.get(i);
        }
        return result;
    }
}
