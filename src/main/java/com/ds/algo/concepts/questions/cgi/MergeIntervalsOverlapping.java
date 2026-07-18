package com.ds.algo.concepts.questions.cgi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Demonstrates the classic "Merge Intervals" problem.
 *
 * <p>Problem statement:
 * Given an array of intervals, where each interval is represented as [start, end],
 * merge all overlapping intervals and return a new list of non-overlapping intervals
 * that cover the same ranges.</p>
 *
 * <p>Example:</p>
 * <pre>
 * Input : [[1,3], [8,10], [2,6], [15,18]]
 * Sorted: [[1,3], [2,6], [8,10], [15,18]]
 * Output: [[1,6], [8,10], [15,18]]
 * </pre>
 *
 * <p>Core idea:</p>
 * <ol>
 *   <li>Sort intervals by start time.</li>
 *   <li>Scan from left to right and maintain a "current merged interval".</li>
 *   <li>If next interval overlaps, extend current interval end.</li>
 *   <li>If it does not overlap, push current to result and start a new one.</li>
 * </ol>
 *
 * <p>Complexity:</p>
 * <ul>
 *   <li>Time: O(n log n) due to sorting, then O(n) scan.</li>
 *   <li>Space: O(n) for output list in worst case (no overlaps).</li>
 * </ul>
 */
public class MergeIntervalsOverlapping {
    /**
     * Runs a sample input and prints merged result.
     * JVM entry point signature must be: public static void main(String[] args).
     */
    public static void main(String[] args) {
        // Unsorted input on purpose to show why sorting is required.
        int[][] intervals = {
                {1, 3},
                {8, 10},
                {2, 6},
                {15, 18}
        };

        int[][] mergedIntervals = merge(intervals);

        // Note: intervals is printed after sorting because merge() sorts in place.
        System.out.println("Input : " + Arrays.deepToString(intervals));
        System.out.println("Output: " + Arrays.deepToString(mergedIntervals));
    }

    /**
     * Merges overlapping intervals.
     *
     * <p>Important behavior:</p>
     * <ul>
     *   <li>This method sorts the input array in place by interval start.</li>
     *   <li>Two intervals overlap when next.start <= current.end.</li>
     *   <li>Touching boundaries (e.g., [1,4] and [4,5]) are treated as overlap.</li>
     * </ul>
     *
     * @param intervals array of [start, end] intervals
     * @return merged non-overlapping intervals
     */
    public static int[][] merge(int[][] intervals) {
        // Defensive guard for null or empty input.
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        // Step 1: Sort by start value so potential overlaps become adjacent.
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        // Result container of merged intervals.
        List<int[]> result = new ArrayList<>();

        // Start with the first interval as the active interval to merge into.
        int[] newInterval = intervals[0];
        result.add(newInterval);

        // Step 2: Traverse all intervals and merge when overlap is found.
        for(int[] interval : intervals){
            // Overlap condition: interval starts before or at active interval end.
            if(interval[0] <= newInterval[1]){
                // Extend active interval end to cover both intervals.
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
            else{
                // No overlap: start a new active interval.
                newInterval = interval;
                result.add(newInterval);
            }
        }

        // Convert list result to int[][].
        return result.toArray(new int[result.size()][]);
    }
}
