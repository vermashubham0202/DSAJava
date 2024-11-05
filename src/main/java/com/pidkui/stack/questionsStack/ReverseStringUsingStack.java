package com.pidkui.stack.questionsStack;

import java.util.Stack;

public class ReverseStringUsingStack {

    private static String reverseString(String input) {
        // from java.util library
        Stack<Character> stack = new Stack<>();

        char[] chars = input.toCharArray();

        for (char c : chars) {
            stack.push(c);
        }

        for (int i = 0; i < input.length(); i++) {
            chars[i] = stack.pop();
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String input = "Shubham";
        System.out.println(reverseString(input));
    }
}
