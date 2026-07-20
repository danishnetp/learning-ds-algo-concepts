# Analysis of Time Complexity

> **Rules for calculating the final value:**
> 1. Eliminate constants.
> 2. Retain the highest-order term.

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

Constant and lower-order terms are eliminated, so the final time complexity is `n^2`.


Big-O notation:

`O(n^2)`

## Analysis for Nested 3 Loop Time Complexity

### Example: Multiplication of a 2D Array

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

`(n + 1) + n * (n + 1) + n * n * (n + 1) + n * n * n = n + 1 + n^2 + n + n^3 + n^2 + n^3 = 2n^3 + 2n^2 + 2n + 1`

Big-O notation:

`O(n^3)`
