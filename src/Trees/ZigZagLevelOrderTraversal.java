package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZigZagLevelOrderTraversal {

    public static void main(String[] args) {

    }

    static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        Stack<TreeNode> queue = new Stack<>();
        Stack<TreeNode> queueTwo = new Stack<>();

        queue.push(A);
        ArrayList<Integer> temp = new ArrayList<>();

        while (!queue.isEmpty() || !queueTwo.isEmpty()) {

            while (!queue.isEmpty()) {
                A = queue.pop();
                temp.add(A.val);
                if (A.left != null)
                    queueTwo.add(A.left);
                if (A.right != null)
                    queueTwo.add(A.right);
            }
            if (temp.size() > 0) {
                ans.add(temp);
                temp = new ArrayList<>();
            }
            while (!queueTwo.isEmpty()) {
                A = queueTwo.pop();
                temp.add(A.val);
                if (A.right != null)
                    queue.add(A.right);
                if (A.left != null)
                    queue.add(A.left);
            }
            if (temp.size() > 0) {
                ans.add(temp);
                temp = new ArrayList<>();
            }
        }

        return ans;
    }
}
