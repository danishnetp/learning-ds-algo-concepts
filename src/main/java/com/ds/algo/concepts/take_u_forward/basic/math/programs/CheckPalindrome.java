package com.ds.algo.concepts.take_u_forward.basic.math.programs;

import java.util.List;
import java.util.Objects;
import java.util.function.IntFunction;

public class CheckPalindrome<T> {
    public static void main(String[] args) {
        CheckPalindrome<Character> characterChecker = new CheckPalindrome<>();
        CheckPalindrome<Integer> integerChecker = new CheckPalindrome<>();

        System.out.println(isPalindrome(12321)); // true
        System.out.println(isPalindrome(-12321)); // false
        System.out.println(isPalindrome(123)); // false
        System.out.println(isPalindrome("racecar")); // true
        System.out.println(isPalindrome("hello")); // false
        System.out.println(characterChecker.isPalindrome(new Character[] {'a', 'b', 'b', 'a'})); // true
        System.out.println(integerChecker.isPalindrome(List.of(1, 2, 3, 2, 1))); // true
        System.out.println(isPalindromeRecursive("abcba")); // true
    }

    public static boolean isPalindrome(String value) {
        CheckPalindrome<Character> checker = new CheckPalindrome<>();
        return value != null && checker.isPalindromeByIndex(value.length(), value::charAt);
    }

    public static boolean isPalindromeRecursive(String value) {
        if (value == null) {
            return false;
        }
        return palindrome(0, value);
    }

    private static boolean palindrome(int i, String s) {
        // Base Condition: If i exceeds half of the string, all the elements have been compared
        // and the string is a palindrome, return true.
        if (i >= s.length() / 2) return true;

        // If the start and end characters are not equal, it's not a palindrome.
        if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;

        // If both characters are the same, increment i and check start+1 and end-1.
        return palindrome(i + 1, s);
    }

    public static boolean isPalindrome(int number) {
        if (number < 0) {
            return false; // Negative numbers are not palindromes
        }
        return isPalindrome(Integer.toString(number));
    }

    public boolean isPalindrome(T[] items) {
        return items != null && isPalindromeByIndex(items.length, index -> items[index]);
    }

    public boolean isPalindrome(List<T> items) {
        return items != null && isPalindromeByIndex(items.size(), items::get);
    }

    private boolean isPalindromeByIndex(int size, IntFunction<T> valueAt) {
        int left = 0;
        int right = size - 1;

        while (left < right) {
            if (!Objects.equals(valueAt.apply(left), valueAt.apply(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
