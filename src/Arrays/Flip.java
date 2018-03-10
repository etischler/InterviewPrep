package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Flip {

    public static void main(String[] args) {
        String A1 = "010";
        System.out.println(flip(A1));

        String A2 = "111";
        System.out.println(flip(A2));

        String A3 = "1101";
        System.out.println(flip(A3));

        String A4 = "1101010001";
        System.out.println(flip(A4));


    }

    static ArrayList<Integer> flip(String A) {

        int max = 0;
        int currentmax = 0;
        int left = 1;
        int right = 1;
        int currLeft = 1;
        int currRight = 1;
        int index = 1;
        for(char a : A.toCharArray()) {
            if(currentmax >= (a==0 ? 1 : 0)) {
                currRight = index;
            }
            else{
                currLeft = index;
                currRight = index;
                currentmax = 0;
            }
            if(a=='0')
                currentmax++;
            else
                currentmax--;
            if(currentmax > max) {
                max = currentmax;
                left = currLeft;
                right = currRight;
            }
            index++;
        }
        return max == 0 ? new ArrayList<>() : new ArrayList<>(Arrays.asList(left,right));
    }
}
