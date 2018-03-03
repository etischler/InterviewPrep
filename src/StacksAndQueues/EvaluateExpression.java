package StacksAndQueues;

import java.util.ArrayList;
import java.util.Stack;

public class EvaluateExpression {

    public static void main(String[] args) {
        ArrayList<String> A = new ArrayList<>();
        A.add("2");
        A.add("1");
        A.add("+");
        A.add("3");
        A.add("*");
        System.out.println(evalRPN(A));

        A = new ArrayList<>();
        A.add("4");
        A.add("13");
        A.add("5");
        A.add("/");
        A.add("+");
        System.out.println(evalRPN(A));

        A = new ArrayList<>();
        A.add("5");
        System.out.println(evalRPN(A));

        A = new ArrayList<>();
        System.out.println(evalRPN(A));

        A = new ArrayList<>();
        A.add("-500");
        A.add("-10");
        A.add("/");
        System.out.println(evalRPN(A));
    }

    static int evalRPN(ArrayList<String> A) {
        if(A.size() == 1)
            return Integer.parseInt(A.get(0));
        Stack<Integer> nums = new Stack<>();
        for(String a : A) {
            try{
                int newNum = Integer.parseInt(a);
                nums.push(newNum);
            }catch(Exception e) {
                int right = nums.pop();
                int left = nums.pop();
                if(a.charAt(0) == '+')
                    nums.push(left + right);
                else if(a.charAt(0) == '-')
                    nums.push(left - right);
                else if(a.charAt(0) == '*')
                    nums.push(left * right);
                else if(a.charAt(0) == '/')
                    nums.push(left / right);
            }
        }
        return nums.size() == 0 ? 0 : nums.pop();
    }
}
