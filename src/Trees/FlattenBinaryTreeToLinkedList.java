package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {

    }

    public static TreeNode flatten(TreeNode a) {

        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = a;

        // traverse the tree
        while (curr != null || s.size() > 0)
        {

            /* Reach the left most TreeNode of the
            curr TreeNode */
            while (curr !=  null)
            {
                /* place pointer to a tree TreeNode on
                   the stack before traversing
                  the TreeNode's left subtree */
                s.push(curr);
                curr = curr.left;
            }

            /* Current must be NULL at this point */
            curr = s.pop();

            System.out.print(curr.val + " ");

            /* we have visited the TreeNode and its
               left subtree.  Now, it's right
               subtree's turn */
            curr = curr.right;
        }
        return a;
    }
}
