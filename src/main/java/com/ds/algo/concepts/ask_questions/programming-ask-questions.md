# Programming Ask Questions

## 1) Minimum Time to Infect All Servers (Grid BFS)

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

### Sample

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

### Why BFS is the right approach

This is a shortest-time spread problem where infection propagates in waves (minute by minute).
That maps directly to Breadth-First Search (BFS) levels:

- All initially infected servers are level 0 (minute 0)
- All servers infected from them are level 1 (minute 1)
- and so on

Because each level is one minute, BFS gives the minimum time naturally.

### Algorithm (Multi-source BFS)

1. Traverse the grid once:
   - count all healthy servers
   - push all infected servers into a queue
2. If the healthy count is `0`, return `0`
3. Run BFS while the queue is not empty and healthy servers still exist:
   - process one full queue level (one minute)
   - infect valid 4-directional healthy neighbors
   - decrement the healthy count
4. After BFS:
   - if healthy count is `0`, return elapsed minutes
   - else return `-1`

### Complexity

- Time: `O(rows * cols)`
- Space: `O(rows * cols)` in the worst case (queue)

### Java implementation

Implemented in:

- `src/main/java/com/ds/algo/concepts/ask_questions/MinimumTimeToInfectServers.java`

Main API:

- `MinimumTimeToInfectServers.minMinutesToInfectAll(int[][] grid)`

Unit tests:

- `src/test/java/com/ds/algo/concepts/ask_questions/MinimumTimeToInfectServersTest.java`

---

## 2) Find Maximum Subarray Sum (Kadane's Algorithm)

Given an integer array, find the maximum sum of any contiguous subarray.

### Example

```text
Input:  [-2, 1, -3, 4, -1, 2, 1, -5, 4]
Output: 6
```

### Key idea

Kadane's algorithm tracks:

- the maximum sum ending at the current position
- the maximum sum seen so far

This yields a linear-time solution.

---

## 3) Word Counter (Maps & Frequency)

Given an array of words, count the frequency of each word and return the most frequently occurring word along with its count.

### Example

```text
Input: ["apple", "banana", "apple", "orange", "banana", "apple", "grape"]
```

### Output

```text
Word: apple
Count: 3
```

### Approach

- Use a `Map<String, Integer>`
- Count each word occurrence
- Track the word with the highest frequency

---

## 4) Intersection Finder (Common Items)

Given two lists of user IDs, find all unique IDs present in both lists.

### Example

```text
List1 = [1, 2, 2, 3, 4]
List2 = [2, 2, 4, 5]
```

### Output

```text
[2, 4]
```

### Approach

- Convert one list into a set
- Check each element from the second list
- Keep only values present in both sets

---

## 5) Group Anagrams

Given an array of strings, group all anagrams together.

### Example

```text
Input:
["eat", "tea", "tan", "ate", "nat", "bat"]
```

### Output

```text
[
  ["eat", "tea", "ate"],
  ["tan", "nat"],
  ["bat"]
]
```

### Approach

- Use a key based on sorted characters of each string
- Group strings with the same key together

---

## 6) Dockerfile for Word Counter

How would you write a Dockerfile to containerize the Word Counter program?

### Example Dockerfile

```dockerfile
FROM openjdk:17
WORKDIR /app
COPY . .
RUN javac Main.java
CMD ["java", "Main"]
```

You can adjust the file names and Java class structure based on your project layout.

---

## 7) Count Leaf Nodes in a Tree

Find the number of leaf nodes in a binary tree.

### Idea

A node is a leaf if it has no left child and no right child.

---

## 8) Find the Second Highest Number in an Array

Find the second largest distinct number from the array.

### Example

```text
Input: [12, 35, 1, 10, 34, 1]
Output: 34
```

### Approach

- Track the largest and second-largest distinct values
- Traverse the array once

---
