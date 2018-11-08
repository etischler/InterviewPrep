package StacksAndQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleinHistrogram {

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new ArrayList<>(Arrays.asList(6, 2, 5, 4, 5, 1, 6))));
    }

    static int largestRectangleArea(ArrayList<Integer> A) {

        // Create an empty stack. The stack holds indexes of hist[] array
        // The bars stored in stack are always in increasing order of their
        // heights.
        Stack<Integer> s = new Stack<>();

        int max_area = 0; // Initialize max area
        int tp;  // To store top of stack
        int area_with_top; // To store area with top bar as the smallest bar

        // Run through all bars of given histogram
        int i = 0;
        while (i < A.size())
        {
            // If this bar is higher than the bar on top stack, push it to stack
            if (s.empty() || A.get(s.peek()) <= A.get(i))
                s.push(i++);

                // If this bar is lower than top of stack, then calculate area of rectangle
                // with stack top as the smallest (or minimum height) bar. 'i' is
                // 'right index' for the top and element before top in stack is 'left index'
            else
            {
                tp = s.peek();  // store the top index
                s.pop();  // pop the top

                // Calculate the area with hist[tp] stack as smallest bar
                area_with_top = A.get(tp) * (s.empty() ? i : i - s.peek() - 1);

                // update max area, if needed
                if (max_area < area_with_top)
                    max_area = area_with_top;
            }
        }

        // Now pop the remaining bars from stack and calculate area with every
        // popped bar as the smallest bar
        while (!s.empty())
        {
            tp = s.peek();
            s.pop();
            area_with_top = A.get(tp) * (s.empty() ? i : i - s.peek() - 1);

            if (max_area < area_with_top)
                max_area = area_with_top;
        }

        return max_area;
    }
}
