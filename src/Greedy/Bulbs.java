package Greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class Bulbs {

    public static void main(String[] args) {
        System.out.println(bulbs(new ArrayList<>(Arrays.asList(0,1,0,1))));
    }

    /*
        switchCount = 0
        same = true
        for the switches:
            if currBulb is off and same:
                flip switch
                same = false
                switchCount++
            elif currBulb is on and !same:
                same as above w/ same = true

        return switchCount;



     */
    static int bulbs(ArrayList<Integer> A) {
        int switchCount = 0;
        boolean same = true;
        for(int i = 0; i < A.size(); i++){
            boolean bulbOn = A.get(i) == 1;
            if(!bulbOn && same){
                //A.set(i, 1);
                same = false;
                switchCount++;
            }
            else if(bulbOn && !same){
                //A.set(i, 1);
                same = true;
                switchCount++;
            }
        }
        return switchCount;
    }
}
