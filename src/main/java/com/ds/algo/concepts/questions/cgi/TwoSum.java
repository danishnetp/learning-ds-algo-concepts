package com.ds.algo.concepts.questions.cgi;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int[] res = twoSum(arr, 9);
        System.out.print("Two sum indices: ");
        for (int index : res) {
            System.out.print(index + " ");
        }
        System.out.println();
        twoSum1(arr, 9);
    }

    public static int[] twoSum(int[] nums, int target) {
        // Map to store numbers and their indices
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if the complement already exists in the map
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }

            // Store the current number and its index
            numMap.put(nums[i], i);
        }

        // Return empty array if no solution is found
        return new int[]{};
    }

    public static void twoSum1(int[] nums, int target) {
        // Map to store numbers and their indices
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if the complement already exists in the map
            if (numMap.containsKey(complement)) {
                System.out.println("Pair found: " + complement + " + " + nums[i] + " = " + target);
                return;
            }

            // Store the current number and its index
            numMap.put(nums[i], i);
        }

        System.out.println("No pair found");
    }
}
