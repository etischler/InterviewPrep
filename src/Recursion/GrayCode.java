package Recursion;

import java.util.ArrayList;
import java.util.Collections;

public class GrayCode {


    public static void main(String[] args){
        System.out.println(grayCode(2));
    }

    public static ArrayList<Integer> grayCode(int a) {
        if(a==0){
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(0);
            return result;
        }

        ArrayList<Integer> result = grayCode(a-1);
        int numToAdd = 1<<(a-1);

        for(int i=result.size()-1; i>=0; i--){
            result.add(numToAdd+result.get(i));
        }

        return result;
    }
}
