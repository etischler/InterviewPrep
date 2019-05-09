package Trees;

import java.util.ArrayList;
import java.util.LinkedList;

public class RootToLeafPathsWithSum {

    public static void main(String[] args) {

    }

    static  ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {

        return util(A, B, 0, new ArrayList<>(), new ArrayList<>());
    }

    private static ArrayList<ArrayList<Integer>> util(TreeNode a, int b, int c, ArrayList<Integer> currNodes, ArrayList<ArrayList<Integer>> ans) {
        if(a == null)
            return null;
        if(a.left == null && a.right == null){
            if(a.val + c == b) {
                currNodes.add(a.val);
                ans.add(new ArrayList<>(currNodes));
            }
        }
        currNodes.add(a.val);
        ArrayList<Integer> tempNodes = new ArrayList<>(currNodes);
        util(a.left, b, a.val + c, currNodes, ans);
        util(a.right, b, a.val + c, tempNodes, ans);
        return ans;
    }
}
