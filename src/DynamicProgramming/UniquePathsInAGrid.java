package DynamicProgramming;

import java.util.ArrayList;

public class UniquePathsInAGrid {

    public static void main(String[] args) {

    }

    static int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        return util(A, 0, 0);
    }

    private static int util(ArrayList<ArrayList<Integer>> A, int i, int j) {
        if(i > A.size() - 1 || j > A.get(A.size() - 1).size() - 1 )
            return 0;
        if(A.get(i).get(j) == 1)
            return 0;
        if(i == A.size() - 1 && j == A.get(A.size() - 1).size())
            return 1;
        return util(A, i + 1, j) + util(A, i, j + 1);
    }
}
