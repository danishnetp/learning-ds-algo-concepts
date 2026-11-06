package com.ds.algo.concepts.gog.ds_algo;

public class DigitsInFactorial {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Number of factorial digits in " + n + "! is: " + digitsInFactorial(n));
    }

    public static int digitsInFactorial(int n) {
        if (n < 0)
            return 0;
        // base case
        if (n <= 1)
            return 1;
        // else iterate through n and calculate the
        // value
        double digits = 0;
        for (int i = 2; i <= n; i++)
            digits += Math.log10(i);

        return (int) (Math.floor(digits)) + 1;
    }

}
