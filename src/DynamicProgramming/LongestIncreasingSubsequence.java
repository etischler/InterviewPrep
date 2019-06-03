package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        System.out.println(lis(new ArrayList<>(Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15))));//6
        System.out.println(lis(new ArrayList<>(Arrays.asList(14, 24, 18, 46, 55, 53, 82, 18, 101, 20, 78, 35, 68, 9, 16, 93, 101, 85, 81, 28, 78)))); //7
    }

    static int lis(final List<Integer> A) {
        int[] lis = new int[A.size()];
        Arrays.fill(lis, 1);
        for(int i = 1; i < A.size(); i++){
            for(int j = 0; j < i; j++){
                if(A.get(i) - A.get(j) > 0)
                    lis[i] = Math.max(lis[i], lis[j] + 1);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < A.size(); i++){
            if(lis[i] > max)
                max = lis[i];
        }

        return max;
    }
}
