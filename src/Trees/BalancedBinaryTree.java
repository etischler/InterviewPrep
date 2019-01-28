package Trees;

public class BalancedBinaryTree {

    public static void main(String[] args) {

    }

    static int isBalanced(TreeNode A) {
        int lh; /* for height of left subtree */

        int rh; /* for height of right subtree */

        /* If tree is empty then return true */
        if (A == null)
            return 1;

        /* Get the height of left and right sub trees */
        lh = height(A.left);
        rh = height(A.right);

        if (Math.abs(lh - rh) <= 1
                && isBalanced(A.left) == 1
                && isBalanced(A.right) == 1)
            return 1;

        /* If we reach here then tree is not height-balanced */
        return 0;
    }

    /* UTILITY FUNCTIONS TO TEST isBalanced() FUNCTION */
    /*  The function Compute the "height" of a tree. Height is the
        number of nodes along the longest path from the root node
        down to the farthest leaf node.*/
    static int height(TreeNode node)
    {
        /* base case tree is empty */
        if (node == null)
            return 0;

        /* If tree is not empty then height = 1 + max of left
         height and right heights */
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
