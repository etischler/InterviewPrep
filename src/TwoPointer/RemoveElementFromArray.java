package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveElementFromArray {

    public static void main(String[] args) {
        System.out.println(removeElement(new ArrayList<>(Arrays.asList(4, 1, 1, 2, 1, 3)), 1));
    }

    static int removeElement(ArrayList<Integer> a, int b) {
        int index = 0;
        for(int i = 0; i < a.size(); i++) {
            if(a.get(i) != b){
                a.set(index, a.get(i));
                index++;
            }
        }
        System.out.println(a);
        return index;

    }
}
