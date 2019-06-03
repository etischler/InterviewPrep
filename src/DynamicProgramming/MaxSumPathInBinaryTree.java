package DynamicProgramming;

import java.util.ArrayList;

public class MaxSumPathInBinaryTree {
    public static void main(String[] args) {

    }

    static int maxPathSum(TreeNode A) {
        if(A == null)
            return 0;
        int val = A.val;
        if(val > 0) {
            int valToGoLeftWithoutNode = maxPathSum(A.left);
            int valToGoLeftWithNode = valToGoLeftWithoutNode + A.val;
            int valToGoRightWithoutNode = maxPathSum(A.right);
            int valToGoRightWithNode = valToGoRightWithoutNode + A.val;


            return Math.max(valToGoLeftWithNode + valToGoRightWithoutNode, Math.max(A.val, Math.max(Math.max(valToGoLeftWithoutNode, valToGoLeftWithNode), Math.max(valToGoRightWithoutNode, valToGoRightWithNode))));
        }
        else{
            int valLeft = maxPathSum(A.left) + val;
            int valRight = maxPathSum(A.right) + val;
            return Math.max(valRight, Math.max(val, valLeft));
        }
    }


}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
  }
