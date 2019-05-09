package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromInorderAndPostOrder {

    public static void main(String[] args) {
        preOrder(buildTree(new ArrayList(Arrays.asList(2,1,3)), new ArrayList(Arrays.asList(2,3,1))));
    }

    static TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {

        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for(int i = 0; i < A.size(); i++){
            valueIndexMap.put(A.get(i), i);
        }

        return buildTree(A, B, 0, B.size() - 1, new Index(B.size() -1), valueIndexMap);

    }

    private static TreeNode buildTree(ArrayList<Integer> inOrder, ArrayList<Integer> postOrder, int iStart, int iEnd, Index index, Map<Integer, Integer> valueIndexMap) {
        if(iStart > iEnd)
            return null;

        TreeNode node = new TreeNode(postOrder.get(index.val));

        index.val--;

        if(iStart == iEnd)
            return node;

        int inOrderIndex = valueIndexMap.get(postOrder.get(index.val + 1));


        node.right = buildTree(inOrder, postOrder, inOrderIndex + 1, iEnd, index, valueIndexMap);
        node.left = buildTree(inOrder, postOrder, iStart, inOrderIndex - 1, index, valueIndexMap);

        return node;
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

class Index {
    public Index(int val){
        this.val = val;
    }
   public int val;
}
