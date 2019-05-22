package Greedy;

import java.util.ArrayList;
import java.util.Collections;


public class AssignMiceToHoles {

    public static void main(String[] args) {
        ;
    }

    static int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
        Collections.sort(A);
        Collections.sort(B);
        int maxDiff = Integer.MIN_VALUE;
        for(int i = 0; i < A.size(); i++){
            int a = A.get(i);
            int b = B.get(i);
            int diff = Math.abs(a - b);
            if(diff > maxDiff)
                maxDiff = diff;
        }
        return maxDiff;
    }
}