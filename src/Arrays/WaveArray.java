package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WaveArray {

    public static void main(String[] args) {
        ArrayList<Integer> A1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        System.out.println(wave(A1));

        System.out.println(wave(new ArrayList<>()));
    }

    /*
        sort the array
        for the array
            if less than next
                swap
            i++
            if greater than next
                swap
     */

    static ArrayList<Integer> wave(ArrayList<Integer> A) {
        Collections.sort(A);
        for(int i = 0; i < A.size(); i++) {
            if(i + 1 < A.size() && A.get(i) < A.get(i + 1)) {
                int temp = A.get(i);
                A.set(i, A.get(i + 1));
                A.set(i + 1, temp);
            }
            i++;
            if(i + 1 < A.size() && A.get(i) > A.get(i + 1)) {
                int temp = A.get(i);
                A.set(i, A.get(i + 1));
                A.set(i + 1, temp);
            }
        }
        return A;
    }
}
