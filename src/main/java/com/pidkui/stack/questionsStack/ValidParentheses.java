package com.pidkui.stack.questionsStack;

import java.util.Stack;

public class ValidParentheses {

    private static boolean checkParentheses(String str) {
        if (str.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char top = stack.peek();
                    if ((c == ')' && top == '(') ||
                            (c == '}' && top == '{') ||
                            (c == ']' && top == '[')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "{{}()[](({}))}";
        System.out.println("Is parentheses valid: " + checkParentheses(str));
    }
}
