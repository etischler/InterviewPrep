package Recursion;

import java.util.ArrayList;
import java.util.Comparator;

public class FirstElementComparator implements Comparator<ArrayList<Integer>> {

    @Override
    public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
        if(o1.size() == 0)
            return -1;
        if(o2.size() == 0)
            return 1;
        return o1.get(0).compareTo(o2.get(0));
    }
}
