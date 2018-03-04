package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AddOneToNumber {

    public static void main(String[] args) {

        ArrayList<Integer> A1 =  new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(plusOne(A1));

        ArrayList<Integer> A2 = new ArrayList<>(Arrays.asList(0, 0, 1, 9, 9));
        System.out.println(plusOne(A2));

        ArrayList<Integer> A3 = new ArrayList<>(Arrays.asList(0));
        System.out.println(plusOne(A3));

        ArrayList<Integer> A4 = new ArrayList<>(Arrays.asList(9));
        System.out.println(plusOne(A4));

        ArrayList<Integer> A5 = new ArrayList<>();
        System.out.println(plusOne(A5));
    }

    static ArrayList<Integer> plusOne(ArrayList<Integer> A) {

        int firstNotZero = 0;
        for(int i = 0; i < A.size(); i++) {
            if(A.get(i) != 0) {
                firstNotZero = i;
                break;
            }
        }
        ArrayList<Integer> toReverse = new ArrayList<>();
        Boolean doneWithNines = false;
        for(int i = A.size() - 1; i >= firstNotZero; i--) {
            if(!doneWithNines) {
                if(A.get(i) == 9) {
                    toReverse.add(0);
                    if(i == firstNotZero)
                        toReverse.add(1);
                }
                else {
                    toReverse.add(A.get(i) + 1);
                    doneWithNines = true;
                }
            }
            else
                toReverse.add(A.get(i));
        }
        Collections.reverse(toReverse);


        return toReverse;
    }
}
