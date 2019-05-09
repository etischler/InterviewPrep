package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortedArrayToBalancedBST {

    public static void main(String[] args) {
        sortedArrayToBST(new ArrayList<>(Arrays.asList(1, 4, 8)));
    }

    static TreeNode sortedArrayToBST(final List<Integer> a) {
        int[] arr = new int[a.size()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = a.get(i);
        }
        return sortedArrayToBST(arr, 0, a.size()-1);

    }

    private static TreeNode sortedArrayToBST(int arr[], int start, int end) {
        /* Base Case */
        if (start > end) {
            return null;
        }

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);

        /* Recursively construct the left subtree and make it
         left child of root */
        node.left = sortedArrayToBST(arr, start, mid - 1);

        /* Recursively construct the right subtree and make it
         right child of root */
        node.right = sortedArrayToBST(arr, mid + 1, end);

        return node;
    }
}
