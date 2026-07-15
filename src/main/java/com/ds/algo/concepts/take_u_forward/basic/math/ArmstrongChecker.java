package com.ds.algo.concepts.take_u_forward.basic.math;

/**
 * Utility to check whether a number is an Armstrong number.
 *
 * <p>An Armstrong number is a number that is equal to the sum of its own digits,
 * each raised to the power of the number of digits.
 *
 * <p>Examples:
 * <ul>
 *   <li>153 -> 1^3 + 5^3 + 3^3 = 153</li>
 *   <li>18 -> 1^2 + 8^2 = 65 (not Armstrong)</li>
 * </ul>
 */
public class ArmstrongChecker {

	/**
	 * Checks whether the provided number is an Armstrong number.
	 *
	 * <p>Approach:
	 * <ol>
	 *   <li>Count digits</li>
	 *   <li>Precompute powers digit^digits for 0..9</li>
	 *   <li>Sum powers of each digit and compare with original number</li>
	 * </ol>
	 *
	 * <p>Time Complexity: O(d), where d is the number of digits.
	 * <br>Space Complexity: O(1), because the power cache has fixed size 10.
	 *
	 * @param number input integer
	 * @return true if the number is Armstrong, else false
	 */
	public static boolean isArmstrong(int number) {
		if (number < 0) {
			return false;
		}

		int digits = countDigits(number);
		int[] powers = precomputeDigitPowers(digits);

		int temp = number;
		int sum = 0;

		do {
			int digit = temp % 10;
			sum += powers[digit];
			temp /= 10;
		} while (temp != 0);

		return sum == number;
	}

	private static int countDigits(int number) {
		int temp = number;
		int count = 0;
		do {
			count++;
			temp /= 10;
		} while (temp != 0);
		return count;
	}

	private static int[] precomputeDigitPowers(int exponent) {
		int[] powers = new int[10];
		for (int digit = 0; digit <= 9; digit++) {
			powers[digit] = pow(digit, exponent);
		}
		return powers;
	}

	private static int pow(int base, int exponent) {
		int result = 1;
		for (int i = 0; i < exponent; i++) {
			result *= base;
		}
		return result;
	}

	public static void main(String[] args) {
		int number = 18;
		System.out.println(number + " is Armstrong? " + isArmstrong(number));
	}
}

