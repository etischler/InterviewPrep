package Trees;

public class PathSum {

    public static void main(String[] args) {

    }

    static int hasPathSum(TreeNode A, int B) {

        return util(A, B, 0) ? 1 : 0;
    }

    private static boolean util(TreeNode a, int b, int c) {
        if(a == null)
            return false;
        if(a.left == null && a.right == null)
            return a.val + c == b;

        return util(a.left, b, a.val + c) || util(a.right, b, a.val + c);

    }


}
