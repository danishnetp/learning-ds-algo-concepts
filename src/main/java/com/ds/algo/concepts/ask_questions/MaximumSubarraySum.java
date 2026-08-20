package com.ds.algo.concepts.ask_questions;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 7, 8};
        maximumSubarraySum(arr);
    }
    private static void maximumSubarraySumOptimal(int[] arr) {
        int max = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int num : arr) {
            //if(num < )
            currentSum += num;
            if (currentSum > max)
                max = currentSum;
            if (currentSum < 0)
                currentSum = 0;
        }
    }

    private static void maximumSubarraySum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int num : arr) {
            currentSum += num;
            if (currentSum > max)
                max = currentSum;
            if (currentSum < 0)
                currentSum = 0;
        }

        System.out.println("Maximum Subarray Sum: " + max);
    }
}
