package com.ds.algo.concepts.ask_questions.programming;
/*
Q: Question:
Possible Move R, L, U, D

Compressed Input: U2(RULD)
Output: URURU
 */
public class CorrectMovement {
    public static void main(String[] args) {
        String input = "UUDDLRLR";
        //moveResult(input);
        moveOutput("U2(RU)3(D)");
    }

    static void moveOutput(String input) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)) {
                int count = Character.getNumericValue(ch);
                int startIndex = input.indexOf('(', i);
                int endIndex = input.indexOf(')', startIndex);
                String sub = input.substring(startIndex + 1, endIndex);
                for (int j = 0; j < count; j++) {
                    output.append(sub);
                }
                i = endIndex; // Move the index to the end of the processed substring
            } else if (ch != '(' && ch != ')') {
                output.append(ch);
            }
        }
        System.out.println("Final movement result : " + output);
    }

    static void moveResult(String input) {
        int x = 0, y = 0;
        for (char c : input.toCharArray()) {
            switch (c) {
                case 'U' -> y++;
                case 'D' -> y--;
                case 'L' -> x--;
                case 'R' -> x++;
            }
        }
        System.out.println("Final Position: (" + x + ", " + y + ")");

    }
}
