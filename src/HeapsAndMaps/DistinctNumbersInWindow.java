package HeapsAndMaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DistinctNumbersInWindow {

    public static void main(String[] args) {
        System.out.println(dNums(new ArrayList<>(Arrays.asList(1, 2, 1, 3, 4, 3)), 3));
    }

    static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        if (B > A.size())
            return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < A.size(); i++){
            if(i >= B){
                ans.add(map.keySet().size());
                removeValue(map, A.get(i-B));
            }
           addValue(map, A.get(i));
        }

        ans.add(map.keySet().size());

        return ans;
    }

    private static void addValue(Map<Integer, Integer> map, Integer integer) {
        if(!map.containsKey(integer))
            map.put(integer, 1);
        else
            map.put(integer, map.get(integer) + 1);
    }
    private static void removeValue(Map<Integer, Integer> map, Integer integer) {
        if(map.get(integer) > 1)
            map.put(integer, map.get(integer) - 1);
        else
            map.remove(integer);
    }
}
