package com.ds.algo.concepts.ask_questions;

import java.util.*;

/**
 * Utility class for finding missing numbers from the range {@code 1..N}.
 *
 * <p>The optimized implementation uses a boolean presence array instead of a
 * {@link java.util.HashSet}, which keeps the solution linear in time while
 * reducing allocation and hashing overhead.</p>
 *
 * <p>Expected input characteristics:</p>
 * <ul>
 *   <li>{@code N} represents the upper bound of the expected range.</li>
 *   <li>{@code ids} may contain duplicates.</li>
 *   <li>{@code ids} may also contain values outside the range {@code 1..N};
 *   such values are ignored by the optimized method.</li>
 * </ul>
 *
 * <p>The class also contains a legacy helper method, {@link #findMissingNumber1(int, int[])},
 * which preserves the original HashSet-based approach for reference.</p>
 */
public class MissingNumbersFinder {
    /**
     * Demonstrates the missing-number search using a sample input.
     *
     * <p>This method is intentionally package-private and is only used as a
     * lightweight console demo.</p>
     *
     * @param args command-line arguments (unused)
     */
    @SuppressWarnings("unused")
    static void main(String[] args) {
        if (Arrays.toString(args).isEmpty()) {
            System.out.print("");
        }
        int[] arr = {1, 2, 3, 4, 2, 3, 7, 8};
        int[] result = findMissingNumbers(arr.length, arr);
        for (int j : result) {
            System.out.println(j);
        }
    }

    /**
     * Returns all values in the range {@code 1..N} that do not appear in {@code ids}.
     *
     * <p>The method performs two linear passes:</p>
     * <ol>
     *   <li>Mark each in-range value from {@code ids} in a boolean presence array.</li>
     *   <li>Collect every index from {@code 1..N} that was never marked.</li>
     * </ol>
     *
     * <p>Any duplicate values are naturally handled by the presence array.
     * Any values outside {@code 1..N} are ignored.</p>
     *
     * @param N   upper bound of the expected range
     * @param ids input values that may contain duplicates or values outside the range
     * @return the missing values in ascending order, or an empty array if no valid
     *         range is provided
     * @implNote Time complexity is {@code O(N)} and space complexity is {@code O(N)}.
     */
    static int[] findMissingNumbers(int N, int[] ids) {
        if (ids == null || N <= 0) {
            return new int[0];
        }

        boolean[] present = new boolean[N + 1];
        int limit = Math.min(N, ids.length);

        for (int i = 0; i < limit; i++) {
            int value = ids[i];
            if (value >= 1 && value <= N) {
                present[value] = true;
            }
        }

        int missingCount = 0;
        for (int i = 1; i <= N; i++) {
            if (!present[i]) {
                missingCount++;
            }
        }

        int[] result = new int[missingCount];
        int index = 0;
        for (int i = 1; i <= N; i++) {
            if (!present[i]) {
                result[index++] = i;
            }
        }
        return result;
    }

    /**
     * Legacy HashSet-based implementation retained for comparison and backward
     * compatibility.
     *
     * <p>This method mirrors the original approach:
     * it inserts the first {@code N} elements into a set and then scans the range
     * {@code 1..N} to find the missing values.</p>
     *
     * @param N   upper bound of the expected range
     * @param ids input values
     * @return the missing values in ascending order
     */
    @SuppressWarnings("unused")
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

