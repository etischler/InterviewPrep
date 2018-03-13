package Arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class AntiDiagonals {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> A1 = new ArrayList<>();
        A1.add(new ArrayList<>(Arrays.asList(1,2,3)));
        A1.add(new ArrayList<>(Arrays.asList(4,5,6)));
        A1.add(new ArrayList<>(Arrays.asList(7,8,9)));

        System.out.println(diagonal(A1));

    }

    /*
        if(A.size() == 1 && A.get(size - 1) == 0)
            return A
        Arraylist<Arraylist> ans;
        for 2nd array:
            int x = 2ndArrayVal;
            int y = 1stArrayVal;
            ans.add(new arraylist)
            ans.get(size - 1).add(A.get(0).get(i)
            while(--x  >= 0 && --y >= 0)
                ans.get(ans.size - 1).add(A.get(y).get(x))

        return ans;

     */

    static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {

        if(A.size() == 1 && A.get(0).size() == 0)
            return A;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < A.get(0).size(); i++) {
            int x = i;
            int y = 0;
            ans.add(new ArrayList<>());
            ans.get(ans.size() - 1).add(A.get(0).get(i));
            while(--x >= 0 && ++y < A.size())
                ans.get(ans.size() - 1).add(A.get(y).get(x));
        }

        for(int i = 1; i < A.get(0).size(); i++) {
            int x = A.get(0).size() - 1;
            int y = i;
            ans.add(new ArrayList<>());
            ans.get(ans.size() - 1).add(A.get(i).get(A.get(0).size() - 1));
            while(--x >= 0 && ++y < A.size())
                ans.get(ans.size() - 1).add(A.get(y).get(x));
        }

        return ans;
    }
}
