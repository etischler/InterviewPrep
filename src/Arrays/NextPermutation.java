package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {

    public static void main(String[] args) {

        ArrayList<Integer> A1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        nextPermutation(A1);
        System.out.println(A1);

        ArrayList<Integer> A2 = new ArrayList<>(Arrays.asList(3, 2, 1));
        nextPermutation(A2);
        System.out.println(A2);

        ArrayList<Integer> A3 = new ArrayList<>(Arrays.asList(1, 1, 5));
        nextPermutation(A3);
        System.out.println(A3);

        ArrayList<Integer> A4 = new ArrayList<>(Arrays.asList(20, 50, 113));
        nextPermutation(A4);
        System.out.println(A4);

        ArrayList<Integer> A5 = new ArrayList<>(Arrays.asList());
        nextPermutation(A5);
        System.out.println(A5);

        ArrayList<Integer> A6 = new ArrayList<>(Arrays.asList(1));
        nextPermutation(A6);
        System.out.println(A6);

        ArrayList<Integer> A7 = new ArrayList<>(Arrays.asList(20, 113, 50, 25, 5));
        nextPermutation(A7);
        System.out.println(A7);

    }

    static void nextPermutation(ArrayList<Integer> a) {
        //findSuffix
        int rightIndex = Integer.MIN_VALUE;
        int leftIndex = Integer.MIN_VALUE;
        for(int i = a.size() - 1; i > 0; i--) {
            if(a.get(i - 1) > a.get(i)) {
                if(rightIndex == Integer.MIN_VALUE)
                    rightIndex = i;
                leftIndex = i - 1;
            }
            else if(a.get(i - 1) < a.get(i) && leftIndex != Integer.MIN_VALUE)
                break;
            else if (a.get(i - 1) < a.get(i)) {
                int temp = a.get(i - 1);
                a.set(i - 1, a.get(i));
                a.set(i, temp);
                return;
            }
        }
        //fail fast
        if(leftIndex == Integer.MIN_VALUE)
            return;

        //do swap
        else {
            if(leftIndex == 0) {
                Collections.reverse(a);
                return;
            }
            int toBeat = a.get(leftIndex - 1);
            for(int i = rightIndex; i >= leftIndex; i--) {
                if(a.get(i) > toBeat) {
                    int temp = a.get(leftIndex - 1);
                    a.set(leftIndex - 1, a.get(i));
                    a.set(i, temp);
                    break;
                }
            }
        }

        //reverse suffix
        while(leftIndex < rightIndex) {
            int temp = a.get(leftIndex);
            a.set(leftIndex, a.get(rightIndex));
            a.set(rightIndex, temp);
            leftIndex++;
            rightIndex--;
        }
    }
}
