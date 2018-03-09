package Arrays;

import java.util.*;

public class RepeatAndMissingNumberArray {

    public static void main(String[] args) {

        List<Integer> A1 = Arrays.asList(3,1,2,5,3);
        System.out.println(repeatedNumber(A1));


    }

    /*
        set valueSet;
        int duplicate
        int missing
        for array
            if valueset contains A[i]
                duplicate = A[i]
            else
                valuset.add A[i]
        for array
            if !valuset contains A[i]
                missing = A[i]
        Arraylist ans = list.add(duplicate,missing);
     */
    static ArrayList<Integer> repeatedNumber(final List<Integer> A) {

        Set<Integer> valueSet = new HashSet<>();
        int duplicate = 0;
        int missing = 0;
        for(int a : A) {
            if(valueSet.contains(a))
                duplicate = a;
            else
                valueSet.add(a);
        }
        for(int i = 1; i < A.size()+1; i++) {
            if(!valueSet.contains(i))
                missing = i;
        }
        return new ArrayList<>(Arrays.asList(duplicate,missing));
    }
}
