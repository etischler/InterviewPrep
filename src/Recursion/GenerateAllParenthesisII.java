package Recursion;

import java.util.ArrayList;

public class GenerateAllParenthesisII {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    static ArrayList<String> generateParenthesis(int A) {

        ArrayList<String> ans = new ArrayList<>();

        generateParenthesis(ans, new char[A*2], 0, 0, 0, A);
        return ans;
    }

    private static void generateParenthesis(ArrayList<String> ans, char[] curr, int pos, int open, int close, int n) {
        if(n == close) {
            StringBuilder builder = new StringBuilder();
            for(char c : curr)
                builder.append(c);
            ans.add(builder.toString());
        }
        if(open < n){
            curr[pos] ='(';
            generateParenthesis(ans, curr, pos+1, open+1, close, n);
        }
        if(open  > close){
            curr[pos] = ')';
            generateParenthesis(ans, curr, pos+1, open, close + 1, n);
        }
    }
}
