package Trees;

public class InvertTheBinaryTree {

    public static void main(String[] args) {

    }

    static TreeNode invertTree(TreeNode A) {
        if(A==null)
            return null;

        TreeNode tempLeft = A.left;
        A.left = A.right;
        A.right = tempLeft;

        invertTree(A.left);
        invertTree(A.right);
        return A;
    }
}
