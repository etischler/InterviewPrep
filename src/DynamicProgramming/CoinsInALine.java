package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class CoinsInALine {

    public static void main(String[] args) {
        System.out.println(maxcoin(new ArrayList<>(Arrays.asList(1,2,3,4))));
        System.out.println(maxcoin(new ArrayList<>(Arrays.asList(1, 100, 500, 10))));
    }

    static int maxcoin(ArrayList<Integer> A) { //copied
        int n = A.size();
        int table[][] = new int[n][n];
        int gap, i, j, x, y, z;

        // Fill table using above recursive formula.
        // Note that the tableis filled in diagonal
        // fashion (similar to http:// goo.gl/PQqoS),
        // from diagonal elements to table[0][n-1]
        // which is the result.
        for (gap = 0; gap < n; ++gap) {
            for (i = 0, j = gap; j < n; ++i, ++j) {

                // Here x is value of F(i+2, j),
                // y is F(i+1, j-1) and z is
                // F(i, j-2) in above recursive formula
                x = ((i + 2) <= j) ? table[i + 2][j] : 0;
                y = ((i + 1) <= (j - 1)) ? table[i + 1][j - 1] : 0;
                z = (i <= (j - 2)) ? table[i][j - 2] : 0;

                table[i][j] = Math.max(A.get(i) + Math.min(x, y),
                        A.get(j) + Math.min(y, z));
            }
        }

        return table[0][n - 1];
    }
}
