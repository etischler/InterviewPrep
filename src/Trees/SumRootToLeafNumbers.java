package Trees;

import java.math.BigInteger;
import java.util.ArrayList;

public class SumRootToLeafNumbers {

    public static void main(String[] args) {

    }

    static int sumNumbers(TreeNode A) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();

        util(A, paths, new ArrayList<>());
        return (int) sum(paths);
    }

    private static long sum(ArrayList<ArrayList<Integer>> paths) {
        BigInteger ten = BigInteger.valueOf(10);
        BigInteger sum = BigInteger.ZERO;
        for(ArrayList<Integer> numberList : paths){
            BigInteger tempNumber = BigInteger.ZERO;
            for(Integer number : numberList){
                tempNumber = (tempNumber.multiply(ten)).add(BigInteger.valueOf(number));
            }
            sum = sum.add(tempNumber);
            System.out.println("SUM: " + sum);
        }
        return sum.mod(BigInteger.valueOf(1003L)).intValue();
    }

    private static void util(TreeNode a, ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> curr) {
        if(a == null)
            return;
        if(a.left == null && a.right == null){
            curr.add(a.val);
            paths.add(new ArrayList<>(curr));
            return;
        }
        curr.add(a.val);
        ArrayList<Integer> tempCurr = new ArrayList<>(curr);
        util(a.left, paths, curr);
        util(a.right, paths, tempCurr);
    }


}
