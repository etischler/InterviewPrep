package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicateInArray {

    public static void main(String[] args) {

        List<Integer> A1 = Arrays.asList(3,4,1,4,1);
        System.out.println(repeatedNumber(A1));

    }

    static int repeatedNumber(final List<Integer> a) {

        Set<Integer> theSet = new HashSet<>();

        for(Integer theInt : a) {
            if(theSet.contains(theInt))
                return theInt;
            else
                theSet.add(theInt);
        }
        return -1;
    }
}
