package Trees;

import java.util.ArrayList;
import java.util.Arrays;

public class InOrderTraversalOfCartesianTree {

    public static void main(String[] args) {
        printInorder(buildTree(new ArrayList<>(Arrays.asList(2, 1, 3))));
    }
    //[ 2, 1, 3 ]

    static TreeNode buildTree(ArrayList<Integer> A) {


        return recurseTree(A, 0, A.size()-1, null);



    }

    private static TreeNode recurseTree(ArrayList<Integer> A, int start, int end, TreeNode node) {
        if(start > end)
            return null;

        int i = getIndexOfMax(A, start, end);
        node = new TreeNode(A.get(i));

        if(start==end)
            return node;

        node.left = recurseTree(A,start , i - 1, node.left);
        node.right = recurseTree(A, i+1, end, node.right);

        return node;
    }

    private static int getIndexOfMax(ArrayList<Integer> A, int start, int end) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for(int i = start; i <= end; i++){
            if(A.get(i) > max){
                max = A.get(i);
                index = i;
            }
        }
        return index;
    }

    static void printInorder(TreeNode node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.val + " ");

        /* now recur on right child */
        printInorder(node.right);
    }
}
