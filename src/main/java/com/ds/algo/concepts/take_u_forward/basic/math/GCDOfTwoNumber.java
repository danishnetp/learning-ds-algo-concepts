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
		int x = Math.abs(a);
		int y = Math.abs(b);

		if (x == 0 && y == 0) {
			throw new IllegalArgumentException("GCD is undefined for (0, 0)");
		}

		// Euclidean algorithm: gcd(a, b) = gcd(b, a % b)
		while (y != 0) {
			int temp = y;
			y = x % y;
			x = temp;
		}

		return x;
	}
}
