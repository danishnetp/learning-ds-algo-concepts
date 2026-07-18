package com.ds.algo.concepts.take_u_forward.basic.math.programs;

public class FibonacciEfficient {
    public static void main(String[] args) {
        int n = 5;

        if (n < 0) {
            System.out.println("Please enter a non-negative term index.");
            return;
        }

        // If n is 0, print only the first term
        if (n == 0) {
            System.out.println("The Fibonacci Series up to " + n + "th term:");
            System.out.println(0);
        } else {
            int secondLast = 0; // (i-2)th term
            int last = 1;       // (i-1)th term

            System.out.println("The Fibonacci Series up to " + n + "th term:");
            StringBuilder series = new StringBuilder();
            series.append(secondLast).append(" ").append(last);

            int cur;
            for (int i = 2; i <= n; i++) {
                cur = last + secondLast;  // Calculate current term
                secondLast = last;        // Slide the window
                last = cur;
                series.append(" ").append(cur);
            }
            System.out.println(series);
        }
    }
}

