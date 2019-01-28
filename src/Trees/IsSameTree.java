package Trees;

import java.util.ArrayList;
import java.util.Stack;

public class IsSameTree {

    public static void main(String[] args) {

    }

    static int isSameTree(TreeNode A, TreeNode B) {

        if(A==null && B==null)
            return 1;


        if(A!=null && B!=null)
        {

            return (A.val == B.val && isSameTree(A.left, B.left) == 1 && isSameTree(A.right, B.right) == 1) ? 1 : 0;
        }

        return 0;

    }

}
