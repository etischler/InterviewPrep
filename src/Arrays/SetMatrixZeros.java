package Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class SetMatrixZeros {

    public static void main(String[] args) {

    }

    public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
        if(a.size() == 0)
            return;
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();

        for(int i = 0; i < a.size(); i++) {
            for(int j = 0; j < a.get(0).size(); j++) {
                if(a.get(i).get(j) == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int currRow : rows) {
            for(int j = 0; j < a.get(0).size(); j++){
                a.get(currRow).set(j, 0);
            }
        }

        for(int currCol : cols) {
            for(int i = 0; i < a.size(); i++){
                a.get(i).set(currCol, 0);
            }
        }

    }
}
