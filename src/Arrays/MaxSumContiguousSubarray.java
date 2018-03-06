package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumContiguousSubarray {

    public static void main(String[] args) {

        ArrayList<Integer> A1 = new ArrayList<>(Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4));
        System.out.println(maxSubArray(A1));

        ArrayList<Integer> A2 = new ArrayList<>(Arrays.asList(-163, -20));
        System.out.println(maxSubArray(A2));
    }

    static int maxSubArray(final List<Integer> A) {
        int ans = Integer.MIN_VALUE;
        int current = 0;
        for(int i = 0; i < A.size(); i++) {
            current += A.get(i);
            if(current >= ans) {
                ans = current;
            }
            if(current < 0)
                current = 0;
        }

        return ans;
    }
}
