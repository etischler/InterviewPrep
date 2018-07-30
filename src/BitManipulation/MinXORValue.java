package BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinXORValue {

    public static void main(String[] args) {
        System.out.println(findMinXor(new ArrayList<>(Arrays.asList(0,2,5,7))));
        System.out.println(findMinXor(new ArrayList<>(Arrays.asList(0,4,7,9))));
    }

    static int findMinXor(ArrayList<Integer> A) {
        Collections.sort(A);
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < A.size() - 1; i++) {
            ans = Math.min(ans, A.get(i) ^ A.get(i + 1));
        }

        return ans;
    }
}
