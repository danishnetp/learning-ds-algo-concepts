package com.ds.algo.concepts.ask_questions.cgi;

import com.ds.algo.concepts.ask_questions.MergeIntervalsOverlapping;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MergeIntervalsOverlappingTest {

    @Test
    void returnsEmptyForNullInput() {
        int[][] actual = MergeIntervalsOverlapping.merge(null);

        assertDeepEquals(new int[0][0], actual);
    }

    @Test
    void returnsEmptyForEmptyInput() {
        int[][] actual = MergeIntervalsOverlapping.merge(new int[0][0]);

        assertDeepEquals(new int[0][0], actual);
    }

    @Test
    void returnsSameIntervalForSingleElementInput() {
        int[][] input = {{5, 7}};

        int[][] actual = MergeIntervalsOverlapping.merge(input);

        assertDeepEquals(new int[][]{{5, 7}}, actual);
    }

    @Test
    void mergesOverlappingIntervalsFromUnsortedInput() {
        int[][] input = {
                {1, 3},
                {8, 10},
                {2, 6},
                {15, 18}
        };

        int[][] actual = MergeIntervalsOverlapping.merge(input);

        assertDeepEquals(new int[][]{{1, 6}, {8, 10}, {15, 18}}, actual);
    }

    @Test
    void mergesTouchingBoundariesAsOverlap() {
        int[][] input = {
                {1, 4},
                {4, 5}
        };

        int[][] actual = MergeIntervalsOverlapping.merge(input);

        assertDeepEquals(new int[][]{{1, 5}}, actual);
    }

    @Test
    void keepsNonOverlappingIntervalsSeparate() {
        int[][] input = {
                {1, 2},
                {4, 5},
                {7, 9}
        };

        int[][] actual = MergeIntervalsOverlapping.merge(input);

        assertDeepEquals(new int[][]{{1, 2}, {4, 5}, {7, 9}}, actual);
    }

    @Test
    void mergesNestedIntervalsIntoSingleRange() {
        int[][] input = {
                {1, 10},
                {2, 3},
                {4, 8},
                {9, 10}
        };

        int[][] actual = MergeIntervalsOverlapping.merge(input);

        assertDeepEquals(new int[][]{{1, 10}}, actual);
    }

    private static void assertDeepEquals(int[][] expected, int[][] actual) {
        assertTrue(Arrays.deepEquals(expected, actual),
                () -> "Expected: " + Arrays.deepToString(expected) + ", but was: " + Arrays.deepToString(actual));
    }
}

