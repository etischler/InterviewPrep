package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixSearch {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        a.add(new ArrayList<>(Arrays.asList(1,3,5,7)));
        a.add(new ArrayList<>(Arrays.asList(10,11,16,20)));
        a.add(new ArrayList<>(Arrays.asList(23,30,34,50)));

        System.out.println(searchMatrix(a,3));

        ArrayList<ArrayList<Integer>> b = new ArrayList<>();
        b.add(new ArrayList<>(Arrays.asList(22,32,67)));
        System.out.println(searchMatrix(b,93));
    }

    static int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {

        if(b < a.get(0).get(0))
            return 0;
        if(b > a.get(a.size()-1).get(a.get(0).size()-1))
            return 0;

        int rowLength = a.get(0).size();
        int low = 0;
        int high = rowLength * a.size();

        int midRow = ((low+high)/2) / rowLength;
        int midCol = ((low+high)/2) % rowLength;

        while(low <= high) {
            if(b == a.get(midRow).get(midCol))
                return 1;
            else if(b < a.get(midRow).get(midCol)){
                high = (((midRow+1) * rowLength) - (rowLength - midCol)) - 1;
                midRow = ((low+high)/2) / rowLength;
                midCol = ((low+high)/2) % rowLength;
            }
            else {
                low = ((midRow+1) * rowLength) - (rowLength - midCol) + 1;
                midRow = ((low+high)/2) / rowLength;
                midCol = ((low+high)/2) % rowLength;
            }
        }
        return 0;

    }
}
