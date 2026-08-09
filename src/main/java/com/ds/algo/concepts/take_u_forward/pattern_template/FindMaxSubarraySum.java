package com.ds.algo.concepts.take_u_forward.pattern_template;

// FindMaxSubarraySum
public class FindMaxSubarraySum {
    public static void main(String[] args) {
        int[] arr = {-1, 2, 3, 3, 4, 5, -1};
        int k = 4;
        System.out.println("Max sum = " + findMaxSubarraySum(arr, k));
    }

    public static int findMaxSubarraySum(int[] arr, int k) {
        if (arr == null || arr.length < k || k <= 0) {
            return 0; // Invalid input fallback
        }

        // Sum of the first window
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        // Slide the window across the rest of the array
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k]; // Add next element, subtract oldest element
            if (windowSum > maxSum) {
                maxSum = windowSum;
            }
        }

        return maxSum;
    }
}

