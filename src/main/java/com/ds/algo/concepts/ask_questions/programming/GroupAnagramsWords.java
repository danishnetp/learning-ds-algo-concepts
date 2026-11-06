package com.ds.algo.concepts.ask_questions.programming;

import java.util.*;

public class GroupAnagramsWords {
    static Map<String, List<String>> makeAnagramGroups(String[] words) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String word : words) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);

            anagramGroups.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(word);
        }

        return anagramGroups;
    }
}
