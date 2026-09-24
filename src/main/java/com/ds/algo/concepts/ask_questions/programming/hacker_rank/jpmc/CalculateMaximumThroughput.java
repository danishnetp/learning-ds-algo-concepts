package com.ds.algo.concepts.ask_questions.programming.hacker_rank.jpmc;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'getMaximumThroughput' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY throughput
     *  2. INTEGER_ARRAY scalingCost
     *  3. INTEGER budget
     */

    public static int getMaximumThroughput(List<Integer> throughput, List<Integer> scalingCost, int budget) {
        // Write your code here
        long low = 1;
        long high = 0;

        for(int i = 0; i < throughput.size(); i++) {
            long maxPossible = (long) throughput.get(i) * (1 + (long) budget / scalingCost.get(i));
            high = Math.max(high, maxPossible);
        }

        int maxThroughput = 1;

        while(low <= high){
            long mid = low + (high - low )/2;

            if(canReachTarget(throughput,scalingCost, budget, mid)){
                maxThroughput = (int) mid;
                low = mid + 1;
            }else {
                high = mid -1 ;
            }
        }
        return maxThroughput;

    }

    private static boolean canReachTarget(List<Integer> throughput, List<Integer> scalingCost, int budget, long target){
        long cost = 0;

        for(int i = 0; i < throughput.size(); i++){
            long base = throughput.get(i);

            if(base < target){
                long steps = (target + base - 1) / base - 1;
                cost += steps * scalingCost.get(i);

                if(cost > budget) {
                    return false;
                }
            }
        }

        return cost <= budget;
    }

}

public class CalculateMaximumThroughput {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int throughputCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> throughput = new ArrayList<>();

        for (int i = 0; i < throughputCount; i++) {
            int throughputItem = Integer.parseInt(bufferedReader.readLine().trim());
            throughput.add(throughputItem);
        }

        int scalingCostCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scalingCost = new ArrayList<>();

        for (int i = 0; i < scalingCostCount; i++) {
            int scalingCostItem = Integer.parseInt(bufferedReader.readLine().trim());
            scalingCost.add(scalingCostItem);
        }

        int budget = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.getMaximumThroughput(throughput, scalingCost, budget);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

