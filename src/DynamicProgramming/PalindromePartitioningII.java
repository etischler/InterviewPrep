package DynamicProgramming;

import java.util.HashMap;

public class PalindromePartitioningII {

    public static void main(String[] args) {
        System.out.println(minCut("dVGAaVO25EmT6W3zSTEA0k12i64Kkmmli09Kb4fArlF4Gc2PknrlkevhROxUg"));
    }

    static int minCut(String A) {

        return memoMinCut(A, new HashMap<>());
    }

    private static int memoMinCut(String A, HashMap<String, Integer> memo) {
        if(memo.containsKey(A))
            return memo.get(A);
        StringBuilder a = new StringBuilder(A);
        if(a.reverse().toString().equals(A))
            return 0;

        int min = Integer.MAX_VALUE;
        for(int i = 1; i < A.length(); i++){
            int candidate = memoMinCut(a.substring(0, i), memo) + memoMinCut(a.substring(i, A.length()), memo);
            if(candidate < min)
                min = candidate;
        }
        memo.put(A, 1 + min);
        return memo.get(A);
    }

    private static int bottomUpMinCut(String A){
        int n = A.length();

        int[][] C = new int[n][n];
        boolean[][] P = new boolean[n][n];

        int i, j, k, L; // different looping variables

        for (i = 0; i < n; i++) {
            P[i][i] = true;
            C[i][i] = 0;
        }

        for (L = 2; L <= n; L++) {

            for (i = 0; i < n - L + 1; i++) {
                j = i + L - 1; // Set ending index


                if (L == 2)
                    P[i][j] = (A.charAt(i) == A.charAt(j));
                else
                    P[i][j] = (A.charAt(i) == A.charAt(j)) && P[i + 1][j - 1];

                // IF str[i..j] is palindrome, then
                // C[i][j] is 0
                if (P[i][j] == true)
                    C[i][j] = 0;
                else {

                    C[i][j] = Integer.MAX_VALUE;
                    for (k = i; k <= j - 1; k++)
                        C[i][j] = Integer.min(C[i][j],
                                C[i][k] + C[k + 1][j] + 1);
                }
            }
        }

        // Return the min cut value for complete
        // string. i.e., str[0..n-1]
        return C[0][n - 1];
    }
}
