package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DiffK {

    public static void main(String[] args) {
        System.out.println(diffPossible(new ArrayList<>(Arrays.asList(1, 3, 5)), 4));
        System.out.println(diffPossible(new ArrayList<>(Arrays.asList(1, 5)), 4));

        System.out.println(diffPossible(new ArrayList<>(Arrays.asList(2, 14, 18, 23, 25, 36, 40, 44, 44, 53, 54, 68, 71, 80, 94)), 82));

        System.out.println(diffPossible(new ArrayList<>(Arrays.asList(1, 13, 27, 32, 41, 42, 45, 50, 54, 60, 68, 83, 89, 91)), 7));
    }

    static int diffPossible(ArrayList<Integer> A, int B) {
        Set set = new HashSet<>();

        for(int i = 0; i < A.size(); i++) {
            if(set.contains(A.get(i) - B))
                return 1;

            set.add(A.get(i));
        }

        return 0;
    }
}
