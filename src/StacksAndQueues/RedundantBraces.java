package StacksAndQueues;

import java.util.Stack;

public class RedundantBraces {

    public static void main(String[] args) {

    }

    static int braces(String A) {

        Stack<Character> stack = new Stack<>();

        boolean isOperatorFound = false;
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);

            if (c != ')')
                stack.push(c);
            else {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    if (stack.peek() == '+' || stack.peek() == '-' || stack.peek() == '*' || stack.peek() == '/')
                        isOperatorFound = true;
                    stack.pop();
                }

                stack.pop();
                if (!isOperatorFound || (!stack.isEmpty() && stack.peek() == '(')) {
                    return 1;
                }

            }
        }

        System.out.println("No");

        return 0;
    }
}
