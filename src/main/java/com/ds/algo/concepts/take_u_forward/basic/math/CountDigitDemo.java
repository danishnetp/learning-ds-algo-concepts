package com.ds.algo.concepts.take_u_forward.basic.math;

/**
 * Demonstrates two approaches for counting the number of digits in an integer.
 *
 * <p><b>Approach 1 – Iterative division:</b> Repeatedly divide the number by 10
 * until it reaches 0, incrementing a counter each time. Works for all integers.
 * <br>Time Complexity: O(log₁₀ n) &nbsp;|&nbsp; Space Complexity: O(1)
 *
 * <p><b>Approach 2 – Logarithm (optimal):</b> Uses the mathematical identity
 * {@code floor(log₁₀(n)) + 1} to get the digit count in O(1) time.
 * <br>Time Complexity: O(1) &nbsp;|&nbsp; Space Complexity: O(1)
 *
 * <p><b>Note:</b> The logarithmic approach does NOT handle n ≤ 0.
 * Use the iterative approach when the input may be zero or negative.
 */
public class CountDigitDemo {

    /**
     * Entry point – demonstrates both digit-counting methods on a sample number.
     */
    public static void main(String[] args) {
        int number = 1234567890;
        int digitCount = countDigits(number);
        System.out.println("Number of digits in " + number + " is: " + digitCount);
    }

    /**
     * Counts the digits of {@code number} using iterative division.
     *
     * <p>Algorithm: strip the last digit with {@code number /= 10} on each
     * iteration until the value becomes 0, counting each step.
     *
     * <p>Edge case: returns 1 for {@code number == 0} because zero itself
     * is a 1-digit number.
     *
     * <p><b>Time Complexity: O(log₁₀ n)</b>
     * <br>Each iteration divides {@code number} by 10, so the loop runs exactly
     * as many times as there are digits in {@code n}.
     * A d-digit number satisfies {@code 10^(d-1) ≤ n < 10^d}, meaning
     * {@code d = floor(log₁₀ n) + 1} iterations are needed.
     * For a 32-bit int the loop runs at most 10 times (since max int ≈ 2.1 × 10⁹).
     *
     * <p><b>Space Complexity: O(1)</b>
     * <br>Only a fixed number of integer variables ({@code count}, {@code number})
     * are used regardless of input size — no extra data structures.
     *
     * @param number the integer whose digits are to be counted
     * @return the total number of digits in {@code number}
     */
    static int countDigits(int number) {
        if (number == 0) {
            return 1; // Edge case: 0 is represented by a single digit '0'
        }

        int count = 0;
        // Each division by 10 removes one digit.
        // Loop runs exactly d times where d = number of digits in |number|.
        // e.g. n=1234 → 4 iterations (1234→123→12→1→0)
        // Time per iteration: O(1) division  →  Total: O(log₁₀ n)
        while (number != 0) {
            number /= 10; // Remove the last digit (e.g. 1234 → 123 → 12 → 1 → 0)
            count++;
        }
        return count;
    }

    /**
     * Counts the digits of a hard-coded number using the logarithmic formula.
     *
     * <p>Formula: {@code (int)(Math.log10(n) + 1)}
     *
     * <ul>
     *   <li>{@code Math.log10(n)} returns the base-10 logarithm.
     *       <br>Example: {@code log10(1000) = 3.0}, {@code log10(999) ≈ 2.9996}
     *   <li>Adding 1 shifts the result so that the floor equals the digit count.
     *       <br>Example: {@code floor(3.0 + 1) = 4} for 1000 (which has 4 digits).
     *   <li>Casting to {@code int} applies an implicit floor (truncation toward zero).
     * </ul>
     *
     * <p><b>Time Complexity: O(1)</b>
     * <br>{@code Math.log10()} is a single hardware-level floating-point instruction
     * whose cost does NOT grow with the value of {@code n}. There are no loops
     * or recursive calls — the result is computed in constant time regardless of
     * how large the number is.
     *
     * <p><b>Space Complexity: O(1)</b>
     * <br>Only one local variable ({@code number}) is used; no extra memory
     * is allocated based on the input value.
     *
     * <p><b>Limitation:</b> {@code Math.log10} is undefined for n ≤ 0 and returns
     * {@code -Infinity} for 0, so this method must only be called with a positive integer.
     *
     * @return the number of digits in the hard-coded sample value {@code 1234567890}
     */
    static int countDigitsOptimalApproach() {
        int number = 1234567890;

        // WHY +1?
        // Any d-digit number n satisfies:  10^(d-1)  <=  n  <  10^d
        // Taking log10 of all sides:         d-1     <= log10(n) < d
        // So:  floor(log10(n)) = d - 1   ← always ONE less than the digit count
        // Adding 1 corrects that off-by-one:
        //   floor(log10(n)) + 1 = d      ← the actual digit count
        //
        // Worked examples:
        //   n=9    → log10(9)  ≈ 0.954  → floor=0 → 0+1 = 1 digit  ✓
        //   n=10   → log10(10) = 1.0    → floor=1 → 1+1 = 2 digits ✓
        //   n=100  → log10(100)= 2.0    → floor=2 → 2+1 = 3 digits ✓
        //   n=1234567890 → log10 ≈ 9.09 → floor=9 → 9+1 = 10 digits ✓
        //
        // TIME:  O(1) — Math.log10 is a single floating-point CPU instruction,
        //        no loop or recursion; cost is constant regardless of n's magnitude.
        // SPACE: O(1) — no extra data structures; only fixed local variables.
        //
        // Casting to (int) performs the floor (truncation toward zero) automatically.
        return (int) (Math.log10(number) + 1);
    }
}
