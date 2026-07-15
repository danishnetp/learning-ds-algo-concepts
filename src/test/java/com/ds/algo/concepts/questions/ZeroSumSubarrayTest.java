package com.ds.algo.concepts.questions;

import com.ds.algo.concepts.questions.program.ZeroSumSubarray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ZeroSumSubarrayTest {

    @Test
    void returnsEmptyArrayForNullInput() {
        assertArrayEquals(new int[0], ZeroSumSubarray.findLongestZeroSumSubarray(null));
    }

    @Test
    void returnsEmptyArrayForEmptyInput() {
        assertArrayEquals(new int[0], ZeroSumSubarray.findLongestZeroSumSubarray(new int[0]));
    }

    @Test
    void returnsEmptyWhenNoZeroSumSubarrayExists() {
        int[] input = {1, 2, 3, 4};
        assertArrayEquals(new int[0], ZeroSumSubarray.findLongestZeroSumSubarray(input));
    }

    @Test
    void returnsWholeArrayWhenWholeArraySumsToZero() {
        int[] input = {2, -2, 3, -3};
        assertArrayEquals(input, ZeroSumSubarray.findLongestZeroSumSubarray(input));
    }

    @Test
    void handlesSingleElementZero() {
        int[] input = {0};
        assertArrayEquals(new int[] {0}, ZeroSumSubarray.findLongestZeroSumSubarray(input));
    }

    @Test
    void handlesAllZerosAndReturnsLongestRange() {
        int[] input = {0, 0, 0, 0};
        assertArrayEquals(input, ZeroSumSubarray.findLongestZeroSumSubarray(input));
    }

    @Test
    void handlesPrefixZeroSumSubarray() {
        int[] input = {4, -4, 7};
        assertArrayEquals(new int[] {4, -4}, ZeroSumSubarray.findLongestZeroSumSubarray(input));
    }

    @Test
    void findsLongestMiddleSubarrayFromRepeatedPrefixSum() {
        int[] input = {15, -2, 2, -8, 1, 7, 10, 23};
        assertArrayEquals(new int[] {-2, 2, -8, 1, 7}, ZeroSumSubarray.findLongestZeroSumSubarray(input));
    }

    @Test
    void choosesEarliestSubarrayWhenTwoLongestHaveSameLength() {
        int[] input = {2, -2, 5, 3, -3};
        assertArrayEquals(new int[] {2, -2}, ZeroSumSubarray.findLongestZeroSumSubarray(input));
    }
}

