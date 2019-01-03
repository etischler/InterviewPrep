package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SubSetsII {

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new ArrayList<>(Arrays.asList(1,2,2))));
        System.out.println(subsetsWithDup(new ArrayList<>(Arrays.asList(6, 6, 3, 3, 6, 5))));
    }

    static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(A);

        return utilMethod(new ArrayList<>(), A, result);
    }

    private static ArrayList<ArrayList<Integer>> utilMethod(ArrayList<Integer> curr, ArrayList<Integer> candidates, ArrayList<ArrayList<Integer>> result) {

        result.add(new ArrayList<>(curr));

        ArrayList<Integer> candidatesCopy = new ArrayList<>(candidates);
        for(int i = 0; i < candidates.size(); i++){
            curr.add(candidates.get(i));
            candidatesCopy.remove(0);
            utilMethod(curr, candidatesCopy, result);
            curr.remove(curr.size()-1);
            while(i + 1 < candidates.size() && candidates.get(i).equals(candidates.get(i+1))) {
                i++;
                candidatesCopy.remove(0);
            }
        }
        return result;
    }
}
