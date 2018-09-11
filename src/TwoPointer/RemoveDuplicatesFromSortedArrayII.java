package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {

    public static void main(String[] args) {
        //0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3
        System.out.println(removeDuplicates(new ArrayList<>(Arrays.asList(1,1,1,2))));
        System.out.println(removeDuplicates(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3))));
    }

    static int removeDuplicates(ArrayList<Integer> a) {
        if(a.size() == 0)
            return 0;
        int size = 1;
        int lastVal = a.get(0);
        int dupCount = 0;
        for(int i = 1; i < a.size(); i++) {
            if(lastVal != a.get(i)) {
                lastVal = a.get(i);
                size++;
                a.set(size - 1, a.get(i));
                dupCount = 0;
            }
            else if(dupCount == 0){
                size++;
                a.set(size - 1, a.get(i));
                dupCount++;
            }

        }
        //System.out.println(a);
        return size;
    }
}
