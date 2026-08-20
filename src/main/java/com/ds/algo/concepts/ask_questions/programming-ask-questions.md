# Minimum Time to Infect All Servers (Grid BFS)

A data center contains multiple servers arranged in a grid. Each server can be in one of three states:

- `0` -> empty slot
- `1` -> healthy server
- `2` -> infected server

Every minute, an infected server spreads the virus to its adjacent servers:

- up
- down
- left
- right

Your task is to determine:

- the minimum time required to infect all healthy servers
- or return `-1` if some servers can never be infected

## Sample

Input:

```text
[
  [2,1,1],
  [1,1,0],
  [0,1,1]
]
```

Output:

```text
4
```

## Why BFS is the right approach

This is a shortest-time spread problem where infection propagates in **waves** (minute by minute).
That maps directly to **Breadth-First Search (BFS)** levels:

- All initially infected servers are level 0 (minute 0)
- All servers infected from them are level 1 (minute 1)
- and so on

Because each level is one minute, BFS gives the minimum time naturally.

## Algorithm (Multi-source BFS)

1. Traverse the grid once:
   - count all healthy servers
   - push all infected servers into a queue
2. If healthy count is 0, return `0`
3. Run BFS while queue is not empty and healthy servers still exist:
   - process one full queue level (one minute)
   - infect valid 4-directional healthy neighbors
   - decrement healthy count
4. After BFS:
   - if healthy count is 0 -> return elapsed minutes
   - else -> return `-1`

## Complexity

- Time: `O(rows * cols)`
- Space: `O(rows * cols)` in worst case (queue)

## Java implementation

Implemented in:

- `src/main/java/com/ds/algo/concepts/ask_questions/MinimumTimeToInfectServers.java`

Main API:

- `MinimumTimeToInfectServers.minMinutesToInfectAll(int[][] grid)`

Unit tests:

- `src/test/java/com/ds/algo/concepts/ask_questions/MinimumTimeToInfectServersTest.java`

# Find maximum subarray sum (Kadane's Algorithm)
