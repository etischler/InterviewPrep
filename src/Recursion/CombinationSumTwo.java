package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CombinationSumTwo {

    public static void main(String[] args) {
        System.out.println(combinationSum(new ArrayList<>(Arrays.asList(2,3,6,7)), 7));
        System.out.println(combinationSum(new ArrayList<>(Arrays.asList(15, 8, 15, 10, 19, 18, 10, 3, 11, 7, 17)), 33));
    }

    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if(candidates == null || candidates.size() == 0) return result;

        ArrayList<Integer> current = new ArrayList<Integer>();
        Collections.sort(candidates);

        combinationSum(candidates, target, 0, current, result);

        return result;
    }

    public static void combinationSum(ArrayList<Integer> candidates, int target, int j, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> result){
        if(target == 0){
            ArrayList<Integer> temp = new ArrayList<Integer>(curr);
            result.add(temp);
            return;
        }

        ArrayList<Integer> candidatesCopy = new ArrayList<>(candidates);
        for(int i=j; i<candidates.size(); i++) {
            if (target < candidates.get(i))
                return;

            curr.add(candidates.get(i));
            candidatesCopy.remove(i);
            combinationSum(candidatesCopy, target - candidates.get(i), i, curr, result);
            candidatesCopy.add(i, candidates.get(i));
            curr.remove(curr.size() - 1);
            while (i < candidates.size()-1 && candidates.get(i).equals(candidates.get(i + 1)))
                i++;
        }
    }
}
