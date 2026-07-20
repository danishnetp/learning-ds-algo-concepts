# Analysis of Time Complexity

## Analysis for Loop Time Complexity

```java
for (int i = 0; i < n; i++) {
    System.out.println(i);
}
```

- Loop condition check: `n + 1` times
- `System.out.println(i)`: `n` times

Total time complexity:

`n + 1 + n = 2n + 1`

Big-O notation:

`O(n)`

Note: when getting the final value, we remove constant terms and keep the higher-order term.

## Analysis for Nested Loop Time Complexity

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        System.out.println(i + ", " + j);
    }
}
```

- Outer loop condition check: `n + 1` times
- Inner loop condition check: `n * (n + 1)` times
- `System.out.println(i + ", " + j)`: `n * n` times

Total time complexity:

`(n + 1) + n * (n + 1) + n * n = n + 1 + n^2 + n + n^2 = 2n^2 + 2n + 1`

Graph of above time-complexity:

```text
Operations
^
|                                *
|                          *
|                    *
|              *
|        *
|   *
+--------------------------------------> n
    1    2    3    4    5    6

Curve shown: y = n^2
```

Big-O notation:

`O(n^2)`



## Analysis for Nested 3 Loop Time Complexity

### Example: multiplication of 2D array

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
            System.out.println(i + ", " + j + ", " + k);
        }
    }
}
```

- Outer loop condition check: `n + 1` times
- Middle loop condition check: `n * (n + 1)` times
- Inner loop condition check: `n * n * (n + 1)` times
- `System.out.println(i + ", " + j + ", " + k)`: `n * n * n` times

Total time complexity:

`(n + 1) + n * (n + 1) + n * n * (n + 1) + n * n * n = n^3 + n^3 + n^2 + n^2 + n + 1`

Big-O notation:

`O(n^3)`
