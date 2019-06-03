package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class BestTimeToBuyStocksI {
    public static void main(String[] args){
        System.out.println(maxProfit(new ArrayList<>(Arrays.asList(1, 2))));
        System.out.println(maxProfit(new ArrayList<>(Arrays.asList(8, 7, 9, 22, 5))));
        System.out.println(maxProfit(new ArrayList<>(Arrays.asList(8, 7, 9, 5, 22))));

    }

    public static int maxProfit(final List<Integer> A) {
        if(A.size() < 2)
            return 0;

       int minPrice = Integer.MAX_VALUE;
       int ans = 0;
       for(int a : A){
           minPrice = Math.min(minPrice, a);
           ans = Math.max(ans, a - minPrice);
       }

       return ans;
    }
}
