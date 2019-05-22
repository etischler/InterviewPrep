package DynamicProgramming;

import java.util.ArrayList;

public class MinSumPathInMatrix {

    public static void main(String[] args) {

    }

    static int minPathSum(ArrayList<ArrayList<Integer>> A) {
        int[][] totalCost = new int[A.size()][A.get(0).size()];

        totalCost[0][0] = A.get(0).get(0);
        for (int i = 1; i < A.size(); i++)
            totalCost[i][0] = totalCost[i-1][0] + A.get(i).get(0);
        for (int j = 1; j < A.get(0).size(); j++)
            totalCost[0][j] = totalCost[0][j-1] + A.get(0).get(j);

        for (int i = 1; i < A.size(); i++)
            for (int j = 1; j < A.get(0).size(); j++)
                totalCost[i][j] = Math.min(totalCost[i - 1][j], totalCost[i][j - 1]) + A.get(i).get(j);

        return totalCost[A.size() - 1][A.get(0).size() - 1];
    }
}
