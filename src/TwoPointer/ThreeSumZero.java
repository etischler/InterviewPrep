package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ThreeSumZero {

    public static void main(String[] args) {
        System.out.println(threeSum(new ArrayList<>(Arrays.asList(-1,0,1,2,-1,-4))));
    }

    static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Set<ArrayList<Integer>> tripletSet = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int B = 0;
        Collections.sort(A);

        for(int i = 0; i < A.size(); i++){
            int j = i+1;
            int k = A.size()-1;
            while(j < k){
                int sum = A.get(i) + A.get(j) + A.get(k);
                int diff = Math.abs(sum - B);
                if(diff == 0){
                    ArrayList<Integer> currList = new ArrayList<>(Arrays.asList(A.get(i),A.get(j),A.get(k)));
                    Collections.sort(currList);
                    tripletSet.add(currList);
                }

                if(diff < min){
                    min = diff;
                }
                if(sum <= B)
                    j++;
                else
                    k--;
            }
        }
        return new ArrayList<>(tripletSet.stream().collect(Collectors.toList()));

    }
}
