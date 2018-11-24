package Recursion;

import java.lang.reflect.Array;
import java.util.*;

public class Subsets {

    public static void main(String[] args) {
        System.out.println(subsets(new ArrayList<>(Arrays.asList(1, 2, 3))));
    }

    static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        if(A == null)
            return null;
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i < A.size(); i++){
            ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();

            for(ArrayList<Integer> list : result){
                temp.add(new ArrayList<Integer>(list));
            }
//            System.out.println(" temp has: " );
//            for(ArrayList<Integer> list : temp)
//                System.out.println("\t" + list);

            for(ArrayList<Integer> list : temp){
                list.add(A.get(i));
            }
            ArrayList<Integer> single = new ArrayList<Integer>();
            single.add(A.get(i));
            temp.add(single);


            result.addAll(temp);
        }
        result.add(0, new ArrayList<Integer>());
        //Collections.sort(result);
        Collections.sort(result, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                int an = a.size();
                int bn = b.size();
                for (int i = 0; i < Math.min(an, bn); i++) {
                    int cmp = Integer.compare(a.get(i), b.get(i));
                    if (cmp != 0)
                        return cmp;
                }
                return Integer.compare(a.size(), b.size());
            }
        });

        return result;
    }
}
