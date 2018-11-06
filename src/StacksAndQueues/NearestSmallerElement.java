package StacksAndQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElement {

    public static void main(String[] args) {

        System.out.println(prevSmaller(new ArrayList<>(Arrays.asList(4,5,2,10,8))));
        System.out.println(prevSmaller(new ArrayList<>(Arrays.asList(3,2,1))));
        System.out.println(prevSmaller(new ArrayList<>(Arrays.asList(34, 35, 27, 42, 5, 28, 39, 20, 28))));

    }

    static ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> min=new ArrayList<Integer>();
        for(int i=0;i<A.size();i++){
            min.add(-1);
        }
        for(int i=0;i<A.size();i++){
            while(!stack.isEmpty()&& stack.peek()>=A.get(i))
                stack.pop();
            if(!stack.isEmpty())
                min.set(i,stack.peek());
            stack.push(A.get(i));
        }
        return min;
    }
}
