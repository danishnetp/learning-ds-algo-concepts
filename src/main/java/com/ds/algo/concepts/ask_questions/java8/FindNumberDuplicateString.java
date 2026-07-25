package com.ds.algo.concepts.ask_questions.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindNumberDuplicateString {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Long> fruitsMap = fruits.stream()
                .collect(Collectors.groupingBy(fruit -> fruit, Collectors.counting()));

        for (Map.Entry<String, Long> fruit : fruitsMap.entrySet()) {
            System.out.println(fruit.getKey() + ": " + fruit.getValue());
        }

        System.out.println("Using forEach method:");
        fruits.stream()
                .collect(Collectors.groupingBy(fruit -> fruit, Collectors.counting()))
                .forEach((fruit, count) -> System.out.println(fruit + ": " + count));
    }
}
