package Math;

import java.util.ArrayList;
import java.util.Collections;

public class ReArrangeArray {

    public static void main(String[] args) {

    }

    static void arrange(ArrayList<Integer> a) {
        int n = a.size();
        //increase all values by (arr[arr[i]]%n)*n
        for (int i = 0; i < n; i++)
            a.set(i, a.get(i) + (a.get(a.get(i)) % n) * n);

        //divide all values by n
        for (int i = 0; i < n; i++)
            a.set(i,a.get(i) / n);
    }
}
