package Greedy;
import java.util.*;


public class MajorityElement {

    public static void main(String[] args) {
        System.out.println(majorityElement(new ArrayList<>(Arrays.asList(1, 1, 2))));
        System.out.println(majorityElement(new ArrayList<>(Arrays.asList(2, 1, 2))));
    }

    static int majorityElement(final List<Integer> A) {

        Map<Integer, Integer> map = new HashMap<>();
        int majorityElement = 0;
        int majorityElementCount = 0;
        for(int i = 0; i < A.size(); i++){
            int currVal = A.get(i);
            if(!map.containsKey(currVal)){
                map.put(currVal, 1);
            }
            else{
                map.put(currVal, map.get(currVal) + 1);
            }
            int currCount = map.get(currVal);
            if(currCount > majorityElementCount){
                majorityElement = currVal;
                majorityElementCount = currCount;
            }

        }

        return majorityElement;

    }

}
