package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LengthOfLongestSubsequence {

    public static void main(String[] args) {
        System.out.println(longestSubsequenceLength(new ArrayList<>(Arrays.asList(1, 11, 2, 10, 4, 5, 2, 1))));
    }

    static int longestSubsequenceLength(final List<Integer> A) {
        int i, j;
        int n = A.size();
        int[] arr = A.stream().mapToInt(k->k).toArray();

        /* Allocate memory for LIS[] and initialize LIS values as 1 for
            all indexes */
        int[] lis = new int[n];
        for (i = 0; i < n; i++)
            lis[i] = 1;

        /* Compute LIS values from left to right */
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;

        /* Allocate memory for lds and initialize LDS values for
            all indexes */
        int[] lds = new int [n];
        for (i = 0; i < n; i++)
            lds[i] = 1;

        /* Compute LDS values from right to left */
        for (i = n-2; i >= 0; i--)
            for (j = n-1; j > i; j--)
                if (arr[i] > arr[j] && lds[i] < lds[j] + 1)
                    lds[i] = lds[j] + 1;


        /* Return the maximum value of lis[i] + lds[i] - 1*/
        int max = lis[0] + lds[0] - 1;
        for (i = 1; i < n; i++)
            if (lis[i] + lds[i] - 1 > max)
                max = lis[i] + lds[i] - 1;

        return max;

    }
}
