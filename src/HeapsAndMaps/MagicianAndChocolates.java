package HeapsAndMaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class MagicianAndChocolates {

    public static void main(String[] args) {
        System.out.println(nchoc(3, new ArrayList<>(Arrays.asList(6, 5))));
        System.out.println(nchoc(10, new ArrayList<>(Arrays.asList(2147483647, 2000000014, 2147483647))));
    }

    static int nchoc(int A, ArrayList<Integer> B) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < B.size(); i++){
            map.put(B.get(i), i);
        }
        int ans = 0;
        for(int i = A; i > 0; i--){
            int valKey = map.lastEntry().getValue();
            int val = map.lastEntry().getKey();
            ans += val;
            map.remove(val);
            int addingBack =( int) Math.floor(val / 2.0);
            map.put(addingBack, valKey);
        }
        return ans % ((int) Math.pow(10, 9) + 7);
    }
}
