package com.ds.algo.concepts.ask_questions.java8;

import java.util.List;
import java.util.Optional;

public class ProgramOutputDemo1 {
    public static void main(String[] args){
        List<String> names = List.of("Bob", "Alice", "Anna", "Charlie");

        Optional<String> result = names.stream()
                .peek(n  -> System.out.println("before filter: " + n))
                .filter(n -> n.startsWith("A"))
                .peek(n  -> System.out.println("after  filter: " + n))
                .findFirst();

        System.out.println("result: " + result.orElse("not found"));}
}