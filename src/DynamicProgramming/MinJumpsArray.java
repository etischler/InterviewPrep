package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class MinJumpsArray {

    public static void main(String[] args) {
        System.out.println(jump(new ArrayList<>(Arrays.asList(2,3,1,1,4))));
        System.out.println(jump(new ArrayList<>(Arrays.asList(33, 21, 50, 0, 0, 46, 34, 3, 0, 12, 33, 0, 31, 37, 15, 17, 34, 18, 0, 4, 12, 41, 18, 35, 37, 34, 0, 47, 0, 39, 32, 49, 5, 41, 46, 26, 0, 2, 49, 35, 4, 19, 2, 27, 23, 49, 19, 38, 0, 33, 47, 1, 21, 36, 18, 33, 0, 1, 0, 39, 0, 22, 0, 9, 36, 45, 31, 4, 14, 48, 2, 33, 0, 39, 0, 37, 48, 44, 0, 11, 24, 16, 10, 23, 22, 41, 32, 14, 22, 16, 23, 38, 42, 16, 15, 0, 39, 23, 0, 42, 15, 25, 0, 41, 2, 48, 28))));
    }

    static int jump(ArrayList<Integer> A) {
        int n = A.size();
        int[] jumps = new int[n];
        int min;

        // Minimum number of jumps
        // needed to reach last
        // element from last elements
        // itself is always 0
        jumps[n - 1] = 0;


        // Start from the second
        // element, move from right
        // to left and construct the
        // jumps[] array where jumps[i]
        // represents minimum number of
        // jumps needed to reach arr[m-1]
        // from arr[i]
        for (int i = n - 2; i >= 0; i--)
        {
            // If arr[i] is 0 then arr[n-1]
            // can't be reached from here
            if (A.get(i) == 0)
                jumps[i] = Integer.MAX_VALUE;

                // If we can direcly reach to
                // the end point from here then
                // jumps[i] is 1
            else if (A.get(i) >= n - i - 1)
                jumps[i] = 1;

                // Otherwise, to find out
                // the minimum number of
                // jumps needed to reach
                // arr[n-1], check all the
                // points reachable from
                // here and jumps[] value
                // for those points
            else
            {
                // initialize min value
                min = Integer.MAX_VALUE;

                // following loop checks
                // with all reachable points
                // and takes the minimum
                for (int j = i + 1; j < n &&
                        j <= A.get(i) + i; j++)
                {
                    if (min > jumps[j])
                        min = jumps[j];
                }

                // Handle overflow
                if (min != Integer.MAX_VALUE)
                    jumps[i] = min + 1;
                else
                    jumps[i] = min; // or Integer.MAX_VALUE
            }
        }

        return jumps[0] == Integer.MAX_VALUE ? -1 : jumps[0];
    }
}
