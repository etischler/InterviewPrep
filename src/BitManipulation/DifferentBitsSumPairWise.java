package BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;

public class DifferentBitsSumPairWise {

    public static void main(String[] args) {
        System.out.println(cntBits(new ArrayList<>(Arrays.asList(1, 3, 5))));
    }

    static int cntBits(ArrayList<Integer> A) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < A.size(); j++)
                if ((A.get(j) & (1 << i)) == 0)
                    count++;
            ans += (count * (A.size() - count) * 2);
        }

        return ans;
    }
}
