package com.ds.algo.concepts.hacker_rank.algorithm;

public class TimeConversionDemo {
    public static void main(String[] args) {
        String s = "07:05:45PM";
        System.out.println(timeConversion(s));
    }

    public static String timeConversion(String s) {
        // Write your code here
        //int hour = s.substring
        int minunte = Integer.valueOf(s.substring(3, 5));

        //System.out.println("Hour: " + hour + ", Minute: " + minunte);
        return " ";
    }
}
