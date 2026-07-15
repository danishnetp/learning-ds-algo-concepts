package com.ds.algo.concepts.take_u_forward.basic.math;

public class GCDOfTwoNumber {

	public static void main(String[] args) {
		int a = 36;
		int b = 60;
		int result = gcd(a, b);

		System.out.println("GCD(" + a + ", " + b + ") = " + result);
	}

	/**
	 * Finds GCD using iterative Euclidean algorithm.
	 *
	 * <p>Time Complexity: O(log(min(a, b)))
	 *
	 * @param a first number
	 * @param b second number
	 * @return greatest common divisor of a and b
	 */
	public static int gcd(int a, int b) {
		long result = gcdEuclidean(a, b);

		if (result > Integer.MAX_VALUE) {
			throw new ArithmeticException("GCD overflows int range: " + result);
		}

		return (int) result;
	}

	/**
	 * Long-safe Euclidean GCD.
	 *
	 * <p>Useful for edge cases where int absolute value can overflow,
	 * such as Integer.MIN_VALUE.
	 *
	 * @param a first number
	 * @param b second number
	 * @return non-negative greatest common divisor of a and b
	 */
	public static long gcdEuclidean(long a, long b) {
		long x = Math.abs(a);
		long y = Math.abs(b);

		if (x == 0 && y == 0) {
			throw new IllegalArgumentException("GCD is undefined for (0, 0)");
		}

		// Euclidean algorithm: gcd(a, b) = gcd(b, a % b)
		while (y != 0) {
			long temp = y;
			y = x % y;
			x = temp;
		}

		return x;
	}
}
