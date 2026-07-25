package com.ds.algo.concepts.ask_questions.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Demonstrates how to count duplicate strings using Java 8 streams.
 *
 * <p>The result is a {@code Map<String, Long>} where:
 * <ul>
 *   <li>key = fruit name</li>
 *   <li>value = number of occurrences</li>
 * </ul>
 */
public class FindNumberDuplicateString {
    /**
     * Builds a frequency map from a sample fruit list and prints the result
     * using two approaches.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        // Approach 1: Collect once into a map, then iterate over entries.
        Map<String, Long> fruitsMap = fruits.stream()
                .collect(Collectors.groupingBy(fruit -> fruit, Collectors.counting()));

        for (Map.Entry<String, Long> fruit : fruitsMap.entrySet()) {
            System.out.println(fruit.getKey() + ": " + fruit.getValue());
        }

        System.out.println("Using forEach method:");
        // Approach 2: Inline collect and print using Map.forEach.
        fruits.stream()
                .collect(Collectors.groupingBy(fruit -> fruit, Collectors.counting()))
                .forEach((fruit, count) -> System.out.println(fruit + ": " + count));
    }
}
