package com.ds.algo.concepts.take_u_forward.basic.math.programs;

public class CheckPrime {

	/**
	 * Checks whether a number is prime.
	 *
	 * <p>Optimized approach:
	 * <ul>
	 *   <li>Handle small numbers directly</li>
	 *   <li>Exclude multiples of 2 and 3</li>
	 *   <li>Test only numbers of form 6k-1 and 6k+1 up to sqrt(n)</li>
	 * </ul>
	 *
	 * <p>Time Complexity: O(sqrt(n))
	 * <br>Space Complexity: O(1)
	 *
	 * @param n number to test
	 * @return true if n is prime, else false
	 */
	public static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}

		if (n <= 3) {
			return true;
		}

		if (n % 2 == 0 || n % 3 == 0) {
			return false;
		}

		for (int i = 5; (long) i * i <= n; i += 6) {
			if (n % i == 0 || n % (i + 2) == 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		int n = 29;
		System.out.println(n + " is prime? " + isPrime(n));
	}
}
