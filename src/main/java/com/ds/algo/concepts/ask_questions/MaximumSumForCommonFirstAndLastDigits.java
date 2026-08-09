package com.ds.algo.concepts.ask_questions;

import java.util.HashMap;
import java.util.Map;

public class MaximumSumForCommonFirstAndLastDigits {

    public static void main(String[] args) {
        int[] arr = {405, 45, 300, 300, 415};
        //System.out.println(findSumBrutForceApproach(arr));
        System.out.println(findMaxSameDigitsPairSum(arr));
    }


    /**
     * Finds and prints pairs with matching first and last digits,
     * and returns the maximum pair sum found.
     */
    public static int findMaxSameDigitsPairSum(int[] arr) {
        int max = -1; // Changed to -1 to handle arrays with sums of 0 correctly

        // Map key: combined (firstDigit * 10 + lastDigit). Value: Max number found with these digits
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            int key = getFirstAndLastDigitKey(num);

            // If we previously saw a number with the exact same first and last digit
            if (map.containsKey(key)) {
                int prevMaxNum = map.get(key);
                int sum = num + prevMaxNum;
                if (sum > max) {
                    max = sum;
                }
                System.out.println("Numbers: " + prevMaxNum + ", " + num + " have the same first and last digits. Sum: " + sum);

                // Keep the larger of the two numbers for future potential pairs
                if (num > prevMaxNum) {
                    map.put(key, num);
                }
            } else {
                map.put(key, num);
            }
        }

        return max == -1 ? 0 : max;
    }

    private static int getFirstAndLastDigitKey(int number) {
        int lastDigit = Math.abs(number % 10);
        int firstDigit = Math.abs(number);
        while (firstDigit >= 10) {
            firstDigit /= 10;
        }
        return firstDigit * 10 + lastDigit;
    }

    private static int findSumBrutForceApproach(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (isFirstAndLastDigitSame(arr[i], arr[j])) {
                    int sum = arr[i] + arr[j];
                    if(max < sum){
                        max = sum;
                    }
                    System.out.println("Numbers: " + arr[i] + ", " + arr[j] + " have the same first and last digits. Sum: " + sum);
                }
            }
        }
        return max;
    }


    static boolean isFirstAndLastDigitSame(int firstNumber, int lastNumber) {
        int firstDigitOfFirstNumber = Integer.parseInt(Integer.toString(firstNumber).substring(0, 1));
        int lastDigitOfFirstNumber = Integer.parseInt(Integer.toString(firstNumber).substring(Integer.toString(firstNumber).length() - 1));

        int firstDigitOfLastNumber = Integer.parseInt(Integer.toString(lastNumber).substring(0, 1));
        int lastDigitOfLastNumber = Integer.parseInt(Integer.toString(lastNumber).substring(Integer.toString(lastNumber).length() - 1));
        return (firstDigitOfFirstNumber == firstDigitOfLastNumber) && (lastDigitOfFirstNumber == lastDigitOfLastNumber);
    }
}


