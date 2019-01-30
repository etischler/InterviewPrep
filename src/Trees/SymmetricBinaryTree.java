package Trees;

public class SymmetricBinaryTree {

    public static void main(String[] args) {

    }

    public static int isSymmetric(TreeNode A) {
        return util(A.left, A.right);
    }

    static int util(TreeNode A, TreeNode B) {

        if(A==null && B==null)
            return 1;


        if(A!=null && B!=null)
        {

            return (A.val == B.val && util(A.left, B.right) == 1 && util(A.right, B.left) == 1) ? 1 : 0;
        }

        return 0;

    }
}
