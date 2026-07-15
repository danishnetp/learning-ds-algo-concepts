package com.ds.algo.concepts.questions.program;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Demonstrates how to find the longest contiguous subarray whose sum is zero.
 *
 * <p>Approach used: prefix sum + hash map.
 *
 * <ul>
 *   <li>If the running prefix sum is 0 at index i, then subarray [0..i] has sum 0.
 *   <li>If the same prefix sum appears again at index j, then elements between (oldIndex + 1)..j sum to 0.
 *   <li>To maximize length, we store only the first occurrence of each prefix sum.
 * </ul>
 *
 * <p>Time Complexity: O(n)
 * <br>Space Complexity: O(n)
 */
public class ZeroSumSubarray {

    /**
     * Simple runner with a sample array.
     */
    public static void main(String[] args) {
        int[] A = {15, -2, 2, -8, 1, 7, 10, 23};
        int[] result = findLongestZeroSumSubarray(A);

        System.out.println("Longest contiguous subarray with sum 0: " + Arrays.toString(result));
    }

    /**
     * Returns the longest contiguous subarray that sums to zero.
     *
     * @param A input array
     * @return longest zero-sum subarray; empty array if none exists or input is null/empty
     */
    public static int[] findLongestZeroSumSubarray(int[] A) {
        if (A == null || A.length == 0) {
            return new int[0];
        }

        // Key: prefix sum, Value: first index where that sum appeared.
        HashMap<Integer, Integer> map = new HashMap<>();

        // Tracks cumulative sum while scanning the array.
        int currentSum = 0;
        // Tracks best answer boundaries found so far.
        int maxLength = 0;
        int startIdx = -1;
        int endIdx = -1;

        for (int i = 0; i < A.length; i++) {
            currentSum += A[i];

            // Case 1: sum from index 0 to i is zero.
            if (currentSum == 0) {
                maxLength = i + 1;
                startIdx = 0;
                endIdx = i;
            }
            // Case 2: same prefix sum seen before => middle segment sums to zero.
            else if (map.containsKey(currentSum)) {
                int prevIdx = map.get(currentSum);
                if (i - prevIdx > maxLength) {
                    maxLength = i - prevIdx;
                    startIdx = prevIdx + 1;
                    endIdx = i;
                }
            }
            // Case 3: first time seeing this sum; store index for future matches.
            else {
                map.put(currentSum, i);
            }
        }

        // Build result from the best boundaries, or return empty if no zero-sum segment exists.
        // Arrays.copyOfRange(source, from, to) uses:
        // - from: inclusive start index
        // - to: exclusive end index
        // So we pass (endIdx + 1) to include endIdx in the copied subarray.
        // It returns a NEW array (original array A is not modified).
        if (maxLength > 0) {
            return Arrays.copyOfRange(A, startIdx, endIdx + 1);
        } else {
            return new int[0];
        }
    }
}

