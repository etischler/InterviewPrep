package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class SpiralOrderMatrixII {

    public static void main(String[] args) {
        System.out.println(generateMatrix(10));
        System.out.println(generateMatrix(0));
    }
    
    static ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        if(A == 0) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>());
            return ans;
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < A; i++)
            ans.add(new ArrayList<>(Arrays.asList(new Integer[A])));
        ans.get(0).set(0 , 1);
        int n = A;
        int currVal = 2;
        int currX = 0;
        int currY = 0;
        Boolean actionTaken = true;
        while(actionTaken) {
            actionTaken = false;
            while(currY + 1 <= n - 1 && ans.get(currX).get(currY + 1) == null) {
                ans.get(currX).set(currY + 1, currVal);
                currY++;
                currVal++;
                actionTaken = true;
            }

            while(currX - 1 >=0 && ans.get(currX - 1).get(currY) == null) {
                ans.get(currX - 1).set(currY, currVal);
                currX--;
                currVal++;
                actionTaken = true;
            }

            while(currY - 1 >= 0 && ans.get(currX).get(currY - 1) == null) {
                ans.get(currX).set(currY - 1, currVal);
                currY--;
                currVal++;
                actionTaken = true;
            }

            while(currX + 1 <= n - 1 && ans.get(currX + 1).get(currY) == null) {
                ans.get(currX + 1).set(currY, currVal);
                currX++;
                currVal++;
                actionTaken = true;
            }
        }

        return ans;
    }
}
