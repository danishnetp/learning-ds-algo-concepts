# Useful Formulas for Data Structures and Algorithms

## 1. Basic Math Formulas

### Arithmetic Series
- Sum: `S = n/2 * (first + last) = n/2 * (2a + (n-1)d)`
- nth term: `a_n = a + (n-1)d`

### Geometric Series
- Sum: `S = a * (r^n - 1) / (r - 1)` (r ≠ 1)
- nth term: `a_n = a * r^(n-1)`

### Power of 2
- Sum: `1 + 2 + 4 + 8 + ... + 2^(n-1) = 2^n - 1`
- Sum: `2^0 + 2^1 + 2^2 + ... + 2^n = 2^(n+1) - 1`

### Factorial
- `n! = n × (n-1) × (n-2) × ... × 1`
- `0! = 1`

### Permutations & Combinations
- Permutations: `P(n, r) = n! / (n-r)!`
- Combinations: `C(n, r) = n! / (r! × (n-r)!)`
- Pascal's identity: `C(n, r) = C(n-1, r-1) + C(n-1, r)`

### Sum Formulas
- Sum of first n natural numbers: `1 + 2 + 3 + ... + n = n(n+1)/2`
- Sum of squares: `1² + 2² + 3² + ... + n² = n(n+1)(2n+1)/6`
- Sum of cubes: `1³ + 2³ + 3³ + ... + n³ = [n(n+1)/2]²`

---

## 2. Number Theory

### GCD & LCM
- `GCD(a, b) × LCM(a, b) = a × b`
- Euclidean Algorithm: `GCD(a, b) = GCD(b, a mod b)`

### Prime Numbers
- Trial division up to: `sqrt(n)` (sufficient to check primality)
- All primes > 3 are of form: `6k ± 1`
- Count of primes up to n (approximation): `n / ln(n)`

### Divisors
- If n = p₁^a₁ × p₂^a₂ × ... × pₖ^aₖ, then:
  - Number of divisors: `(a₁+1) × (a₂+1) × ... × (aₖ+1)`
  - Sum of divisors: `(p₁^(a₁+1)-1)/(p₁-1) × (p₂^(a₂+1)-1)/(p₂-1) × ...`

### Modular Arithmetic
- `(a + b) mod m = ((a mod m) + (b mod m)) mod m`
- `(a × b) mod m = ((a mod m) × (b mod m)) mod m`
- `(a - b) mod m = ((a mod m) - (b mod m) + m) mod m`
- Fermat's Little Theorem: `a^(p-1) ≡ 1 (mod p)` for prime p

### Power Calculation
- Binary exponentiation time: `O(log n)`
- Modular exponentiation: `(base^exp) mod m`

---

## 3. String & Array Formulas

### Count of Subarrays/Substrings
- Number of subarrays of length n: `n(n+1)/2`
- Number of subarrays with sum = k in array: depends on data (use HashMap)
- Number of substrings of string (length n): `n(n+1)/2`

### Maximum Subarray
- Kadane's Algorithm for max sum subarray: `O(n)` time

### Palindrome
- Longest palindromic substring: `O(n²)` brute force, `O(n)` using Manacher's Algorithm

---

## 4. Tree Formulas

### Complete Binary Tree
- Nodes in perfect binary tree of height h: `2^(h+1) - 1`
- Height of complete binary tree with n nodes: `floor(log₂(n))`
- Maximum nodes at level h: `2^h`
- Number of leaf nodes: `ceil(n/2)`

### Binary Search Tree (BST)
- Average search time: `O(log n)`
- Worst case (skewed): `O(n)`

### Balanced Trees (AVL, Red-Black)
- Height: `O(log n)`
- All operations: `O(log n)`

### N-ary Tree
- Total nodes with degree constraint: derived from sum of levels

---

## 5. Graph Formulas

### Edges in Complete Graph
- Undirected: `E = n(n-1)/2` where n = vertices
- Directed: `E = n(n-1)`

### Handshaking Lemma
- Sum of all degrees = 2 × (number of edges)

### Euler's Formula (Planar Graphs)
- `V - E + F = 2` (V = vertices, E = edges, F = faces)

### Traversal Complexity
- BFS / DFS: `O(V + E)`
- Dijkstra (binary heap): `O((V + E) log V)`
- Floyd-Warshall: `O(V³)`

### Shortest Path
- Shortest path between all pairs: Floyd-Warshall `O(V³)`
- Single source shortest path (non-negative weights): Dijkstra `O((V + E) log V)`
- Negative weight shortest path: Bellman-Ford `O(V × E)`

---

## 6. Sorting & Searching

### Comparison Based Sorting
- Lower bound: `Ω(n log n)`
- Bubble Sort, Selection Sort, Insertion Sort: `O(n²)`
- Merge Sort, Quick Sort, Heap Sort: `O(n log n)`

### Non-Comparison Sorting
- Counting Sort: `O(n + k)` where k = range
- Radix Sort: `O(d × n)` where d = number of digits
- Bucket Sort: `O(n + k)` average case

### Searching
- Linear Search: `O(n)`
- Binary Search (sorted array): `O(log n)`
- Hash-based Search: `O(1)` average, `O(n)` worst

---

## 7. Dynamic Programming Patterns

### Fibonacci
- Recursive: `T(n) = O(2^n)`
- DP: `T(n) = O(n), S(n) = O(n)`
- Space Optimized: `S(n) = O(1)`

### Catalan Numbers
- Formula: `C(n) = (2n)! / ((n+1)! × n!)`
- Recurrence: `C(n) = Σ C(i) × C(n-1-i)` for i = 0 to n-1
- Applications: balanced parentheses, BSTs, paths in grid

### Longest Common Subsequence (LCS)
- Time: `O(m × n)`, Space: `O(m × n)` or `O(min(m, n))`

### Longest Increasing Subsequence (LIS)
- DP: `O(n²)` time
- Binary Search optimized: `O(n log n)` time

### 0/1 Knapsack
- Time: `O(n × W)` where W = capacity
- Space: `O(n × W)` or `O(W)` optimized

---

## 8. Bit Manipulation

### Power of 2
- Check if n is power of 2: `(n & (n-1)) == 0 && n != 0`
- Find highest power of 2 ≤ n: use bit operations

### XOR Properties
- `a ^ a = 0`
- `a ^ 0 = a`
- `a ^ b = b ^ a` (commutative)
- `(a ^ b) ^ c = a ^ (b ^ c)` (associative)

### Set Bits Count
- Count set bits: `O(log n)` or use `Integer.bitCount(n)`

### Single Number Problem
- Find single number in array: use XOR of all elements

---

## 9. Complexity Analysis Cheat Sheet

### Time Complexity Order (Fastest to Slowest)
- `O(1)` - Constant
- `O(log n)` - Logarithmic (binary search)
- `O(n)` - Linear
- `O(n log n)` - Linearithmic (merge sort, quick sort)
- `O(n²)` - Quadratic (bubble sort, nested loops)
- `O(n³)` - Cubic
- `O(2^n)` - Exponential
- `O(n!)` - Factorial

### Common Data Structure Complexities

| Operation | Array | Linked List | Hash Table | BST  | Balanced Tree |
|-----------|-------|-------------|------------|------|---------------|
| Access    | O(1)  | O(n)        | O(1) avg   | O(n) | O(log n)      |
| Search    | O(n)  | O(n)        | O(1) avg   | O(n) | O(log n)      |
| Insert    | O(n)  | O(1)        | O(1) avg   | O(n) | O(log n)      |
| Delete    | O(n)  | O(1)        | O(1) avg   | O(n) | O(log n)      |

---

## 10. Useful Constants & Rules

### Binary
- 1 byte = 8 bits
- 1 KB = 1024 bytes
- Max int (32-bit): 2^31 - 1 = 2,147,483,647
- Min int (32-bit): -2^31 = -2,147,483,648

### Practical Limits
- If O(n!) → n ≤ 12
- If O(2^n) → n ≤ 20
- If O(n³) → n ≤ 500
- If O(n²) → n ≤ 10,000
- If O(n log n) → n ≤ 10^6
- If O(n) → n ≤ 10^8

### Master's Theorem
For recurrence `T(n) = a·T(n/b) + f(n)`:
1. If `f(n) = O(n^(log_b(a) - ε))` then `T(n) = Θ(n^(log_b(a)))`
2. If `f(n) = Θ(n^(log_b(a)))` then `T(n) = Θ(n^(log_b(a)) × log n)`
3. If `f(n) = Ω(n^(log_b(a) + ε))` then `T(n) = Θ(f(n))`

---

## 11. Geometry Formulas

### Distance
- Euclidean distance: `√((x₂-x₁)² + (y₂-y₁)²)`
- Manhattan distance: `|x₂-x₁| + |y₂-y₁|`

### Area & Perimeter
- Triangle: Area = `base × height / 2`, Perimeter = `a + b + c`
- Rectangle: Area = `length × width`, Perimeter = `2(l + w)`
- Circle: Area = `π × r²`, Circumference = `2π × r`

---

## 12. Combinatorial Formulas

### Derangement
- Number of ways to arrange n items such that no item is in original position: `D(n) = (n-1) × (D(n-1) + D(n-2))`

### Stirling's Approximation
- `n! ≈ √(2πn) × (n/e)^n`

### Stars and Bars
- Number of ways to distribute n identical items into k distinct boxes: `C(n+k-1, k-1)`

---

## Notes
- Always consider **integer overflow** when computing large results
- Use **modulo arithmetic** for problems asking for answer mod 10^9+7
- **Memoization** can convert exponential algorithms to polynomial
- **Greedy algorithms** often provide optimal solutions for specific problem structures
- **Prefix sums** can optimize range query problems from O(n) to O(1)

