package Trees;

import java.util.Stack;
import java.util.TreeSet;

public class BSTIterator {

    Stack<TreeNode> path = new Stack<>();
    TreeNode root;
    public static void main(String[] args) {

    }

    public boolean hasNext() {
        return !path.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode temp = path.pop();
        pushAll(temp.left);
        return temp.val;
    }

    void pushAll(TreeNode node){
        while(node!=null){
            path.push(node);
            node = node.right;
        }
    }
}
