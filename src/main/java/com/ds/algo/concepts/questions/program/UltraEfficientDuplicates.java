package com.ds.algo.concepts.questions.program;

import java.util.*;

/**
 * Finds duplicate values in an integer array using two strategies:
 * <ul>
 *   <li>{@link #findDuplicates1(int[])}: sort + linear scan (works for any integer range).</li>
 *   <li>{@link #findDuplicates(int[])}: in-place index marking (O(n), requires values in [1, n]).</li>
 * </ul>
 *
 * <p>Important side effects:</p>
 * <ul>
 *   <li>{@code findDuplicates1} sorts the input array in place.</li>
 *   <li>{@code findDuplicates} flips signs in the input array in place.</li>
 * </ul>
 */
public class UltraEfficientDuplicates {

    /**
     * Demo runner for duplicate-detection approaches.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 4, 2, 3, 100}; // Values must be within 1 to arr.length
        //System.out.println(findDuplicates(arr)); // Output: [2, 3]
        System.out.println(findDuplicates1(arr)); // Output: [2, 3]

        System.out.println(findDuplicateUsingTwoSet(arr)); // Output: [2, 3]
    }

    /**
     * Sorts the array and collects duplicate values once each.
     *
     * <p>How it works:</p>
     * <ol>
     *   <li>Sort the array so equal values become adjacent.</li>
     *   <li>Scan from left to right and compare current value with previous value.</li>
     *   <li>Add a duplicate only if it has not been added immediately before.</li>
     * </ol>
     *
     * <p>Complexity:</p>
     * <ul>
     *   <li>Time: O(n log n) due to {@code Arrays.sort(nums)} for primitive int arrays.</li>
     *   <li>Extra space: O(1) auxiliary (excluding output list).</li>
     * </ul>
     *
     * @param nums input array; may contain any int values
     * @return list of duplicate numbers, each reported once
     */
    public static List<Integer> findDuplicates1(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        // No duplicate is possible for null/size<2 inputs.
        if (nums == null || nums.length < 2) return duplicates;

        // Dual-Pivot Quicksort (highly optimized in Java), O(n log n) average/worst for this workflow
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            // Check if current element matches the previous one
            if (nums[i] == nums[i - 1]) {
                // Avoid adding the same duplicate multiple times (e.g., if)
                if (duplicates.isEmpty() || duplicates.get(duplicates.size() - 1) != nums[i]) {
                    duplicates.add(nums[i]);
                }
            }
        }
        // Overall for this method: O(n log n) time (sorting dominates), O(1) extra space excluding output
        return duplicates;
    }

    /**
     * Finds duplicates using two sets: one for seen values and one for repeated values.
     *
     * <p>This method accepts any integer range and does not require array mutation, but it uses
     * additional memory proportional to input size.</p>
     *
     * <p>Complexity:</p>
     * <ul>
     *   <li>Time: O(n)</li>
     *   <li>Extra space: O(n)</li>
     * </ul>
     *
     * @param arr input array; may contain any int values
     * @return set of duplicate values (unique duplicates only)
     */
    static Set<Integer> findDuplicateUsingTwoSet(int[] arr) {
        System.out.println("Using Set..");
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicate = new HashSet<>();

        for (int n : arr) {
            if (seen.contains(n)) {
                duplicate.add(n);
            } else {
                seen.add(n);
            }
        }

        return duplicate;
    }


    /**
     * Finds duplicates using in-place sign marking.
     *
     * <p>For each value {@code v}, map it to index {@code v - 1}. If the value at that mapped index is
     * already negative, {@code v} is a duplicate; otherwise, negate the mapped slot to mark first visit.</p>
     *
     * <p>Constraints:</p>
     * <ul>
     *   <li>All values must be in range {@code [1, nums.length]}.</li>
     *   <li>Input array is modified in place.</li>
     * </ul>
     *
     * <p>Complexity:</p>
     * <ul>
     *   <li>Time: O(n)</li>
     *   <li>Extra space: O(1) auxiliary (excluding output list)</li>
     * </ul>
     *
     * @param nums input array with values constrained to [1, n]
     * @return list of duplicate values (may contain repeats if an element appears more than twice)
     * @throws IllegalArgumentException if any value is outside [1, nums.length]
     */
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // For values in [1, n], map value -> zero-based index (value - 1)
            int value = Math.abs(nums[i]);
            if (value < 1 || value > nums.length) {
                throw new IllegalArgumentException(
                        "All values must be in range [1, " + nums.length + "]"
                );
            }
            int index = value - 1;

            // If the value at that index is already negative, we saw it before
            if (nums[index] < 0) {
                duplicates.add(value);
            } else {
                // Mark the index as visited by flipping its sign
                nums[index] = -nums[index];
            }
        }

        // Overall for this method: O(n) time, O(1) extra space excluding output
        // Optional: Restore the array signs back to positive here if needed
        return duplicates;
    }
}

