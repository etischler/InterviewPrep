package BinarySearch;

import java.util.Arrays;
import java.util.List;

public class RotatedSortedArraySearch {

    public static void main(String[] args) {
        System.out.println(search(Arrays.asList(4, 5, 6, 7, 0, 1, 2) , 4));

        System.out.println(search(Arrays.asList(192, 194, 197, 198, 199, 200, 201, 203, 204, 2, 3, 4, 7, 9, 10, 11, 14, 15, 16, 17, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 33, 34, 35, 36, 39, 40, 42, 43, 46, 47, 50, 51, 52, 53, 55, 57, 59, 60, 64, 66, 68, 70, 71, 72, 75, 76, 78, 85, 86, 87, 91, 92, 94, 95, 96, 99, 102, 105, 106, 107, 109, 111, 113, 114, 115, 119, 120, 121, 123, 125, 129, 130, 131, 133, 134, 137, 138, 139, 140, 141, 142, 143, 145, 146, 149, 151, 152, 156, 160, 161, 165, 167, 168, 170, 171, 176, 177, 178, 179, 180, 181, 182, 185, 186, 190) , 70));

        System.out.println(search(Arrays.asList(19, 20, 21, 22, 28, 29, 32, 36, 39, 40, 41, 42, 43, 45, 48, 49, 51, 54, 55, 56, 58, 60, 61, 62, 65, 67, 69, 71, 72, 74, 75, 78, 81, 84, 85, 87, 89, 92, 94, 95, 96, 97, 98, 99, 100, 105, 107, 108, 109, 110, 112, 113, 115, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 128, 130, 131, 133, 134, 135, 136, 137, 138, 139, 141, 142, 144, 146, 147, 148, 149, 150, 153, 155, 157, 159, 161, 163, 164, 169, 170, 175, 176, 179, 180, 185, 187, 188, 189, 192, 196, 199, 201, 203, 205, 3, 7, 9, 10, 12, 13, 17 ) , 6));

    }

    static int search(final List<Integer> a, int b) {



        int pivot = getPivot(a, b);
        //return pivot;

        if(b > a.get(((pivot + a.size() - 1) % a.size())))
            return -1;
        if(b < a.get(pivot))
            return -1;

        int leftIndex = 0;
        int rightIndex = a.size() - 1;
        int mid = (leftIndex + rightIndex)/2;

        while(leftIndex <= rightIndex) {
            if(b < a.get((mid + pivot) % a.size()))
                rightIndex = mid - 1;
            else if(b > a.get((mid + pivot) % a.size()))
                leftIndex = mid + 1;
            else
                return (mid + pivot) % a.size();

            mid = (leftIndex + rightIndex)/2;
        }

        return -1;
    }

    static int getPivot(final List<Integer> a, int b) {

        int leftIndex = 0;
        int rightIndex = a.size() - 1;
        int mid = (leftIndex + rightIndex)/2;

        while(a.get(leftIndex) > a.get(rightIndex)) {

            //if inconsistency left
            int leftIndexVal = a.get(leftIndex);
            int midVal = a.get(mid);
            if(leftIndexVal > midVal) {
                rightIndex = mid;
            }

            //if inconsistency right

            else if(midVal > a.get(rightIndex)){
                int rightIndexVal = a.get(rightIndex) ;
                leftIndex = mid;
            }

            mid = (leftIndex + rightIndex)/2;
            if(leftIndex == mid)
                return rightIndex;
        }

        return leftIndex;
    }
}
