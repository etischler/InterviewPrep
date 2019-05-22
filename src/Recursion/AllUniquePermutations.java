package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AllUniquePermutations {

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        Set<ArrayList<Integer>> result = new HashSet<>();

        if(A == null || A.size() == 0) return new ArrayList<>();

        ArrayList<Integer> current = new ArrayList<Integer>();
        Collections.sort(A);

        util(A, 0, current, result);

        return new ArrayList<>(result);

    }

    private static void util(ArrayList<Integer> candidates, int start, ArrayList<Integer> current, Set<ArrayList<Integer>> result) {
        if(candidates.size() == 0){
            result.add(new ArrayList<>(current));
        }
        ArrayList<Integer> candidatesCopy = new ArrayList<>(candidates);
        for(int i = 0; i < candidatesCopy.size(); i++){
            int temp = candidates.get(i);
            current.add(candidates.get(i));
            candidates.remove(i);
            util(candidates, 0, current, result);
            candidates.add(i, temp);
            current.remove(current.size() -1 );
        }
    }
}
