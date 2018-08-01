package ThreePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfSortedArrays {

    public static void main(String[] args) {
        System.out.println(intersect(new ArrayList<>(Arrays.asList(1 ,2, 3, 3, 4, 5, 6)), new ArrayList<>(Arrays.asList(3, 3, 5))));
        System.out.println(intersect(new ArrayList<>(Arrays.asList(1, 2, 3, 3, 4, 5, 6)), new ArrayList<>(Arrays.asList(3, 5))));
        System.out.println(intersect(new ArrayList<>(Arrays.asList(1, 3, 8, 10, 13, 13, 16, 16, 16, 18, 21, 23, 24, 31, 31, 31, 33, 35, 35, 37, 37, 38, 40, 41, 43, 47, 47, 48, 48, 52, 52, 53, 53, 55, 56, 60, 60, 61, 61, 63, 63, 64, 66, 67, 67, 68, 69, 71, 80, 80, 80, 80, 80, 80, 81, 85, 87, 87, 88, 89, 90, 94, 95, 97, 98, 98, 100, 101)), new ArrayList<>(Arrays.asList(5, 7, 14, 14, 25, 28, 28, 34, 35, 38, 38, 39, 46, 53, 65, 67, 69, 70, 78, 82, 94, 94, 98))));
    }

    static ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        int indexA = 0;
        int indexB = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while(indexA < A.size() && indexB < B.size()) {
            if(A.get(indexA).intValue() == (B.get(indexB)).intValue()) {
                ans.add(A.get(indexA));
                indexA++;
                indexB++;
            }
            else if(A.get(indexA) < B.get(indexB)) {
                indexA++;
            }
            else if(B.get(indexB) < A.get(indexA)){
                indexB++;
            }
        }
        return ans;
    }
}
