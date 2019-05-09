package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromInorderAndPreOrder {

    public static void main(String[] args) {
        preOrder(buildTree(new ArrayList(Arrays.asList(1, 2, 3 )), new ArrayList(Arrays.asList(2, 1, 3))));
        //preOrder(buildTree(new ArrayList(Arrays.asList(1, 2, 3, 4, 5)), new ArrayList(Arrays.asList(3, 2, 4, 1, 5))));
    }

    static TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {

        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for(int i = 0; i < A.size(); i++){
            valueIndexMap.put(A.get(i), i);
        }

        return buildTree(A, B, 0, B.size() - 1, new Index(0), valueIndexMap);

    }

    private static TreeNode buildTree(ArrayList<Integer> preOrder, ArrayList<Integer> inOrder, int iStart, int iEnd, Index index, Map<Integer, Integer> valueIndexMap) {
        if (iStart > iEnd)
            return null;

        /* Pick current node from Preorder traversal using preIndex
           and increment preIndex */
        TreeNode tNode = new TreeNode(preOrder.get(index.val++));

        /* If this node has no children then return */
        if (iStart == iEnd)
            return tNode;

        /* Else find the index of this node in Inorder traversal */
        int inIndex = valueIndexMap.get(preOrder.get(tNode.val));

        /* Using index in Inorder traversal, construct left and
           right subtress */
        tNode.left = buildTree(preOrder, inOrder, iStart,inIndex - 1, index, valueIndexMap );
        tNode.right = buildTree(preOrder, inOrder, inIndex + 1, iEnd, index, valueIndexMap);

        return tNode;
    }

    private static int findInorderIndexForRoot(ArrayList<Integer> inOrder, int postIndexVal) {
        for(int i = 0; i < inOrder.size(); i++){
            if(postIndexVal == inOrder.get(i))
                return i;
        }
        return -1;
    }

    static void preOrder(TreeNode node)
    {
        if (node == null)
            return;
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }


}

