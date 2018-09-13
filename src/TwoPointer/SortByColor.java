package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;

public class SortByColor {

    public static void main(String[] args) {
        sortColors(new ArrayList<>(Arrays.asList(0,1,2,0,1,2)));
    }

    static void sortColors(ArrayList<Integer> a) {
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;

        for(int i = 0; i < a.size(); i++){
            if(a.get(i) == 0)
                zeroCount++;
            if(a.get(i) == 1)
                oneCount++;
            if(a.get(i) == 2)
                twoCount++;
        }

        int index = 0;
        while(zeroCount > 0){
            a.set(index, 0);
            index++;
            zeroCount--;
        }
        while(oneCount > 0){
            a.set(index, 1);
            index++;
            oneCount--;
        }
        while(twoCount > 0){
            a.set(index, 2);
            index++;
            twoCount--;
        }
        System.out.println(a);
    }
}
