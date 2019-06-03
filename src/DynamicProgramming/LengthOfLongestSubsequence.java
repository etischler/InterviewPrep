package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LengthOfLongestSubsequence {

    public static void main(String[] args) {
        System.out.println(longestSubsequenceLength(new ArrayList<>(Arrays.asList(1, 11, 2, 10, 4, 5, 2, 1))));
        System.out.println(longestSubsequenceLength(new ArrayList<>(Arrays.asList(12, 11, 40, 5, 3, 1))));
    }

    static int longestSubsequenceLength(final List<Integer> A) {

        if(A.size() == 0)
            return 0;
        int[] LIS = new int[A.size()];
        int[] LDS = new int[A.size()];
        Arrays.fill(LIS, 1);
        Arrays.fill(LDS, 1);


        for(int i = 0; i < A.size(); i++){
            for(int j = 0; j < i; j++){
                if(A.get(i) > A.get(j) && LIS[i] < LIS[j] + 1)
                    LIS[i] = LIS[j] + 1;
            }
        }

        for(int i = A.size() - 1; i > -1 ; i--){
            for(int j = A.size() - 1; j > i; j--){
                if(A.get(i) > A.get(j) && LDS[i] < LDS[j] + 1)
                    LDS[i] = LDS[j] + 1;
            }
        }


        int max = Integer.MIN_VALUE;
        for(int i = 0; i < A.size(); i++){
            int currMax = LDS[i] + LIS[i] - 1;
            if(currMax > max)
                max = currMax;
        }

        return max;


    }
}
