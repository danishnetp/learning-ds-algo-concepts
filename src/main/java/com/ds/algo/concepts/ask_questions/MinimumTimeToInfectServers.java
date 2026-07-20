package com.ds.algo.concepts.ask_questions;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Computes the minimum time needed to infect all healthy servers in a grid.
 *
 * <p>Grid states:</p>
 * <ul>
 *   <li>0 -> empty slot (ignored)</li>
 *   <li>1 -> healthy server</li>
 *   <li>2 -> infected server</li>
 * </ul>
 *
 * <p>Each minute, every infected server infects its 4-directional neighbors
 * (up, down, left, right). If at least one healthy server can never be reached,
 * this method returns -1.</p>
 *
 * <p>Approach: Multi-source BFS (all currently infected cells are added as initial
 * sources in the queue). BFS level traversal naturally models minute-by-minute spread.</p>
 *
 * <p>Time Complexity: O(rows * cols)<br>
 * Space Complexity: O(rows * cols)</p>
 */
public class MinimumTimeToInfectServers {

    private static final int EMPTY = 0;
    private static final int HEALTHY = 1;
    private static final int INFECTED = 2;

    private static final int[][] DIRECTIONS = {
            {1, 0},   // down
            {-1, 0},  // up
            {0, 1},   // right
            {0, -1}   // left
    };

    /**
     * Demonstrates the sample case from the problem statement.
     */
    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        int minutes = minMinutesToInfectAll(grid);
        System.out.println("Minimum minutes to infect all healthy servers: " + minutes);
    }

    /**
     * Returns the minimum number of minutes required to infect all healthy servers.
     *
     * @param grid 2D grid representing server states
     * @return minimum minutes needed, 0 when nothing needs infection, or -1 when impossible
     */
    public static int minMinutesToInfectAll(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        // Work on a copy so callers do not observe mutation of input grid.
        int[][] state = deepCopy(grid);

        Queue<int[]> queue = new ArrayDeque<>();
        int healthyCount = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (state[r][c] == INFECTED) {
                    queue.offer(new int[]{r, c});
                } else if (state[r][c] == HEALTHY) {
                    healthyCount++;
                }
            }
        }

        if (healthyCount == 0) {
            return 0;
        }

        int minutes = 0;

        while (!queue.isEmpty() && healthyCount > 0) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];

                for (int[] dir : DIRECTIONS) {
                    int nr = row + dir[0];
                    int nc = col + dir[1];

                    if (!isInBounds(nr, nc, rows, cols) || state[nr][nc] != HEALTHY) {
                        continue;
                    }

                    state[nr][nc] = INFECTED;
                    healthyCount--;
                    queue.offer(new int[]{nr, nc});
                }
            }

            // One BFS layer equals one minute of infection spread.
            minutes++;
        }

        return healthyCount == 0 ? minutes : -1;
    }

    private static boolean isInBounds(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    private static int[][] deepCopy(int[][] source) {
        int[][] copy = new int[source.length][];
        for (int i = 0; i < source.length; i++) {
            copy[i] = source[i].clone();
        }
        return copy;
    }
}

