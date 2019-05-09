package Trees;

public class MinDepthOfBinaryTree {

    public static void main(String[] args) {

    }

    static int solution(TreeNode A) {
        if(A == null)
            return Integer.MAX_VALUE;
        if(A.left == null && A.right == null)
            return 0;
        return Math.min(solution(A.left), solution(A.right)) + 1;

    }
}
