package com.ds.algo.concepts.take_u_forward.basic.math.programs;

public class RecursiveFibonacci {

    // Recursive function to compute Nth Fibonacci number
    public static int fibonacci(int N) {
        // Base case: return N if it's 0 or 1
        if (N <= 1) {
            return N;
        }

        // Recursive case: calculate previous two terms
        int last = fibonacci(N - 1);    // (N-1)th term
        int slast = fibonacci(N - 2);   // (N-2)th term

        return last + slast;
    }

    public static void main(String[] args) {
        int N = 4;
        if (N < 0) {
            System.out.println("Please enter a non-negative term index.");
            return;
        }

        System.out.println("The Fibonacci Series up to " + N + "th term:");
        StringBuilder series = new StringBuilder();
        for (int i = 0; i <= N; i++) {
            if (i > 0) {
                series.append(" ");
            }
            series.append(fibonacci(i));
        }

        System.out.println(series);
    }
}

