package Trees;

import java.util.Iterator;
import java.util.TreeSet;

public class KthSmallestElementInTree {

    public static void main(String[] args) {
        kthsmallest(null, 1);
    }

    static int kthsmallest(TreeNode A, int B) {

        TreeSet<Integer> set = new TreeSet<>();

        traverseTree(A, B, set);

        return set.last();
    }

    private static void traverseTree(TreeNode a, int b, TreeSet<Integer> set) {
        if(a == null)
            return;
        set.add(a.val);
        if(set.size() > b)
            set.remove(set.last());

        traverseTree(a.left, b, set);
        traverseTree(a.right, b, set);
    }
}
