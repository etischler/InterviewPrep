package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class MinSumPathInTriangle {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        a.add(new ArrayList<>(Arrays.asList(2)));
        a.add(new ArrayList<>(Arrays.asList(6,6)));
        a.add(new ArrayList<>(Arrays.asList(7,8,4)));
        System.out.println(minimumTotalIterative(a));
    }

    static int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        int[][] memo = new int[a.size()][a.get(a.size() - 1).size()];
        return util(a, 0, 0, memo);
    }

    private static int util(ArrayList<ArrayList<Integer>> a, int i, int j, int[][] memo) {
        if(j > a.get(i).size() - 1 || j < 0)
            return Integer.MAX_VALUE;
        if(i == a.size() - 1)
            return a.get(i).get(j);
        if(memo[i][j] > 0)
            return memo[i][j];

        int valAtNode = a.get(i).get(j);
        memo[i][j] = valAtNode + Math.min(util(a, i + 1, j, memo), util(a, i + 1, j + 1, memo));
        return memo[i][j];
    }

    private static int minimumTotalIterative(ArrayList<ArrayList<Integer>> a) {
        int[][] stepInfo = new int[a.size()][a.get(a.size() -1).size()];
        for(int[] b : stepInfo)
            Arrays.fill(b, Integer.MAX_VALUE);
        stepInfo[0][0] = a.get(0).get(0);
        for(int i = 1; i < a.size(); i++){
            for(int j = 0; j < a.get(i).size(); j++){
                int currVal = a.get(i).get(j);
                stepInfo[i][j] = Math.min(validateAndGetVal(a, currVal, i - 1, j - 1, stepInfo), validateAndGetVal(a, currVal, i - 1, j, stepInfo));
            }
        }
        int minVal = Integer.MAX_VALUE;
        int lastRow = a.size() - 1;
        for(int j = 0; j < stepInfo[0].length; j++){
            if(stepInfo[lastRow][j] < minVal)
                minVal = stepInfo[lastRow][j];
        }
        return minVal;
    }

    private static int validateAndGetVal(ArrayList<ArrayList<Integer>> a, int currVal, int i, int j, int[][] stepInfo){
        if(j < 0 || j >= stepInfo[0].length || stepInfo[i][j] == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else return currVal + stepInfo[i][j];
    }
}
