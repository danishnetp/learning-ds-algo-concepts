package com.ds.algo.concepts.take_u_forward.basic.math.programs;

import java.util.*;

public class PrintAllDivisors {
    // Function to get all divisors
    public List<Integer> getDivisors(int N) {
        // Use TreeSet to keep divisors unique and sorted.
        Set<Integer> divisors = new TreeSet<>();

        // Loop from 1 to square root of N
        for (int i = 1; i * i <= N; i++) {
            // Check if i divides N
            if (N % i == 0) {
                divisors.add(i);
                divisors.add(N / i);
            }
        }

        return new ArrayList<>(divisors);
    }

    public static void main(String[] args) {
        // Create object of Solution class
        PrintAllDivisors sol = new PrintAllDivisors();

        // Input number
        int N = 36;

        // Get divisors
        List<Integer> result = sol.getDivisors(N);

        // Print the result
        System.out.print("Divisors of " + N + ": ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
