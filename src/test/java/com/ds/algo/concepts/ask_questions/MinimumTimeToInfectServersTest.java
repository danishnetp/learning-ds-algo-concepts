package com.ds.algo.concepts.ask_questions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumTimeToInfectServersTest {

    @Test
    void returnsSampleAnswerFour() {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        assertEquals(4, MinimumTimeToInfectServers.minMinutesToInfectAll(grid));
    }

    @Test
    void returnsMinusOneWhenSomeHealthyCannotBeReached() {
        int[][] grid = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };

        assertEquals(-1, MinimumTimeToInfectServers.minMinutesToInfectAll(grid));
    }

    @Test
    void returnsZeroWhenNoHealthyServersExist() {
        int[][] grid = {
                {0, 2, 0},
                {2, 0, 2}
        };

        assertEquals(0, MinimumTimeToInfectServers.minMinutesToInfectAll(grid));
    }

    @Test
    void returnsZeroForNullGrid() {
        assertEquals(0, MinimumTimeToInfectServers.minMinutesToInfectAll(null));
    }

    @Test
    void returnsZeroForEmptyGrid() {
        assertEquals(0, MinimumTimeToInfectServers.minMinutesToInfectAll(new int[0][0]));
    }

    @Test
    void doesNotMutateInputGrid() {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        int[][] original = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        MinimumTimeToInfectServers.minMinutesToInfectAll(grid);

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                assertEquals(original[r][c], grid[r][c]);
            }
        }
    }
}

