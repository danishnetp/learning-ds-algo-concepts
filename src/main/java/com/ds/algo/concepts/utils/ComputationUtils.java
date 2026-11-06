package com.ds.algo.concepts.utils;

public class ComputationUtils {
    public static void main(String[] args) {
       // System.out.println("Total digits: " + calculateTotalDigits(3));
        System.out.println("Log10: " + log10(5));
    }

    public static int calculateTotalDigits(int number) {
        if (number == 0) {
            return 1;
        }
        return (int)(Math.log10(Math.abs(number))) + 1;
    }

    public static int log10(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number must be positive.");
        }
        return (int)(Math.log10(number));
    }

    public static void testModuleOperator(int x, int y) {
        System.out.println("Module Operator: " + y + " % " + x + " = " + (y % x));
    }
}
