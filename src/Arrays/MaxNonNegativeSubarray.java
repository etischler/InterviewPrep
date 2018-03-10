package Arrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class MaxNonNegativeSubarray {

    public static void main(String[] args) {
        ArrayList<Integer> A1 = new ArrayList<>(Arrays.asList(1, 2, 5, -7, 2, 3));
        System.out.println(maxset(A1));

        System.out.println(maxset(new ArrayList<>(Arrays.asList(756898537, -1973594324, -2038664370, -184803526, 1424268980 ))));

        System.out.println(maxset(new ArrayList<>()));

        System.out.println(maxset(new ArrayList<>(Arrays.asList(336465782, -278722862, -2145174067, 1101513929, 1315634022, -1369133069, 1059961393, 628175011, -1131176229, -859484421))));
    }
/*
    arraylist ans
    arraylist curr
    int currSum
    int maxsum;
    for the array
        if array[i] is not negative
            curr.add(a[i])
            currSum += a[i]
            if currSum > maxSum
                maxSum = currSum
                ans = curr
            else if currsum == maxsum && curr.length > ans.length
                ans = curr;
        else
            curr = new arraylist
            currSum = 0
    return ans;
 */

    static ArrayList<Integer> maxset(ArrayList<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        BigInteger currSum = BigInteger.ZERO;
        BigInteger maxSum = BigInteger.ZERO;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) >= 0) {
                curr.add(A.get(i));
                currSum = currSum.add(BigInteger.valueOf(A.get(i)));
                if (currSum.compareTo(maxSum) == 1) {
                    maxSum = currSum;
                    ans = curr;
                } else if (currSum.equals(maxSum) && curr.size() > ans.size())
                    ans = curr;
            }
            else {
                curr = new ArrayList<>();
                currSum = BigInteger.ZERO;
            }
        }
        return ans;
    }
}
