package com.ds.algo.concepts.hacker_rank.algorithm;

import java.util.Arrays;
import java.util.List;

public class MinMaxSumDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        //minMaxSum(arr);

        miniMaxSumBruteForce(Arrays.asList(396285104, 573261094, 759641832, 819230764, 364801279));
    }

    public static void miniMaxSumBruteForce(List<Integer> arr) {
        // Write your code here
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        long maxSum = 0;
        long minSum = 0;
        long sum = 0;
        for(int n : arr){
            if(n > max){
                max = n;
            }if(n < min){
                min = n;
            }
            sum += n;
        }
        maxSum = sum - min;
        minSum = sum - max;
        System.out.println(minSum +" "+maxSum);

    }

    public static void minMaxSum(int[] arr) {
        long totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        long minSum = totalSum - Integer.MAX_VALUE; // Initialize to a large value
        long maxSum = totalSum - Integer.MIN_VALUE; // Initialize to a small value

        for (int num : arr) {
            long currentSum = totalSum - num;
            if (currentSum < minSum) {
                minSum = currentSum;
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        System.out.println(minSum + " " + maxSum);
    }
}
