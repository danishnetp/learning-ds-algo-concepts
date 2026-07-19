package com.ds.algo.concepts.ask_questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for solving the classic Two Sum problem using a hash map.
 *
 * <p>Given an integer array and a target value, this implementation finds either:</p>
 * <ul>
 *   <li>the indices of two numbers that add up to the target, or</li>
 *   <li>a printable pair representation for demonstration purposes.</li>
 * </ul>
 */
public class TwoSumPromblem {
    /**
     * Demonstrates both {@link #twoSum(int[], int)} and {@link #twoSum1(int[], int)}.
     *
     * @param args command-line arguments (not used)
     */
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

    /**
     * Returns indices of the two numbers such that they add up to the target.
     *
     * <p>Time complexity: O(n), Space complexity: O(n).</p>
     *
     * @param nums input array of integers
     * @param target desired sum
     * @return an array with two indices if a pair is found; otherwise an empty array
     */
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

    /**
     * Prints the first pair found whose sum equals the target.
     *
     * <p>This is a demonstration-oriented variant of {@link #twoSum(int[], int)}
     * that prints the values instead of returning indices.</p>
     *
     * @param nums input array of integers
     * @param target desired sum
     */
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
