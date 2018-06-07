package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchForARange {

    public static void main(String[] args) {

        System.out.println(searchRange(Arrays.asList(5,7,7,8,8,10), 8));

    }

    static ArrayList<Integer> searchRange(final List<Integer> a, int b) {

        if(b > a.get(a.size()-1))
            return new ArrayList<>(Arrays.asList(-1,-1));
        if(b < a.get(0))
            return new ArrayList<>(Arrays.asList(-1,-1));

        int leftIndex = 0;
        int rightIndex = a.size() - 1;
        int mid = (leftIndex + rightIndex)/2;
       int finalLeft = -1;
        while(leftIndex <= rightIndex) {
            if(b < a.get(mid))
                rightIndex = mid - 1;
            else if(b > a.get(mid))
                leftIndex = mid + 1;
            else
            {
                finalLeft = mid;
                rightIndex = mid - 1;
            }

            mid = (leftIndex + rightIndex)/2;
        }

        if(finalLeft == -1)
            return new ArrayList<>(Arrays.asList(-1, -1));

        leftIndex = 0;
        rightIndex = a.size() - 1;
        mid = (leftIndex + rightIndex)/2;
        int finalRight = -1;
        while(leftIndex <= rightIndex) {
            if (b < a.get(mid))
                rightIndex = mid - 1;
            else if (b > a.get(mid))
                leftIndex = mid + 1;
            else {
                finalRight = mid;
                leftIndex = mid + 1;
            }
            mid = (leftIndex + rightIndex)/2;
        }

        return new ArrayList<>(Arrays.asList(finalLeft,finalRight));

    }
}
