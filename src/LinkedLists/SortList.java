package LinkedLists;

import java.util.Stack;

public class SortList {

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("/a/./b/../../c"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/"));
        //System.out.println();
        System.out.println(simplifyPath("/home/"));
    }

    static String simplifyPath(String A) {
        String[] arr = A.split("/");
        Stack<String> stack = new Stack<>();

        for(String a : arr){
            switch (a){
                case ".":
                    break;
                case "..":
                    if(stack.size() > 0)
                        stack.pop();
                    break;
                case "":
                    break;
                default:
                    stack.push(a);
            }
        }
        StringBuilder ans = new StringBuilder();
        while(stack.size() > 0) {
           ans.insert(0,  "/" + stack.pop());
        }


        return ans.length() == 0 ? "/" : ans.toString();
    }
}
