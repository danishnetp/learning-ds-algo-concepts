package com.ds.algo.concepts.ask_questions.programming;

/**
 * Given an integer array arr[], find the subarray (containing at least one element)
 * which has the maximum possible sum, and return that sum.
 *
 * Note: A subarray is a continuous part of an array.
 *
 * Examples:
 * Input: arr[] = [2, 3, -8, 7, -1, 2, 3]
 * Output: 11
 * Explanation: The subarray [7, -1, 2, 3] has the largest sum 11.
 *
 * Input: arr[] = [-2, -4]
 * Output: -2
 * Explanation: The subarray [-2] has the largest sum -2.
 *
 * Input: arr[] = [5, 4, 1, 7, 8]
 * Output: 25
 * Explanation: The subarray [5, 4, 1, 7, 8] has the largest sum 25.
 */
public class MaximumSubarraySum {

    public static void main(String[] args) {
        int[] arr = {-2, -4};
        maximumSubarraySum(arr);
    }

    /**
     * Optimal approach using Kadane's algorithm.
     * Time Complexity: O(n), Space Complexity: O(1)
     */
    private static void maximumSubarraySumOptimal(int[] arr) {
        int max = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int num : arr) {
            currentSum += num;
            if (currentSum > max) {
                max = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
    }

    /**
     * Finds the maximum subarray sum and prints the result.
     */
    private static void maximumSubarraySum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int num : arr) {
            currentSum += num;
            if (currentSum > max) {
                max = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        System.out.println("Maximum Subarray Sum: " + max);
    }
}
