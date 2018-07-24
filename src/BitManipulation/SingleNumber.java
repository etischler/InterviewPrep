package BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingleNumber {

    public static void main(String[] args) {
        System.out.println(singleNumber(new ArrayList<>(Arrays.asList(1,2,2,3,1))));
    }

    static int singleNumber(final List<Integer> A) {

        int value = A.get(0);
        for(int i = 1; i < A.size(); i++) {
            value = value ^ A.get(i);
        }
        return value;
    }
}
