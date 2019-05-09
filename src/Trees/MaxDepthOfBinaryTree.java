package Trees;

public class MaxDepthOfBinaryTree {

    public static void main(String[] args) {

    }

    static int solution(TreeNode A) {
        if(A == null)
            return 0;
        return Math.max(solution(A.left), solution(A.right)) + 1;

    }
}
