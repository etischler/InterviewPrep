package Trees;

import java.util.ArrayList;
import java.util.Stack;

public class InOrderTraversal {

    public static void main(String[] args) {

    }

    static ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(A == null)
            return ans;

        Stack<TreeNode> s = new Stack<>();

        while(!s.isEmpty() || A != null) {
            while (A != null) {
                s.push(A);
                A = A.left;
            }
            A = s.pop();
            ans.add(A.val);
            A = A.right;
        }

        return ans;

    }
}
