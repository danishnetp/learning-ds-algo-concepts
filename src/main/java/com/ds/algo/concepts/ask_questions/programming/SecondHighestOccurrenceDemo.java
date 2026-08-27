package com.ds.algo.concepts.ask_questions.programming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SecondHighestOccurrenceDemo {
    public static void main(String[] args) {
        String str = "Hello World";

        findSecondHighestOccurrenceWithArray(str);
    }

    private static void findSecondHighestOccurrenceWithMap(String str) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        Set<Integer> uniqueFrequencies = new HashSet<>(frequencyMap.values());
        if (uniqueFrequencies.size() < 2) {
            System.out.println("No character has the second highest occurrence.");
            return;
        }

        Integer highest = null;
        Integer secondHighest = null;

        for (Integer freq : uniqueFrequencies) {
            if (highest == null || freq > highest) {
                secondHighest = highest;
                highest = freq;
            } else if ((secondHighest == null || freq > secondHighest) && freq < highest) {
                secondHighest = freq;
            }
        }

        System.out.println("Second highest occurrence count: " + secondHighest);
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue().equals(secondHighest)) {
                System.out.println("Character with second highest occurrence: " + entry.getKey());
            }
        }
    }

    private static void findSecondHighestOccurrenceWithArray(String str) {
        int[] freq = new int[256];
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }

        int highest = 0;
        int secondHighest = 0;

        for (int count : freq) {
            if (count > highest) {
                secondHighest = highest;
                highest = count;
            } else if (count > secondHighest && count < highest) {
                secondHighest = count;
            }
        }

        if (secondHighest > 0) {
            System.out.println("Second highest occurrence count: " + secondHighest);
            for (int i = 0; i < freq.length; i++) {
                if (freq[i] == secondHighest) {
                    System.out.println("Character with second highest occurrence: " + (char) i);
                }
            }
        } else {
            System.out.println("No character has the second highest occurrence.");
        }
    }
}
