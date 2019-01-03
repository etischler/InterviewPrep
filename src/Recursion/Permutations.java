package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Permutations {

    public static void main(String[] args) {
        System.out.println(permute(new ArrayList<>(Arrays.asList(1,2,3))));
    }

    static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if(A == null || A.size() == 0) return result;

        ArrayList<Integer> current = new ArrayList<Integer>();
        Collections.sort(A);

        util(A, 0, current, result);

        return result;

    }

    private static void util(ArrayList<Integer> candidates, int start, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
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
