package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class SortedInsertPosition {

    public static void main(String[] args) {

        System.out.println(searchInsert(new ArrayList<>(Arrays.asList(1,3,5,6)), 5));
        System.out.println(searchInsert(new ArrayList<>(Arrays.asList(1,3,5,6)), 2));
        System.out.println(searchInsert(new ArrayList<>(Arrays.asList(1,3,5,6)), 7));
        System.out.println(searchInsert(new ArrayList<>(Arrays.asList(1,3,5,6)), 0));
    }

    static int searchInsert(ArrayList<Integer> a, int b) {

        if(b > a.get(a.size()-1))
            return a.size();
        if(b < a.get(0))
            return 0;

        int leftIndex = 0;
        int rightIndex = a.size() - 1;
        int mid = (leftIndex + rightIndex)/2;

        while(leftIndex <= rightIndex) {
            if(b < a.get(mid))
                rightIndex = mid - 1;
            else if(b > a.get(mid))
                leftIndex = mid + 1;
            else
                return mid;

            mid = (leftIndex + rightIndex)/2;
        }

        return rightIndex + 1;

    }
}
