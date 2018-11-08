package StacksAndQueues;

import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

public class MinStack {

    static private Stack<Integer> stack = new Stack<>();

    static private int min = -1;

    public static void main(String[] args) {

    }

    static void push(int x) {
        if (stack.isEmpty() || x <= min) {
            // first element into stack or smaller element
            stack.push(min); // since min = -1 for empty stack, so current min os                         // -1
            min = x;
        }
        stack.push(x);
    }

    static void pop() {
        if (!stack.isEmpty() && min == stack.pop()) {
            // update min when popping the min element from stack
            min = stack.pop();
        }

    }

    static int top() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    static int getMin() {
        return min;
    }
}
