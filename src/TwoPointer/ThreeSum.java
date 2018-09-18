package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new ArrayList<>(Arrays.asList(-1,2,1,-4)), 1));
        System.out.println(threeSumClosest(new ArrayList<>(Arrays.asList( -5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9, 5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9, -2, 7, 0, -4, -3, 1, 6, -3)), -1));
        System.out.println(threeSumClosest(new ArrayList<>(Arrays.asList( 4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8)), -3));
        System.out.println(threeSumClosest(new ArrayList<>(Arrays.asList(5, -2, -1, -10, 10)), 5));
    }
//taken from internet, couldn't solve
    static int threeSumClosest(ArrayList<Integer> A, int B) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        Collections.sort(A);

        for(int i = 0; i < A.size(); i++){
            int j = i+1;
            int k = A.size()-1;
            while(j < k){
                int sum = A.get(i) + A.get(j) + A.get(k);
                int diff = Math.abs(sum - B);
                if(diff == 0)
                    return sum; // or b
                if(diff < min){
                    min = diff;
                    result = sum;
                }
                if(sum <= B)
                    j++;
                else
                    k--;
            }
        }
        return result;
    }
}
