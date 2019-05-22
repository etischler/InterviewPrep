package Greedy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class HighestProduct {

    public static void main(String[] args) {
        System.out.println(maxp3(new ArrayList<>(Arrays.asList(-1, -2, -3, -4, -5)))); //-6
        System.out.println(maxp3(new ArrayList<>(Arrays.asList(1, 3, 5, 2, 8, 0, -1, -3)))); //120

    }

    public static int maxp3(ArrayList<Integer> A) {
        int[] maxArr = new int[3];
        Arrays.fill(maxArr, Integer.MIN_VALUE);
        int[] minNegArr = new int[2];
        Arrays.fill(minNegArr, Integer.MAX_VALUE);
        for(int i = 0; i < A.size(); i++){
            int currVal = A.get(i);
            if(currVal > maxArr[2]) {
                maxArr[0] = maxArr[1];
                maxArr[1] = maxArr[2];
                maxArr[2] = currVal;
            }
            else if (currVal > maxArr[1]) {
                maxArr[0] = maxArr[1];
                maxArr[1] = currVal;
            }
            else if(currVal > maxArr[0]) {
                maxArr[0] = currVal;
            }

            if(currVal < minNegArr[0]) {
                minNegArr[1] = minNegArr[0];
                minNegArr[0] = currVal;
            }
            else if(currVal < minNegArr[1])
                minNegArr[1] = currVal;
        }

        int maxOnlyAnswer = maxArr[2] * maxArr[1] * maxArr[0];

        int withMinAnswer = maxArr[2] * minNegArr[1] * minNegArr[0];

        return maxOnlyAnswer > withMinAnswer ? maxOnlyAnswer : withMinAnswer;
    }

}
